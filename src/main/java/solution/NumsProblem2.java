package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Stack;


public class NumsProblem2 {

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

    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j >= i + 2; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[i + 1] = 0;
                i = i + 1;
            }
        }
    }

    public int[] distributeCandies(int candies, int k) {
        int ary[] = new int[k];
        int val = 1;
        int indexstore = 0;
        int count = 0;
        while (candies > 0) {
            for (int i = 0; i < k; i++) {
                candies -= val;
                if (candies >= 0) {
                    ary[i] += val;
                    if (candies == 0) {
                        break;

                    }
                } else {
                    ary[i] += val + candies;
                    indexstore = i;
                    break;
                }
                val++;
            }
            count++;
        }
        if (indexstore != 0 && indexstore != k - 1 && count == 0) {
            for (int i = indexstore; i < k; i++) {
                ary[i] = 0;
            }
        }
        return ary;
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ans = new int[1001];
        for (int n : arr1) ans[n]++;
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

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) return true;
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

            if ((y1 - y0) * (x - x0) != (y - y0) * (x1 - x0)) return false;
        }
        return true;
    }

    public int findSpecialInteger(int[] arr) {
        int specialValue = arr.length / 4;
        int temp = arr[0];
        int count = 0;
        for (int element : arr) {
            if (temp == element) {
                count++;
            } else count = 1;
            if (count > specialValue) {
                break;
            }
            temp = element;
        }
        return temp;
    }

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int element : nums) {
            int i = 0;
            while (element != 0) {
                element = element / 10;
                i++;
            }
            if (i % 2 == 0) count++;
        }
        return count;
    }

    public int[] sumZero(int n) {
        int mid = n / 2;
        int[] arr = new int[n];
        int count = 0;
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            if (i < mid) {
                count--;
                arr[i] = count;
            } else if (i == mid && n != (2 * mid)) {
                count = 0;
                arr[i] = count;
            } else {
                count2++;
                arr[i] = count2;
            }
        }
        return arr;
    }

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

    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> arrayRanks = new HashMap<>();
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        int rank = 1;
        for (int i = 0; i < sortedArr.length; i++) {
            if (!arrayRanks.containsKey(sortedArr[i])) {
                arrayRanks.put(sortedArr[i], rank++);
            }
        }
        int[] ranks = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            ranks[i] = arrayRanks.get(arr[i]);

        return ranks;
    }

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

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
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

    public List<Integer> luckyNumbers(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            int minColIndex = minColIndexInRow(matrix, i, col);
            int luckyNum = matrix[i][minColIndex];
            if (checkIfMaxInCol(matrix, minColIndex, luckyNum, row)) {
                ans.add(luckyNum);
            }
        }
        return ans;
    }

    private int minColIndexInRow(int[][] matrix, int i, int col) {
        int j = 0, min = matrix[i][j];
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
            if (matrix[i][j] > num) return false;
        }
        return true;
    }

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

    public int minStartValue(int[] nums) {
        int sum = 0;
        int min = sum;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < min) {
                min = sum;
            }
        }
        return Math.abs(min) + 1;
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


}

