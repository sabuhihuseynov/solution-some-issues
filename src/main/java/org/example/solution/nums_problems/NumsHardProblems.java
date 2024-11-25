package org.example.solution.nums_problems;

public class NumsHardProblems {

    /**
     * <b>HARD</b>
     * 1ms 100.00%
     * <a href="https://leetcode.com/problems/first-missing-positive/description/"> First Missing Positive</a>
     **/
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] <= nums.length && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

}
