package org.example.solution.nums_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class NumsEasyProblems {

    /**
     * 4ms
     * 72.61%
     * <a href="https://leetcode.com/problems/roman-to-integer/description/"> Roman to Integer</a>
     **/
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

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/plus-one/description/"> Plus One</a>
     **/
    public int[] plusOne(int[] digits) {
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

    /**
     * 1ms
     * 99.93%
     * <a href="https://leetcode.com/problems/add-binary/description/"> Add Binary</a>
     **/
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

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/climbing-stairs/description/"> Climbing Stairs</a>
     **/
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

    /**
     * 1ms
     * 99.84%
     * <a href="https://leetcode.com/problems/single-number/description/"> Single Number</a>
     **/
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/happy-number/description/"> Happy Number</a>
     **/
    public boolean isHappy(int n) {
        do {
            n = happyNumber(n);
        } while (n != 1 && n != 4);

        return n == 1;
    }

    public int happyNumber(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            n /= 10;
            sum += (temp * temp);
        }
        return sum;
    }

    /**
     * 1ms
     * 100.00%
     * <a href="https://leetcode.com/problems/contains-duplicate/"> Contains Duplicate</a>
     **/
    public boolean containsDuplicate(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            } else if (nums[i - 1] > nums[i]) {
                int temp = nums[i - 1];
                for (int j = (i - 2); j >= 0; j--) {
                    if (nums[i] == nums[j]) {
                        return true;
                    }
                }
                nums[i - 1] = nums[i];
                nums[i] = temp;
            }
        }
        return false;
    }

    /**
     * 1ms
     * 45.72%
     * <a href="https://leetcode.com/problems/power-of-two/description/"> Power of Two</a>
     **/
    public boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (n < 1) return false;
        if (n % 2 != 0) {
            return false;
        }
        return (isPowerOfTwo(n / 2));
    }

    /**
     * 1ms
     * 48.52%
     * <a href="https://leetcode.com/problems/ugly-number/description/"> Ugly Number</a>
     **/
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 2 == 0) {
            n = n / 2;
        }
        return n == 1;
    }

    /**
     * 2ms
     * 84.15%
     * <a href="https://leetcode.com/problems/move-zeroes/"> Move Zeroes</a>
     **/
    public void moveZeroes(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            }
        }
        for (int i = j; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    /**
     * 2ms
     * 96.26%
     * <a href="https://leetcode.com/problems/intersection-of-two-arrays/description/"> Intersection of Two Arrays</a>
     **/
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

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/valid-perfect-square/description/"> Valid Perfect Square</a>
     **/
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

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/number-complement/description/"> Number Complement</a>
     **/
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

    /**
     * 1ms
     * 96.52%
     * <a href="https://leetcode.com/problems/perfect-number/description/"> Perfect Number</a>
     **/
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
        return sum == num;
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
                list.set(0, list.getFirst() + 1);
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
            long mod = freq.get(i) % 2;
            long n = freq.get(i) / 2;
            if (mod == 0) {
                result += n;
            } else if (i != freq.size() - 1 && freq.get(i + 1) != 0) {
                result += mod + n;
                freq.set(i + 1, freq.get(i + 1) - 1);
            } else result += n;
        }
        return result;
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

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/toeplitz-matrix/description/"> Toeplitz Matrix</a>
     **/
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

    /**
     * 2ms
     * 96.14%
     * <a href="https://leetcode.com/problems/lemonade-change/description/"> Lemonade Change</a>
     **/
    boolean lemonadeChange(int[] bills) {

        int count5 = 0;
        int count10 = 0;
        int count20 = 0;

        for (int bill : bills) {
            switch (bill) {
                case 5 -> count5 += 5;
                case 10 -> {
                    if (count5 >= 5) {
                        count5 -= 5;
                        count10 += 10;
                    } else return false;
                }
                default -> {
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

        }
        return true;
    }

    /**
     * 1ms
     * 28.85%
     * <a href="https://leetcode.com/problems/transpose-matrix/description/">  Transpose Matrix</a>
     **/
    public int[][] transpose(int[][] matrix) {
        int[][] transpose = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    /**
     * 1ms
     * 45.60%
     * <a href="https://leetcode.com/problems/binary-gap/description/">  Binary Gap</a>
     **/
    public int binaryGap(int n) {
        String bin = Integer.toBinaryString(n);
        int idx = 0;
        int max = -1;
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

    /**
     * 3ms
     * 99.84%
     * <a href="https://leetcode.com/problems/fair-candy-swap/description/"> Fair Candy Swap</a>
     **/
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aum = 0;
        boolean[] inAlice = new boolean[100001];
        for (int aliceSize : aliceSizes) {
            aum += aliceSize;
            inAlice[aliceSize] = true;
        }
        int bum = 0;
        for (int bobSize : bobSizes) {
            bum += bobSize;
        }
        int diff = aum - bum;
        int[] ans = new int[2];
        for (int bobSize : bobSizes) {
            int target = bobSize + diff / 2;
            if (target > 0 && target < 100001 && inAlice[target]) {
                ans = new int[]{target, bobSize};
                return ans;
            }
        }
        return ans;
    }

    /**
     * 2ms
     * 65.36%
     * <a href="https://leetcode.com/problems/monotonic-array/description/"> Monotonic Array</a>
     **/
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

    /**
     * 1ms
     * 100.00%
     * <a href="https://leetcode.com/problems/valid-mountain-array/description/"> Valid Mountain Array</a>
     **/
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

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/n-repeated-element-in-size-2n-array/description/"> N-Repeated Element in Size 2N Array</a>
     **/
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return n;
            }
            set.add(n);
        }
        return 0;
    }

    /**
     * 1ms
     * 100.00%
     * <a href="https://leetcode.com/problems/squares-of-a-sorted-array/description/">  Squares of a Sorted Array</a>
     **/
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        for (int i = right; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }

    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new LinkedList<>();
        for (int i = num.length - 1; i >= 0; --i) {
            res.addFirst((num[i] + k) % 10);
            k = (num[i] + k) / 10;
        }
        while (k > 0) {
            res.addFirst(k % 10);
            k /= 10;
        }
        return res;
    }

    /**
     * 2ms
     * 99.77%
     * <a href="https://leetcode.com/problems/find-the-town-judge/description/"> Find the Town Judge</a>
     **/
    public int findJudge(int n, int[][] trust) {
        int indegree[] = new int[n + 1];

        for (int[] ints : trust) {
            indegree[ints[1]]++;
        }
        int judge = -1;
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == n - 1) {
                judge = i;
                break;
            }
        }
        for (int[] ints : trust) {
            if (ints[0] == judge)
                return -1;
        }
        return judge;
    }

    /**
     * 2ms
     * 94.95%
     * <a href="https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/description/"> Maximize Sum Of Array After K Negations</a>
     **/
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

