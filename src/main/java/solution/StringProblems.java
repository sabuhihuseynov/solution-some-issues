package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class StringProblems {

    public static Boolean isAnagramsBoolean(String a, String b) {
        char[] A = a.toLowerCase().toCharArray();
        char[] B = b.toLowerCase().toCharArray();

        java.util.Arrays.sort(A);
        java.util.Arrays.sort(B);

        return String.valueOf(A).compareTo(String.valueOf(B)) == 0 ?
                Boolean.TRUE : Boolean.FALSE;
    }

    public void stringTokens(String s) {
        String[] arrs = s.trim().split("[ !,?._'@]+");
        if (s.trim().isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(arrs.length);
            for (String x : arrs) {
                System.out.println(x);
            }
        }
    }

    public void isValidUsername() {
        final String regularExpression = "^[a-zA-Z][a-zA-Z0-9_]{7,29}$";
        //^ sətrin əvvəlində yoxlama $ sətrin sonunda yoxlama.{7,29}
        // stringin uzunulugunun olabiləcəyi aralıq
        final Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while (n-- != 0) {
            String userName = sc.nextLine();

            if (userName.matches(regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }

    public int lengthOfLastWorld(String ss) {
        int i = ss.length() - 1;
        int x = 0, count = 0;

        while (i >= 0) {
            if (ss.charAt(i) == ' ') {
                if (x == -1) {
                    return count;
                }
            } else {
                count++;
                x = -1;
            }
            i--;
        }
        return count;
    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();

        String[] str = s.split(" ");

        if (str.length != pattern.length()) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char a = pattern.charAt(i);
            if (!map.isEmpty() && map.containsKey(a) && !map.get(a).equals(str[i])) return false;

            if (!map.isEmpty() && map.containsKey(a) && map.get(a).equals(str[i])) continue;

            if (!map.isEmpty() && map.containsValue(str[i])) return false;

            map.put(a, str[i]);
        }
        return true;
    }

    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public boolean repeatedSubstringPattern(String s) {
        String text = s + s;
        String pattern = s;
        int pos = text.indexOf(pattern, 1);
        if (pos != -1 && pos < s.length())
            return true;
        return false;
    }

    public boolean detectCapitalUse(String word) {
        if (word.length() == 0 || word.length() == 1) return true;

        if (Character.isUpperCase(word.charAt(0))) {
            boolean isFirstCharacter = Character.isUpperCase(word.charAt(1));
            for (int i = 2; i < word.length(); i++) {
                boolean currentCharState = Character.isUpperCase(word.charAt(i));
                if (currentCharState != isFirstCharacter) return false;
            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) return false;
            }
        }
        return true;
    }

    public List<String> getRegistrationStatus(List<String> passwords, int k) {
        List<String> registrationStatus = new ArrayList<>();
        Map<String, Integer> passwordCounts = new HashMap<>();

        for (String password : passwords) {
            if (passwordCounts.containsKey(password)) {
                int count = passwordCounts.get(password);
                if (count < k) {
                    passwordCounts.put(password, count + 1);
                    registrationStatus.add("ACCEPT");
                } else {
                    registrationStatus.add("REJECT");
                }
            } else {
                passwordCounts.put(password, 1);
                registrationStatus.add("ACCEPT");
            }
        }
        return registrationStatus;
    }

    public boolean judgeCircle(String moves) {
        char[] arrMoves = moves.toCharArray();
        int rl = 0, ud = 0;
        for (char arrMove : arrMoves) {
            if (arrMove == 'U') {
                ud++;
            } else if (arrMove == 'D') {
                ud--;
            } else if (arrMove == 'R') {
                rl++;
            } else if (arrMove == 'L') {
                rl--;
            }
        }
        return ud == 0 && rl == 0;
    }

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
        }
        return true;
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }

    public String hackerrankInString(String s) {

        String expectedWord = "hackerrank";
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            if (index == 10) {
                break;
            }
            if (expectedWord.charAt(index) == s.charAt(i)) {
                index++;
            }
        }
        if (index == 10) {
            return "YES";
        } else return "NO";
    }

    public List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        List<Integer> result = new ArrayList<>();

        // Step 1: Build a frequency map of sorted strings in the dictionary
        Map<String, Integer> frequencyMap = buildFrequencyMap(dictionary);

        // Step 2: Count anagrams for each query string
        for (String word : query) {
            int count = countAnagrams(word, frequencyMap);
            result.add(count);
        }

        return result;
    }

    private static Map<String, Integer> buildFrequencyMap(List<String> strings) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : strings) {
            String sortedWord = sortString(word);
            frequencyMap.put(sortedWord, frequencyMap.getOrDefault(sortedWord, 0) + 1);
        }
        return frequencyMap;
    }

    private static int countAnagrams(String word, Map<String, Integer> frequencyMap) {
        String sortedWord = sortString(word);
        return frequencyMap.getOrDefault(sortedWord, 0);
    }

    private static String sortString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public String decryptPassword(String s) {
        StringBuilder password = new StringBuilder();
        char[] encryptedPassword = s.toCharArray();
        int i = encryptedPassword.length - 1;
        int j = 0;
        while (i >= j) {
            if (encryptedPassword[i] == '*') {
                password.append(encryptedPassword[i - 2]);
                password.append(encryptedPassword[i - 1]);
                i = i - 3;
                continue;
            }
            if (encryptedPassword[i] == '0') {
                password.append(encryptedPassword[j]);
                j++;
                i = i - 1;
                continue;
            }
            password.append(encryptedPassword[i]);
            i = i - 1;
        }
        return password.reverse().toString();
    }

    public String pangrams(String s) {
        String lower = s.toLowerCase();
        lower = lower.replace(" ", "");

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < lower.length(); i++) {
            set.add(lower.charAt(i));
        }
        if (set.size() != 26) {
            return "not pangram";
        } else return "pangram";
    }

    public int renameFile(String newName, String oldName) {
        int mod = (int) (1e9 + 7);
        int[][] dp = new int[newName.length() + 1][oldName.length() + 1];

        for (int i = 0; i <= oldName.length(); i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= newName.length(); i++) {
            for (int j = 1; j <= oldName.length(); j++) {
                dp[i][j] = dp[i][j - 1];
                if (newName.charAt(i - 1) == oldName.charAt(j - 1)) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                }
            }
        }
        return dp[newName.length()][oldName.length()];
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int result = 0;
        char[] jewelsChar = jewels.toCharArray();
        char[] stonesChar = stones.toCharArray();

        Map<Character, Integer> jewelsMap = new HashMap<>();
        for (char c : jewelsChar) {
            jewelsMap.put(c, 0);
        }
        for (char c : stonesChar) {
            if (jewelsMap.containsKey(c)) {
                result++;
            }
        }
        return result;
    }

    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return mystery(b) + mystery(a);
    }

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) return true;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            sb.append(s.substring(1)).append(s.charAt(0));
            s = sb.toString();
            if (s.equals(goal)) return true;
            sb.setLength(0);
        }
        return false;
    }

    public static int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashMap<Character, String> map = new HashMap<>();
        for (char i = 'a'; i <= 'z'; i++) {
            map.put(i, morse[i - 'a']);
        }
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                sb.append(map.get(c));
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (sum + widths[s.charAt(i) - 'a'] <= 100) {
                sum += widths[s.charAt(i) - 'a'];
            } else {
                lines++;
                sum = widths[s.charAt(i) - 'a'];
            }
        }
        return new int[]{lines, sum};
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().replaceAll("\\W+", " ").split("\\s+");
        HashMap<String, Integer> h = new HashMap<>();
        for (String word : words) {

            int count = h.getOrDefault(word, 0);
            h.put(word, count + 1);
        }
        for (int i = 0; i < banned.length; i++) {
            h.remove(banned[i]);
        }
        int mx = Integer.MIN_VALUE;
        String ans = "";
        for (String m : h.keySet()) {
            int p = h.get(m);
            if (p > mx) {
                ans = m;
                mx = p;
            }
        }
        return ans;
    }

    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        int currentIndex = -1;
        int leftIndex = findNextOccurance(s, -1, c);
        fillCreek(result, -leftIndex, leftIndex);
        while (true) {
            int rightIndex = findNextOccurance(s, leftIndex, c);
            if (rightIndex == -1) {
                fillCreek(result, leftIndex, s.length() + (s.length() - 1 - leftIndex));
                break;
            }
            fillCreek(result, leftIndex, rightIndex);
            leftIndex = rightIndex;
        }
        return result;
    }

    public static void fillCreek(int[] result, int leftIndex, int rightIndex) {
        int from = Math.max(leftIndex, 0);
        int to = Math.min(rightIndex, result.length - 1);
        for (int i = from; i <= to; i++) {
            result[i] = Math.min(i - leftIndex, rightIndex - i);
        }
    }

    public static int findNextOccurance(String s, int fromIndex, char c) {
        for (int i = fromIndex + 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> resultList = new ArrayList<>();
        int pointer = 0;
        int length = s.length();
        while (pointer < length) {
            char character = s.charAt(pointer);
            int j = pointer;
            while (j < length && s.charAt(j) == s.charAt(pointer)) {
                j++;
            }
            if (j - pointer >= 3) {
                List<Integer> indexs = new ArrayList<>();
                indexs.add(pointer);
                indexs.add(j - 1);
                resultList.add(indexs);
            }
            pointer = j;
        }
        return resultList;
    }

    public boolean backspaceCompare(String s, String t) {
        return processBackspace(s).equals(processBackspace(t));
    }

    private String processBackspace(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.indexOf("#") >= 0) {
            if (sb.indexOf("#") == 0)
                sb.deleteCharAt(0);
            else
                sb.delete(sb.indexOf("#") - 1, sb.indexOf("#") + 1);
        }
        return sb.toString();
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> hm = new HashMap<>();
        String[] s1Arr = s1.split(" ");
        for (String s : s1Arr) {
            if (hm.containsKey(s)) hm.put(s, hm.get(s) + 1);
            else hm.put(s, 1);
            ;
        }
        String[] s2Arr = s2.split(" ");
        for (String s : s2Arr) {
            if (hm.containsKey(s)) hm.put(s, hm.get(s) + 1);
            else hm.put(s, 1);
        }

        ArrayList<String> resultList = new ArrayList<>();
        for (String s : hm.keySet()) {
            if (hm.get(s) == 1) resultList.add(s);
        }

        String[] resultArr = new String[resultList.size()];
        resultArr = resultList.toArray(resultArr);
        return resultArr;
    }

    public String reverseOnlyLetters(String s) {
        char temp[] = s.toCharArray();
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (Character.isAlphabetic(temp[low]) && Character.isAlphabetic(temp[high])) {
                char i = temp[low];
                temp[low] = temp[high];
                temp[high] = i;
                low++;
                high--;
            } else if (!Character.isAlphabetic(temp[low])) low++;
            else if (!Character.isAlphabetic(temp[high])) high--;
        }
        return String.valueOf(temp);
    }

    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String[] emailSplit = emails[i].split("@");
            String local = emailSplit[0];
            String domain = emailSplit[1];
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < local.length(); j++) {
                if (local.charAt(j) == '+') break;
                if (local.charAt(j) != '.') stringBuilder.append(local.charAt(j));
            }
            stringBuilder.append('@');
            stringBuilder.append(domain);
            set.add(stringBuilder.toString());
        }
        return set.size();
    }

    public int minDeletionSize(String[] strs) {
        int row = strs.length;
        int col = strs[0].length();
        int ans = 0;

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row - 1; j++) {
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public int numRookCaptures(char[][] board) {
        int rockI = 0, result = 0;
        boolean isBishopThere = false;
        int rockJ = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    rockI = i;
                    rockJ = j;
                    break;
                }
            }
        }
        for (int i = rockI; i < board.length; i++) {
            if (board[i][rockJ] == 'B') {
                isBishopThere = true;
            } else if (board[i][rockJ] == 'p' && !isBishopThere) {
                result++;
                break;
            }
        }
        isBishopThere = false;
        for (int i = rockI; i >= 0; i--) {
            if (board[i][rockJ] == 'B') {
                isBishopThere = true;
            } else if (board[i][rockJ] == 'p' && !isBishopThere) {
                result++;
                break;
            }
        }
        isBishopThere = false;
        for (int j = rockJ; j < board.length; j++) {
            if (board[rockI][j] == 'B') {
                isBishopThere = true;
            } else if (board[rockI][j] == 'p' && !isBishopThere) {
                result++;
                break;
            }
        }
        isBishopThere = false;
        for (int j = rockJ; j >= 0; j--) {
            if (board[rockI][j] == 'B') {
                isBishopThere = true;
            } else if (board[rockI][j] == 'p' && !isBishopThere) {
                result++;
                break;
            }
        }
        return result;
    }

    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (st.size() > 0 && st.peek() == s.charAt(i)) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : st) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public String removeDuplicatesOptimal(String s) {
        if (s == null) return null;

        char[] stack = new char[s.length()];
        int i = 0;

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (i > 0 && stack[i - 1] == c) {
                i--;
            } else {
                stack[i++] = c;
            }
        }
        return new String(stack, 0, i);
    }

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1))
            return "";
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();
        String[] words = text.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                list.add(words[i + 2]);
            }
        }
        return list.toArray(new String[0]);
    }

    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                sb.append('[');
                sb.append('.');
                sb.append(']');
            } else sb.append(address.charAt(i));
        }
        return sb.toString();
    }

    public int maxNumberOfBalloons(String text) {
        final int[][] cache = new int[2][5];
        cache[0][0] = 97;  // a
        cache[0][1] = 98;  // b
        cache[0][2] = 108; // l
        cache[0][3] = 110; // n
        cache[0][4] = 111; // o

        for (char ch : text.toCharArray()) {
            final int intValue = ch;
            for (int i = 0; i < 5; i++) {
                if (intValue == cache[0][i]) {
                    cache[1][i]++;
                    break;
                }
            }
        }
        cache[1][2] /= 2;
        cache[1][4] /= 2;

        int min = Integer.MAX_VALUE;
        for (int frequency : cache[1]) {
            min = Math.min(min, frequency);
        }

        return min;
    }

    public int balancedStringSplit(String s) {
        int l = 0;
        int r = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                r++;
            } else l++;

            if (r == l) {
                result++;
                r = 0;
                l = 0;
            }
        }
        return result;
    }

    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            int number;
            if (s.charAt(i) == '#') { // If it is a two-digit number
                number = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
                i -= 2;
            } else { // If it is a single-digit number
                number = s.charAt(i) - '0';
            }
            // Convert the numeric value to its alphabetic representation
            sb.append((char) (number + 96));
        }

        return sb.reverse().toString();
    }

    public int removePalindromeSub(String s) {
        if (s.contentEquals(new StringBuilder(s).reverse())) return 1;
        else return 2;
    }

    public String sortStringAsWanted(String s) {
        int[] freq = new int[26];
        int len = s.length();

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        while (len != 0) {

            //step 1-2-3
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    sb.append((char) (i + 'a'));
                    freq[i]--;
                    len--;
                }
            }

            //step 4-5-6
            for (int i = 25; i >= 0; i--) {
                if (freq[i] > 0) {
                    sb.append((char) (i + 'a'));
                    len--;
                    freq[i]--;
                }
            }
        }

        return sb.toString();
    }

    public List<String> stringMatching(String[] words) {
        List<String> stringMatchList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            boolean contain = checkContains(words, i);
            if (contain) {
                stringMatchList.add(words[i]);
            }
        }
        return stringMatchList;
    }

    private boolean checkContains(String[] words, int i) {
        for (int j = 0; j < words.length; j++) {
            if (i == j) continue;
            if (words[j].contains(words[i])) return true;
        }
        return false;
    }

    public String reformat(String s) {
        if (s.length() == 1)
            return s;
        int n = s.length();
        char[] res = new char[n];
        char[] digits = new char[n];
        char[] letters = new char[n];
        int digitsSize = 0;
        int lettersSize = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                digits[digitsSize++] = c;
            } else {
                letters[lettersSize++] = c;
            }
        }
        if (digitsSize == 0 || lettersSize == 0 || Math.abs(lettersSize - digitsSize) > 1)
            return "";
        int cur = 0;
        digitsSize--;
        lettersSize--;
        while (cur < n) {
            if (digitsSize > lettersSize) {
                if (digitsSize >= 0)
                    res[cur++] = digits[digitsSize--];
                if (lettersSize >= 0)
                    res[cur++] = letters[lettersSize--];

            } else {
                if (lettersSize >= 0)
                    res[cur++] = letters[lettersSize--];
                if (digitsSize >= 0)
                    res[cur++] = digits[digitsSize--];
            }
        }
        return String.valueOf(res);
    }

    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }
        String destination = paths.get(0).get(1);

        while (map.containsKey(destination)) {
            destination = map.get(destination);
        }
        return destination;
    }


}
