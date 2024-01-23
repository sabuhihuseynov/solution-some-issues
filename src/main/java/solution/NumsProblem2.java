package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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



}
