package org.example.solution.string_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StringEasyProblems {

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/number-of-segments-in-a-string/description/"> Number of Segments in a StringValid Perfect Square</a>
     **/
    public int countSegments(String s) {
        String[] strings = s.split(" ");
        int count = 0;
        for (String string : strings) {
            if (!string.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/number-of-segments-in-a-string/description/"> Number of Segments in a StringValid Perfect Square</a>
     **/
    public Boolean isAnagramsBoolean(String a, String b) {
        char[] A = a.toLowerCase().toCharArray();
        char[] B = b.toLowerCase().toCharArray();

        Arrays.sort(A);
        Arrays.sort(B);

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

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/length-of-last-word/description/"> Length of Last Word</a>
     **/
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

    /**
     * 1ms
     * 81.17%
     * <a href="https://leetcode.com/problems/word-pattern/description/"> Word Pattern</a>
     **/
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();

        String[] str = s.split(" ");

        if (str.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char a = pattern.charAt(i);
            if (!map.isEmpty() && map.containsKey(a) && !map.get(a).equals(str[i])) {
                return false;
            }

            if (!map.isEmpty() && map.containsKey(a) && map.get(a).equals(str[i])) {
                continue;
            }

            if (!map.isEmpty() && map.containsValue(str[i])) {
                return false;
            }

            map.put(a, str[i]);
        }
        return true;
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/reverse-string/description/"> Reverse String</a>
     **/
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 1ms
     * 91.75%
     * <a href="https://leetcode.com/problems/detect-capital/description/"> Detect Capital</a>
     **/
    public boolean detectCapitalUse(String word) {
        if (word.isEmpty() || word.length() == 1) {
            return true;
        }

        if (Character.isUpperCase(word.charAt(0))) {
            boolean isFirstCharacter = Character.isUpperCase(word.charAt(1));
            for (int i = 2; i < word.length(); i++) {
                boolean currentCharState = Character.isUpperCase(word.charAt(i));
                if (currentCharState != isFirstCharacter) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
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
        int rl = 0;
        int ud = 0;
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
        } else {
            return "NO";
        }
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

    private Map<String, Integer> buildFrequencyMap(List<String> strings) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : strings) {
            String sortedWord = sortString(word);
            frequencyMap.put(sortedWord, frequencyMap.getOrDefault(sortedWord, 0) + 1);
        }
        return frequencyMap;
    }

    private int countAnagrams(String word, Map<String, Integer> frequencyMap) {
        String sortedWord = sortString(word);
        return frequencyMap.getOrDefault(sortedWord, 0);
    }

    private String sortString(String str) {
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
                i--;
                continue;
            }
            password.append(encryptedPassword[i]);
            i--;
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
        } else {
            return "pangram";
        }
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

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/jewels-and-stones/description/"> Jewels and Stones</a>
     **/
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (int i = 0; i < jewels.length(); i++) {
            for (int j = 0; j < stones.length(); j++) {
                if (jewels.charAt(i) == stones.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public String mystery(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }
        String a = s.substring(0, n / 2);
        String b = s.substring(n / 2, n);
        return mystery(b) + mystery(a);
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/rotate-string/description/"> Rotate String</a>
     **/
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String concatenatedS = s + s;
        return concatenatedS.contains(goal);
    }

    /**
     * 2ms
     * 97.13%
     * <a href="https://leetcode.com/problems/unique-morse-code-words/description/"> Unique Morse Code Words</a>
     **/
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
                "--.."};
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

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/number-of-lines-to-write-string/description/"> Number of Lines To Write String</a>
     **/
    public int[] numberOfLines(final int[] widths, final String s) {
        int sum = 0;
        int lines = 1;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (sum + widths[idx] > 100) {
                lines++;
                sum = 0;
            }
            sum += widths[idx];
        }
        return new int[]{lines, sum};
    }

    /**
     * 16ms
     * 46.34%
     * <a href="https://leetcode.com/problems/most-common-word/description/"> Most Common Word</a>
     **/
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().replaceAll("\\W+", " ").split("\\s+");
        HashMap<String, Integer> h = new HashMap<>();
        for (String word : words) {

            int count = h.getOrDefault(word, 0);
            h.put(word, count + 1);
        }
        for (String s : banned) {
            h.remove(s);
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

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/shortest-distance-to-a-character/description/"> Shortest Distance to a Character</a>
     **/
    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
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

    public int findNextOccurance(String s, int fromIndex, char c) {
        for (int i = fromIndex + 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    public void fillCreek(int[] result, int leftIndex, int rightIndex) {
        int from = Math.max(leftIndex, 0);
        int to = Math.min(rightIndex, result.length - 1);
        for (int i = from; i <= to; i++) {
            result[i] = Math.min(i - leftIndex, rightIndex - i);
        }
    }

    /**
     * 1ms
     * 76.00%
     * <a href="https://leetcode.com/problems/backspace-string-compare/description/"> Backspace String Compare</a>
     **/
    public boolean backspaceCompare(String s, String t) {
        return processBackspace(s).equals(processBackspace(t));
    }

    private String processBackspace(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.indexOf("#") >= 0) {
            if (sb.indexOf("#") == 0) {
                sb.deleteCharAt(0);
            } else {
                sb.delete(sb.indexOf("#") - 1, sb.indexOf("#") + 1);
            }
        }
        return sb.toString();
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/reverse-only-letters/description/"> Reverse Only Letters</a>
     **/
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
            } else if (!Character.isAlphabetic(temp[low])) {
                low++;
            } else if (!Character.isAlphabetic(temp[high])) {
                high--;
            }
        }
        return String.valueOf(temp);
    }

    /**
     * 5ms
     * 99.06%
     * <a href="https://leetcode.com/problems/unique-email-addresses/description/"> Unique Email Addresses</a>
     **/
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String normalizedEmail = normalize(email);
            set.add(normalizedEmail);
        }
        return set.size();
    }

    private String normalize(String email) {
        int atIndex = email.indexOf("@");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < atIndex; i++) {
            char ch = email.charAt(i);
            if (ch == '.') continue;
            else if (ch == '+') break;
            sb.append(ch);
        }
        sb.append(email.substring(atIndex));
        return sb.toString();
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

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/"> Remove Duplicates from Sorted Array</a>
     **/
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        for (fast = 0; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast])
                nums[++slow] = nums[fast];
        }
        return ++slow;
    }

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/defanging-an-ip-address/description/"> Defanging an IP Address</a>
     **/
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                sb.append('[');
                sb.append('.');
                sb.append(']');
            } else {
                sb.append(address.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 2ms
     * 94.23%
     * <a href="https://leetcode.com/problems/maximum-number-of-balloons/description/"> Maximum Number of Balloons</a>
     **/
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

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/split-a-string-in-balanced-strings/description/"> Split a String in Balanced Strings</a>
     **/
    public int balancedStringSplit(String s) {
        int l = 0;
        int r = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                r++;
            } else {
                l++;
            }

            if (r == l) {
                result++;
                r = 0;
                l = 0;
            }
        }
        return result;
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/description/"> Decrypt String from Alphabet to Integer Mapping</a>
     **/
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

    /**
     * 1ms
     * 100.00%
     * <a href="https://leetcode.com/problems/string-matching-in-an-array/description/"> String Matching in an Array</a>
     **/
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
            if (i == j) {
                continue;
            }
            if (words[j].contains(words[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 1ms
     * 100.00%
     * <a href="https://leetcode.com/problems/reformat-the-string/description/"> Reformat The String</a>
     **/
    public String reformat(String s) {
        if (s.length() == 1) {
            return s;
        }
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
        if (digitsSize == 0 || lettersSize == 0 || Math.abs(lettersSize - digitsSize) > 1) {
            return "";
        }
        int cur = 0;
        digitsSize--;
        lettersSize--;
        while (cur < n) {
            if (digitsSize > lettersSize) {
                if (digitsSize >= 0) {
                    res[cur++] = digits[digitsSize--];
                }
                if (lettersSize >= 0) {
                    res[cur++] = letters[lettersSize--];
                }

            } else {
                if (lettersSize >= 0) {
                    res[cur++] = letters[lettersSize--];
                }
                if (digitsSize >= 0) {
                    res[cur++] = digits[digitsSize--];
                }
            }
        }
        return String.valueOf(res);
    }

    /**
     * 2ms
     * 100.00%
     * <a href="https://leetcode.com/problems/destination-city/description/"> Destination City</a>
     **/
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }
        String destination = paths.getFirst().get(1);

        while (map.containsKey(destination)) {
            destination = map.get(destination);
        }
        return destination;
    }

    public String[] splitStringBy2Characters(String str) {
        return str.split("(?<=\\G.{2})");
    }

    /**
     * 1ms
     * 99.69%
     * <a href="https://leetcode.com/problems/score-of-a-string/description/"> Score of a String</a>
     **/
    public int scoreOfString(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            sum += Math.abs(chars[i] - chars[i + 1]);
        }
        return sum;
    }

    /**
     * 1ms
     * 100.00%
     * <a href="https://leetcode.com/problems/convert-date-to-binary/description/"> Convert Date to Binary</a>
     **/
    public String convertDateToBinary(String date) {
        StringBuilder result = new StringBuilder();
        String year = date.substring(0, 4);
        String month = date.substring(5, 7);
        String day = date.substring(8, 10);
        result.append(Integer.toBinaryString(Integer.parseInt(year)));
        result.append("-");
        result.append(Integer.toBinaryString(Integer.parseInt(month)));
        result.append("-");
        result.append(Integer.toBinaryString(Integer.parseInt(day)));
        return result.toString();
    }


}
