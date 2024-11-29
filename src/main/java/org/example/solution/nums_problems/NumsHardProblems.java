package org.example.solution.nums_problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumsHardProblems {

    /**
     * <b>HARD</b>
     * 1ms 100.00%
     * <a href="https://leetcode.com/problems/first-missing-positive/description/"> First Missing Positive</a>
     **/
    public int firstMissingPositive(int[] nums) {
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

    /**
     * <b>HARD</b>
     * 50ms 95.00%
     * <a href="https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/description/?envType=daily-question&envId=2024-11-28"> Minimum Obstacle Removal to Reach Corner</a>
     **/
    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0, 0, 0});
        grid[0][0] = -1;

        while (!dq.isEmpty()) {
            int[] temp = dq.pollFirst();
            int r = temp[0];
            int c = temp[1];
            int obstacle = temp[2];

            if (r == n - 1 && c == m - 1) {
                return obstacle;
            }

            for (int[] d : dir) {
                int row = r + d[0];
                int col = c + d[1];

                if (isValid(row, col, n, m) && grid[row][col] != -1) {
                    if (grid[row][col] == 0) {
                        dq.addFirst(new int[]{row, col, obstacle});
                    } else {
                        dq.addLast(new int[]{row, col, obstacle + 1});
                    }
                    grid[row][col] = -1;
                }
            }
        }
        return -1;
    }

    public boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}
