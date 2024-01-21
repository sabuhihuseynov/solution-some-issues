package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class NumsProblem {

    int value(char r) {
        if (r == 'I')
            return 1;
        else if (r == 'V')
            return 5;
        else if (r == 'X')
            return 10;
        else if (r == 'L')
            return 50;
        else if (r == 'C')
            return 100;
        else if (r == 'D')
            return 500;
        else if (r == 'M')
            return 1000;
        else return -1;
    }

    // Leetcode problem 13.
    public int romanToInt(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int s1 = value(s.charAt(i));
            if (i + 1 < s.length()) {
                int s2 = value(s.charAt(i + 1));
                if (s1 >= s2) {
                    total = total + s1;
                } else {
                    total = total - s1;
                }
            } else {
                total = total + s1;
            }
        }
        return total;
    }


    public void isPrimeNumber() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String n = bufferedReader.readLine();
        BigInteger y = new BigInteger(n);
        if (n.length() <= 100 && y.isProbablePrime(1)) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
        bufferedReader.close();
    }

    public int[] plusOne(int digits[]) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            carry = sum > 1 ? 1 : 0;
            res.append(sum % 2);
        }
        if (carry != 0) res.append(carry);
        return res.reverse().toString();
    }

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;

        for (int i = 2; i < n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n - 1];
    }

    public int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int op = 0;
        int pist = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lsf) {
                lsf = prices[i];
            }
            pist = prices[i] - lsf;
            if (op < pist) {
                op = pist;
            }
        }
        return op;

    }

    public int singleNumber(int[] nums) {
        int ans = 0; //since XOR with 0 returns same number
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];  // ans = (ans) XOR (array element at i)
        }
        return ans;
    }

    public boolean isHappy(int n) {
        do {
            n = HappyNumber(n);
        } while (n != 1 && n != 4);

        if (n == 1) {
            return true;
        }
        return false;
    }

    static int HappyNumber(int N) {

        int sum = 0;
        while (N > 0) {
            int Rem = N % 10;
            N /= 10;
            sum += (Rem * Rem);
        }
        return sum;
    }

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], 1);
        }
        return false;
    }

    public boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (n < 1) return false;
        if (n % 2 != 0) {
            return false;
        }
        return (isPowerOfTwo(n / 2));
    }

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 0 && n % 5 == 0) {
            n = n / 5;
        }
        while (n > 0 && n % 3 == 0) {
            n = n / 3;
        }
        while (n > 0 && n % 2 == 0) {
            n = n / 2;
        }
        return n == 1;
    }

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                continue;
            } else {
                int j = i;
                while (j < n - 1 && nums[j] == 0) {
                    j++;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }

    public boolean canWinNim(int n) {
        if (n % 4 == 0)
            return false;
        else
            return true;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums1) {
            s.add(num);
        }
        Set<Integer> t = new HashSet<>();
        for (int num : nums2) {
            if (s.contains(num)) {
                t.add(num);
            }
        }
        int[] res = new int[t.size()];
        int i = 0;
        for (int num : t) {
            res[i++] = num;
        }
        return res;
    }

    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        long i = 2;
        long l = num / 2;
        while (i <= l) {
            long mid = i + (l - i) / 2;

            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                i = mid + 1;
            } else {
                l = mid - 1;
            }

        }
        return false;
    }

    public int countSegments(String s) {
        String[] strings = s.split(" ");
        int count = 0;
        for (String string : strings) {
            if (!string.equals("")) {
                count++;
            }
        }
        return count;
    }

    public int arrangeCoins(int n) {
        int l = 0, r = n;
        int x, s;
        while (l <= r) {
            x = l + (r - l) / 2;
            s = x * (x + 1) / 2;
            if (s == n) {
                return x;
            }
            if (n < s) {
                r = x - 1;
            } else {
                l = x + 1;
            }
        }
        return r;
    }

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)// base case
            return 0;

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count += 4;
                    if (j - 1 >= 0 && grid[i][j - 1] == 1)
                        count -= 2;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1)
                        count -= 2;
                }
            }
        }
        return count;
    }

    public int findComplement(int num) {
        int s = 0;
        int i = 0;
        while (num != 0) {
            if ((num & 1) != 1) {
                s = s + (int) Math.pow(2, i);
            }
            i++;
            num = (num >> 1);

        }
        return s;
    }

    public boolean checkPerfectNumber(int num) {
        int sum = 1;
        if (num == 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        if (sum == num) {
            return true;
        }
        return false;
    }

    public Integer func(Integer a, Integer b) {
        if (b == 0) return 1;
        Integer temp = func(a, b / 2);
        if (b % 2 != 0) return temp * temp * a;
        else return temp * temp;
    }

    public int findLowestStartingStair(List<Integer> jumps) {
        int currentStair = 0;
        int minStair = Integer.MAX_VALUE;

        for (int jump : jumps) {
            currentStair += jump;
            if (currentStair < minStair) {
                minStair = currentStair;
            }
        }
        return Math.max(1, 1 - minStair);
    }

    public void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public int maximumProduct(int[] nums) {
        if (nums.length > 3) {
            for (int i = 0; i <= 2; i++) {
                int temp;
                for (int j = 0; j <= nums.length - 2; j++) {
                    if (nums[j] > nums[j + 1]) {
                        temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
        }
        return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
    }

    public double findMaxAverage(int[] arr, int k) {
        double maxAvg = Integer.MIN_VALUE;
        double currAvg = 0;
        double currsum = 0;

        for (int i = 0; i < arr.length; i++) {

            currsum += arr[i];

            if (i >= k - 1) {
                currAvg = currsum / k;
                maxAvg = Math.max(maxAvg, currAvg);
                currsum -= arr[i - (k - 1)];
            }
        }
        return maxAvg;
    }

    public int[] findErrorNums(int[] nums) {
        int ans[] = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            int curr = Math.abs(nums[i]) - 1;
            if (nums[curr] < 0)
                ans[0] = curr + 1;
            else
                nums[curr] = nums[curr] * -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                ans[1] = i + 1;
        }
        return ans;
    }

    public void neyronCebriCem() {
        DecimalFormat df = new DecimalFormat("#.##");
        double a, b, result;
        Scanner sc = new Scanner(System.in);
        for (; ; ) {
            System.out.println("mu a ni daxil edin: ");
            a = sc.nextDouble();
            System.out.println("mu b ni daxil edin: ");
            b = sc.nextDouble();
            result = a + b - a * b;
            System.out.println("Cavab :" + df.format(result));
        }
    }

    public void neyronMehdudHasil() {
        DecimalFormat df = new DecimalFormat("#.##");
        double a, b, result;
        Scanner sc = new Scanner(System.in);
        for (; ; ) {
            System.out.println("mu a ni daxil edin: ");
            a = sc.nextDouble();
            System.out.println("mu b ni daxil edin: ");
            b = sc.nextDouble();
            result = a + b - 1;
            System.out.println("Cavab :" + df.format(Math.max(0, result)));
        }
    }

    public void neyronKonsentrasiya(double[] arr) {
        DecimalFormat df = new DecimalFormat("#.##");
        for (double iterationArr : arr) {
            System.out.println(iterationArr + ": " + df.format(Math.pow(iterationArr, 2)));
        }
    }

    public void neyronYayilma(double[] arr) {
        DecimalFormat df = new DecimalFormat("#.##");
        for (double iterationArr : arr) {
            System.out.println(iterationArr + ": " + df.format(Math.sqrt(iterationArr)));
        }
    }

    public void korrelyasiya(int[] x, int[] y) {
        int xyCem = 0, xCem = 0, yCem = 0, xKvadratCem = 0, yKvadratCem = 0;
        double result;
        for (int i = 0; i < x.length; i++) {
            xCem += x[i];
            yCem += y[i];
            xKvadratCem += Math.pow(x[i], 2);
            yKvadratCem += Math.pow(y[i], 2);
            xyCem += x[i] * y[i];
        }
        result = (x.length * xyCem - xCem * yCem) /
                (Math.sqrt(x.length * xKvadratCem - Math.pow(xCem, 2)) * Math.sqrt(x.length * yKvadratCem - Math.pow(yCem, 2)));
        System.out.println("Korrelyasiya :" + result);

    }

    public void regresiya(int[] x, int[] y) {
        double a, b;
        int xyCem = 0;
        double xOrta = 0, yOrta = 0, xkvadratCem = 0;

        for (int i = 0; i < x.length; i++) {
            xyCem += x[i] * y[i];
            xkvadratCem += Math.pow(x[i], 2);
            xOrta += x[i];
            yOrta += y[i];
        }
        xOrta = xOrta / x.length;
        yOrta = yOrta / x.length;
        b = (xyCem - x.length * xOrta * yOrta) /
                (xkvadratCem - x.length * Math.pow(xOrta, 2));
        a = yOrta - b * xOrta;
        System.out.println("b :" + b);
        System.out.println("a : " + a);
    }

    public void devZoneNumberOfAges() {
        Random random = new Random();

        int[] arr = new int[151];
        int[] array = new int[10_000_000];
        for (int j = 0; j < 10_000_000L; j++) {
            array[j] = random.nextInt(151);
            arr[array[j]]++;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + " :" + arr[i]);
        }
    }

    public void devZoneSubtractMinimumInArray() {
        int arr[][] = {
                {1, 4, 5, 6},
                {5, 232, -10},
                {6, 44, 2, 1, 7}
        };

        int min;
        int count = 0;
        boolean check;

        do {
            check = false;
            min = Integer.MAX_VALUE;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] > 0 && arr[i][j] < min) {
                        min = arr[i][j];
                    }
                }
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] > 0) {
                        arr[i][j] -= min;
                        if (arr[i][j] != 0) {
                            check = true;
                        }
                    }
                }
            }
            count++;
        } while (check);

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println("Count :" + count);
    }

    public int migratoryBirds(List<Integer> arr) {
        int[] array = new int[arr.size()];

        for (Integer integer : arr) {
            array[integer]++;
        }
        int max = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                result = i;
            }
        }
        return result;
    }

    public String catAndMouse(int x, int y, int z) {
        int firstCatWayLen = Math.abs(x - z);
        int secondCatWayLen = Math.abs(y - z);
        if (firstCatWayLen < secondCatWayLen) {
            return "Cat A";
        } else if (firstCatWayLen > secondCatWayLen) {
            return "Cat B";
        } else return "Mouse C";
    }

    public void staircase(int n) {

        for (int i = 1; i <= n; i++) {
            if (i != n) {
                for (int j = i; j < n; j++) {
                    System.out.print(" ");
                }
            }
            for (int j = 1; j <= i; j++)
                System.out.print("#");
            System.out.println();
        }
    }

    public List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> list = new ArrayList<>(2);
        list.add(0, 0);
        list.add(1, 0);
        for (int i = 0; i < 3; i++) {
            if (a.get(i) > b.get(i)) {
                list.set(0, list.get(0) + 1);
            } else if (a.get(i) < b.get(i)) {
                list.set(1, list.get(1) + 1);
            }
        }
        return list;
    }

    public int getTotalX(List<Integer> a, List<Integer> b) {
        int count = 0;

        int maxArr1 = findMax(a);
        int minArr2 = findMin(b);

        for (int num = maxArr1; num <= minArr2; num++) {
            if (isFactorOfArray1(num, a) && isFactorOfArray2(num, b)) {
                count++;
            }
        }
        return count;
    }

    private int findMax(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int num : list) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private int findMin(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (int num : list) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    private boolean isFactorOfArray1(int num, List<Integer> list) {
        for (int element : list) {
            if (num % element != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isFactorOfArray2(int num, List<Integer> list) {
        for (int element : list) {
            if (element % num != 0) {
                return false;
            }
        }
        return true;
    }

    public long taskOfPairing(List<Long> freq) {

        long result = 0;

        for (int i = 0; i < freq.size(); i++) {
            if (freq.get(i) == 0) {
                continue;
            }
            long qaliq = freq.get(i) % 2;
            long tam = freq.get(i) / 2;
            if (qaliq == 0) {
                result += tam;
            } else if (i != freq.size() - 1 && freq.get(i + 1) != 0) {
                result += qaliq + tam;
                freq.set(i + 1, freq.get(i + 1) - 1);
            } else result += tam;
        }
        return result;
    }


    public static int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftsum = 0;
        for (int ele : nums)
            totalSum += ele;
        for (int i = 0; i < nums.length; leftsum += nums[i++])
            if (leftsum * 2 == totalSum - nums[i])
                return i;
        return -1;
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> selfDividingNumbers = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            if (isDividingNumber(num)) {
                selfDividingNumbers.add(num);
            }
        }
        return selfDividingNumbers;
    }

    public static boolean isDividingNumber(int tempNumber) {
        int temp;
        int number = tempNumber;
        while (tempNumber != 0) {
            temp = tempNumber % 10;
            tempNumber = tempNumber / 10;
            if (temp == 0 || number % temp != 0) {
                return false;
            }
        }
        return true;
    }

    public int dominantIndex(int[] nums) {
        int maxnum = nums[0];
        int maxindex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxnum) {
                maxnum = nums[i];
                maxindex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] * 2 > maxnum && i != maxindex) {
                return -1;
            }
        }
        return maxindex;
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static double largestTriangleArea(int[][] points) {
        double ans = 0;
        int n = points.length;

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++)
                    ans = Math.max(ans, Math.abs(area(points[i], points[j], points[k])));
        return ans;
    }

    public static double area(int[] x1, int[] x2, int[] x3) {
        int t1 = x1[0] * (x2[1] - x3[1]);
        int t2 = x2[0] * (x3[1] - x1[1]);
        int t3 = x3[0] * (x1[1] - x2[1]);
        return (double) (t1 + t2 + t3) / 2;
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    boolean lemonadeChange(int[] bills) {

        int count5 = 0;
        int count10 = 0;
        int count20 = 0;

        for (int bill : bills) {
            // if encounter 5 then collect it simply
            if (bill == 5) count5 += 5;

            else if (bill == 10) {
                if (count5 >= 5) {
                    count5 -= 5;
                    count10 += 10;
                } else return false;
            } else {

                if (count5 >= 5 && count10 >= 10) {
                    count5 -= 5;
                    count10 -= 10;
                    count20 += 20;
                } else if (count5 >= 15) {
                    count5 -= 15;
                    count20 += 20;
                } else return false;
            }

        }
        return true;
    }

    public int[][] transpose(int[][] matrix) {
        int[][] transpose = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    public int binaryGap(int n) {
        String bin = Integer.toBinaryString(n);
        int idx = 0, max = -1;
        for (int i = 0; i < bin.length(); i++) {
            char c = bin.charAt(i);
            if (c == '1') {
                int cur = i - idx;
                if (max < cur) {
                    max = cur;
                }
                idx = i;
            }
        }
        return max;
    }

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aum = 0;
        boolean[] inAlice = new boolean[100001];
        for (int i = 0; i < aliceSizes.length; i++) {
            aum += aliceSizes[i];
            inAlice[aliceSizes[i]] = true;
        }
        int bum = 0;
        for (int i = 0; i < bobSizes.length; i++) {
            bum += bobSizes[i];
        }
        int diff = aum - bum;
        int[] ans = new int[2];
        for (int i = 0; i < bobSizes.length; i++) {
            int target = bobSizes[i] + diff / 2;
            if (target > 0 && target < 100001) {
                if (inAlice[target]) {
                    ans = new int[]{target, bobSizes[i]};
                    return ans;
                }
            }
        }
        return ans;
    }

    public boolean isMonotonic(int[] nums) {
        boolean increaseMon = false;
        boolean decreaseMon = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                increaseMon = true;
                if (decreaseMon) {
                    return false;
                }
            }
            if (nums[i] > nums[i + 1]) {
                decreaseMon = true;
                if (increaseMon) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validMountainArray(int[] arr) {
        int leg = arr.length;
        int maxIndex = 0;
        for (int i = 0; i < leg; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        if (maxIndex == 0 || maxIndex == leg - 1) {
            return false;
        }
        for (int i = 0; i < maxIndex; i++) {
            if (arr[i] >= arr[i + 1]) {
                return false;
            }
        }
        for (int i = maxIndex; i < leg - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                ans = nums[i];
                break;
            }
        }
        return ans;
    }

    public int largestPerimeter(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        for (int k = n - 1; k >= 2; k--) {
            int c = nums[k];
            int b = nums[k - 1];
            int a = nums[k - 2];

            if (this.isValid(a, b, c)) {
                return a + b + c;
            }
        }
        return 0;
    }

    private boolean isValid(int a, int b, int c) {
        return a + b > c;
    }

    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public List<Integer> addToArrayForm(int[] num, int K) {
        List<Integer> res = new LinkedList<>();
        for (int i = num.length - 1; i >= 0; --i) {
            res.add(0, (num[i] + K) % 10);
            K = (num[i] + K) / 10;
        }
        while (K > 0) {
            res.add(0, K % 10);
            K /= 10;
        }
        return res;
    }

    public int findJudge(int n, int[][] trust) {
        int indegree[] = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            indegree[trust[i][1]]++;
        }
        int judge = -1;
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == n - 1) {
                judge = i;
                break;
            }
        }
        for (int i = 0; i < trust.length; i++) {
            if (trust[i][0] == judge)
                return -1;
        }
        return judge;
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        int[] numbers = new int[201];
        int sum = 0;
        int maxAbs = 0;
        for (int n : nums) {
            maxAbs = Math.max(maxAbs, Math.abs(n));
            numbers[100 + n]++;
            sum += n;
        }

        if (maxAbs == 0) {
            return 0;
        }

        while (k-- != 0) {
            int i = 100 - maxAbs;
            while (numbers[i] == 0) {
                i++;
            }
            numbers[i]--;
            numbers[200 - i]++;
            sum -= 2 * (i - 100);
        }

        return sum;
    }

}

