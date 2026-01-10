package org.example.numproblems;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class NumsHardProblems {

    private static final int[][] MOVES = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

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
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {0, 0, 0});
        grid[0][0] = -1;

        while (!dq.isEmpty()) {
            int[] temp = dq.pollFirst();
            int r = temp[0];
            int c = temp[1];
            int obstacle = temp[2];

            if (r == n - 1 && c == m - 1) {
                return obstacle;
            }

            for (int[] d : MOVES) {
                int row = r + d[0];
                int col = c + d[1];

                if (isValid(row, col, n, m) && grid[row][col] != -1) {
                    if (grid[row][col] == 0) {
                        dq.addFirst(new int[] {row, col, obstacle});
                    } else {
                        dq.addLast(new int[] {row, col, obstacle + 1});
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

    /**
     * <b>HARD</b>
     * 112 ms 100.00%
     * <a href="https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/description/?envType=daily-question&envId=2024-11-29"> Minimum Time to Visit a Cell In a Grid</a>
     **/
    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[m][n];

        pq.offer(new int[] {0, 0, 0});
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int row = curr[1];
            int col = curr[2];

            for (int[] dir : MOVES) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (!valid(newRow, newCol, m, n) || visited[newRow][newCol]) {
                    continue;
                }

                int newTime = time + 1;
                if (grid[newRow][newCol] > newTime) {
                    int wait = ((grid[newRow][newCol] - newTime + 1) / 2) * 2;
                    newTime += wait;
                }

                if (newRow == m - 1 && newCol == n - 1) {
                    return newTime;
                }

                visited[newRow][newCol] = true;
                pq.offer(new int[] {newTime, newRow, newCol});
            }
        }
        return -1;
    }

    public boolean valid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    /**
     * <p>Problem Description:
     * Find the maximum sum of differences (sell - buy) where the sell index must
     * be greater than the buy index. We can skip elements, and we cannot reuse
     * the same specific instance of an element .
     *
     * <p>Logic:
     * We iterate through the prices and maintain a Min-Heap of potential buy prices.
     * For every price, we treat it as a potential sell price against the minimum
     * currently in the heap. If selling yields a profit, we "execute" the trade
     * but keep the current price in the ecosystem (via the heap logic) to allow
     * for "upgrading" the trade later if a better sell price appears.
     *
     * <p>Example:
     * Input: [7, 3, 1, 5, 6, 10]
     * Output: 12
     * Logic: Effectively pairs (3, 6) and (1, 10).
     * Calculation: (6 - 3) + (10 - 1) = 3 + 9 = 12.
     *
     * @param prices an array of integer prices
     * @return the maximum possible profit from valid pairings
     */
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(prices[0]);
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            Integer currentMin = minHeap.peek();

            if (currentMin != null && prices[i] > currentMin) {
                maxProfit += prices[i] - currentMin;
                minHeap.poll();
            }
            minHeap.add(prices[i]);
        }
        return maxProfit;
    }

}
