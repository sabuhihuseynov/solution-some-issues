package org.example.solution.nums_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class NumsEasyProblems2 {

    /**
     * 1ms
     * 100.00%
     * <a href="https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/description/"> Partition Array Into Three Parts With Equal Sum</a>
     **/
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }

        if (sum % 3 != 0) {
            return false;
        }

        int target = sum / 3;
        int currentSum = 0;
        int count = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            currentSum += arr[i];
            if (currentSum == target) {
                currentSum = 0;
                count++;
                if (count == 2) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 1ms
     * 99.00%
     * <a href="https://leetcode.com/problems/last-stone-weight/description/"> Last Stone Weight</a>
     **/
    public int lastStoneWeight(int[] stones) {
        while (stones.length > 1) {
            Arrays.sort(stones);
            int heaviest1 = stones[stones.length - 1];
            int heaviest2 = stones[stones.length - 2];
            if (heaviest1 == heaviest2) {
                stones = Arrays.copyOfRange(stones, 0, stones.length - 2);
            } else {
                stones[stones.length - 1] = heaviest1 - heaviest2;
                stones[stones.length - 2] = stones[stones.length - 1];
                stones = Arrays.copyOfRange(stones, 0, stones.length - 1);
            }
        }
        return stones.length == 1 ? stones[0] : 0;
    }

    /**
     * 2ms
     * 90.09%
     * <a href="https://leetcode.com/problems/height-checker/description/"> Last Height Checker</a>
     **/
    public int heightChecker(int[] heights) {
        int count = 0;
        int[] expected = new int[heights.length];
        System.arraycopy(heights, 0, expected, 0, heights.length);
        Arrays.sort(expected);
        for (int i = 0; i < heights.length; i++) {
            if (expected[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/relative-sort-array/description/"> Relative Sort Array</a>
     **/
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ans = new int[1001];
        for (int n : arr1) {
            ans[n]++;
        }
        int i = 0;
        for (int n : arr2) {
            while (ans[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        for (int n = 0; n < ans.length; n++) {
            while (ans[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/n-th-tribonacci-number/description/"> N-th Tribonacci Number</a>
     **/
    public int tribonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        int t3 = 0;
        int temp;
        for (int i = 2; i < n; i++) {
            t3 = t0 + t1 + t2;
            temp = t2;
            t2 = t3;
            t0 = t1;
            t1 = temp;
        }
        return t3;
    }

    /**
     * 7ms
     * 91.61%
     * <a href="https://leetcode.com/problems/day-of-the-year/description/"> Day of the Year</a>
     **/
    public int dayOfYear(String date) {
        int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));

        if (month > 2 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            day = day + 1;
        }

        while (--month > 0) {
            day = day + days[month - 1];
        }
        return day;
    }

    /**
     * 2ms
     * 98.97%
     * <a href="https://leetcode.com/problems/unique-number-of-occurrences/description/"> Unique Number of Occurrences</a>
     **/
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        HashSet<Integer> check = new HashSet<>();
        for (int number : arr) {
            int oldValue = frequencyMap.getOrDefault(number, 0);
            frequencyMap.put(number, oldValue + 1);
        }
        for (Integer value : frequencyMap.values()) {
            if (!check.add(value)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/check-if-it-is-a-straight-line/description/"> Check If It Is a Straight Line</a>
     **/
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) {
            return true;
        }
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];
        // double slope=(double) (y1-y0)/(x1-x0);
        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            // double varslope=(double)(y-y0)/(x-x0);
            // if(slope!=varslope || ) return false;

            if ((y1 - y0) * (x - x0) != (y - y0) * (x1 - x0)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 1ms
     * 97.75%
     * <a href="https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/"> Find Numbers with Even Number of Digits</a>
     **/
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int element : nums) {
            int i = 0;
            while (element != 0) {
                element = element / 10;
                i++;
            }
            if (i % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/decompress-run-length-encoded-list/description/"> Decompress Run-Length Encoded List</a>
     **/
    public int[] decompressRLElist(int[] nums) {
        int arrSize = 0;
        for (int i = 0; i < nums.length; i += 2) {
            arrSize += nums[i];
        }

        int[] result = new int[arrSize];

        int startIdx = 0;
        for (int i = 0; i < nums.length; i += 2) {
            Arrays.fill(result, startIdx, startIdx + nums[i], nums[i + 1]);
            startIdx += nums[i];
        }
        return result;
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/description/"> Convert Integer to the Sum of Two No-Zero Integers</a>
     **/
    public int[] getNoZeroIntegers(int n) {
        int[] res = new int[2];

        for (int i = 1; i < n; i++) {
            int c = n - i;
            if (check(c) && check(i)) {
                res[0] = i;
                res[1] = c;
                return res;
            }
        }

        return res;
    }

    public boolean check(int m) {
        while (m > 0) {
            int digit = m % 10;
            if (digit == 0) {
                return false;
            }
            m /= 10;
        }
        return true;
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/maximum-69-number/description/"> Maximum 69 Number</a>
     **/
    public int maximum69Number(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '6') {
                charArray[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(charArray));
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/"> Count Negative Numbers in a Sorted Matrix</a>
     **/
    public int countNegatives(int[][] grid) {
        int countOfNeg = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    countOfNeg += (grid[i].length - j);
                    break;
                }
            }
        }
        return countOfNeg;
    }

    /**
     * 1ms
     * 100.00%
     * <a href="https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/"> How Many Numbers Are Smaller Than the Current Number</a>
     **/
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int n = nums.length;

        for (int num : nums) {
            count[num]++;
        }

        for (int i = 1; i <= 100; i++) {
            count[i] += count[i - 1];
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                result[i] = count[nums[i] - 1];
            }
        }

        return result;
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/"> Lucky Numbers in a Matrix</a>
     **/
    public List<Integer> luckyNumbers(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            int minColIndex = minColIndexInRow(matrix, i, col);
            int luckyNum = matrix[i][minColIndex];
            if (Boolean.TRUE.equals(checkIfMaxInCol(matrix, minColIndex, luckyNum, row))) {
                ans.add(luckyNum);
            }
        }
        return ans;
    }

    private int minColIndexInRow(int[][] matrix, int i, int col) {
        int j = 0;
        int min = matrix[i][j];
        int minColIndex = 0;
        for (j = 1; j < col; j++) {
            if (matrix[i][j] < min) {
                min = matrix[i][j];
                minColIndex = j;
            }
        }
        return minColIndex;
    }

    private Boolean checkIfMaxInCol(int[][] matrix, int j, int num, int row) {
        for (int i = 0; i < row; i++) {
            if (matrix[i][j] > num) {
                return false;
            }
        }
        return true;
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/create-target-array-in-the-given-order/description/"> Create Target Array in the Given Order</a>
     **/
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> ans = new ArrayList<>();
        int[] target = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans.add(index[i], nums[i]);
        }
        int i = 0;
        for (int a : ans) {
            target[i++] = a;
        }
        return target;
    }

    /**
     * 1ms
     * 100.00%
     * <a href="https://leetcode.com/problems/find-lucky-integer-in-an-array/description/"> Create Target Array in the Given OrderFind Lucky Integer in an Array</a>
     **/
    public int findLucky(int[] arr) {
        int[] cnt = new int[501];
        for (int a : arr) {
            ++cnt[a];
        }
        for (int i = 500; i > 0; --i) {
            if (cnt[i] == i) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/"> Kids With the Greatest Number of Candies</a>
     **/
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ifKidHaveMaxCandies = new ArrayList<>(candies.length);
        int max = findMax(candies);

        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                ifKidHaveMaxCandies.add(true);
            } else {
                ifKidHaveMaxCandies.add(false);
            }
        }
        return ifKidHaveMaxCandies;
    }

    private int findMax(int[] candies) {
        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if (max < candies[i]) {
                max = candies[i];
            }
        }
        return max;
    }

    /**
     * 1ms
     * 100.00%
     * <a href="https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/description/"> Check If All 1's Are at Least Length K Places Away</a>
     **/
    public boolean kLengthApart(int[] nums, int k) {
        int numberOfZerosBetweenOnes = 0;
        if (nums[0] == 0) {
            numberOfZerosBetweenOnes = k;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (numberOfZerosBetweenOnes < k) {
                    return false;
                }
                numberOfZerosBetweenOnes = 0;
            } else {
                numberOfZerosBetweenOnes++;
            }
        }
        return true;
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/description/"> Number of Students Doing Homework at a Given Time</a>
     **/
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                count++;
            }
        }
        return count;
    }

    public int maxProduct(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest) {
                secondLargest = num;
            }
        }
        return (largest - 1) * (secondLargest - 1);
    }

    /**
     * 1ms
     * 98.80%
     * <a href="https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/"> Final Prices With a Special Discount in a Shop</a>
     **/
    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/running-sum-of-1d-array/description/"> Running Sum of 1d Array</a>
     **/
    public int[] runningSum(int[] nums) {
        int[] runningArr = new int[nums.length];
        int sum = nums[0];
        runningArr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            runningArr[i] = sum;
        }
        return runningArr;
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/xor-operation-in-an-array/description/"> XOR Operation in an Array</a>
     **/
    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        int elementXOR = start;
        for (int i = 1; i < n; i++) {
            nums[i] = start + 2 * i;
            elementXOR ^= nums[i];
        }
        return elementXOR;
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/description/"> Average Salary Excluding the Minimum and Maximum Salary</a>
     **/
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count = 0;
        double sum = 0;

        for (int money : salary) {
            if (money < min) {
                min = money;
            }
            if (money > max) {
                max = money;
            }
        }
        for (int money : salary) {
            if (money != min && money != max) {
                sum += money;
                count++;
            }
        }
        return sum / count;
    }

    /**
     * 2ms
     * 96.29%
     * <a href="https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/description/"> Can Make Arithmetic Progression From Sequence</a>
     **/
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = arr.length - 1; i > 0; i--) {
            if (diff != arr[i] - arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 0ms
     * 100.00%
     * <a href="https://leetcode.com/problems/missing-number/description/"> Missing Number</a>
     **/
    public int missingNumber(int[] nums) {
        int[] numbersCountArr = new int[nums.length + 1];
        for (int num : nums) {
            numbersCountArr[num]++;
        }
        for (int i = 0; i < numbersCountArr.length; i++) {
            if (numbersCountArr[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 27ms
     * 76.13%
     * <a href="https://leetcode.com/problems/longest-consecutive-sequence/description/"> Longest Consecutive Sequence</a>
     **/
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxConsecutiveLenght = 0;

        for (int element : set) {
            if (!set.contains(element - 1)) {
                int expectedElement = element + 1;
                while (set.contains(expectedElement)) {
                    expectedElement++;
                }
                maxConsecutiveLenght = Math.max(maxConsecutiveLenght, expectedElement - element);
            }
        }
        return maxConsecutiveLenght;
    }

    /**
     * 3ms
     * 72.35%
     * <a href="https://leetcode.com/problems/valid-palindrome/description/"> Valid Palindrome</a>
     **/
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    /**
     * 1ms 97,14%
     * <a href="https://leetcode.com/problems/concatenation-of-array/description/"> Concatenation of Array</a>
     **/
    public int[] getConcatenation(int[] nums) {
        int n = nums.length * 2;
        int[] result = new int[n];
        int j = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
            result[j++] = nums[i];
        }
        return result;
    }

    /**
     * 0ms 100.00%
     * <a href="https://leetcode.com/problems/concatenation-of-array/description/"> Concatenation of Array</a>
     **/
    public int[] getConcatenationn(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        System.arraycopy(nums, 0, ans, 0, n);
        System.arraycopy(nums, 0, ans, n, n);
        return ans;
    }

    /**
     * 0ms 99.19%
     * <a href="https://leetcode.com/problems/build-array-from-permutation/description/"> Build array from permutation</a>
     **/
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    /**
     * 1ms 100.00%
     * <a href="https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/description/"> The Two Sneaky Numbers of Digitville</a>
     **/
    public int[] getSneakyNumbers(int[] nums) {
        int j = 0;
        int[] uniqueNumbers = new int[nums.length - 2];
        int[] ans = new int[2];
        for (int num : nums) {
            uniqueNumbers[num]++;
            if (uniqueNumbers[num] == 2) {
                ans[j++] = num;
            }
        }
        return ans;
    }


    /**
     * 0ms 100.00%
     * <a href="https://leetcode.com/problems/longest-common-prefix/description/"> Longest Common Prefix</a>
     **/
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    /**
     * 0ms 100.00%
     * <a href="https://leetcode.com/problems/ransom-note/description/"> Ransom Note</a>
     **/
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] letters = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int index = magazine.indexOf(c, letters[c % 26]);
            if (index == -1) {
                return false;
            }
            letters[c % 26] = index + 1;
        }
        return true;
    }

    /**
     * 0ms 100.00%
     * <a href="https://leetcode.com/problems/shuffle-string/description/"> Shuffle String</a>
     **/
    public String restoreString(String s, int[] indices) {
        char[] shuffledArr = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            shuffledArr[indices[i]] = s.charAt(i);
        }
        return new String(shuffledArr);
    }

    /**
     * 1ms 100.00%
     * <a href="https://leetcode.com/problems/snake-in-matrix/description/"> Snake in Matrix</a>
     **/
    public int finalPositionOfSnake(int n, List<String> commands) {
        int position = 0;
        for (String command : commands) {
            switch (command.charAt(0)) {
                case 'U':
                    position -= n;
                    break;
                case 'D':
                    position += n;
                    break;
                case 'L':
                    position--;
                    break;
                case 'R':
                    position++;
            }
        }
        return position;
    }
}

