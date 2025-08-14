package org.example.numproblems;

import org.example.model.ListNode;

import java.util.ArrayList;
import java.util.List;

public class NumsMediumProblems {

    /**
     * <b>MEDIUM</b>
     * 1ms 100.00%
     * <a href="https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/description/"> Find Valid Matrix Given Row and Column Sums</a>
     **/
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] matrix = new int[rowSum.length][colSum.length];
        int i = 0;
        int j = 0;

        while (i < rowSum.length && j < colSum.length) {
            if (rowSum[i] < colSum[j]) {
                matrix[i][j] = rowSum[i];
                colSum[j] -= matrix[i][j];
                rowSum[i] = 0;
                ++i;
            } else {
                matrix[i][j] = colSum[j];
                rowSum[i] -= matrix[i][j];
                colSum[j] = 0;
                ++j;
            }
        }
        return matrix;
    }

    /**
     * <b>MEDIUM</b>
     * 3 ms 98.28%
     * <a href="https://leetcode.com/problems/integer-to-roman/description/"> Integer to Roman</a>
     **/
    public String intToRoman(int num) {
        final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; ++i) {
            if (num == 0) {
                break;
            }
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }

    /**
     * <b>MEDIUM</b>
     * 1 ms 100.00%
     * <a href="https://leetcode.com/problems/find-champion-ii/description/?envType=daily-question&envId=2024-11-26"> 2924. Find Champion II</a>
     **/
    public int findChampion(int n, int[][] edges) {
        int[] defeated = new int[n];

        for (int[] edge : edges) {
            var loser = edge[1];
            defeated[loser]++;
        }

        var champion = -1;
        var championCount = 0;

        for (int team = 0; team < n; team++) {
            if (defeated[team] == 0) {
                championCount++;
                champion = team;
            }
        }
        return championCount == 1 ? champion : -1;
    }

    /**
     * <b>MEDIUM</b>
     * 3 ms 100.00%
     * <a href="https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/description/"> Partitioning Into Minimum Number Of Deci-Binary Numbers</a>
     **/
    public int minPartitions(String n) {
        for (int num = 9; num > 0; num--) {
            if (n.contains(String.valueOf(num))) {
                return num;
            }
        }
        return 0;
    }

    /**
     * <b>MEDIUM</b>
     * 10 ms 99.03%
     * <a href="https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/description/?envType=daily-question&envId=2024-11-27"> Shortest Distance After Road Addition Queries I</a>
     **/
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] distances = new int[n];
        for (int i = 0; i < n; ++i) {
            distances[i] = n - 1 - i;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i + 1 < n; ++i) {
            graph.get(i + 1).add(i);
        }

        int[] answer = new int[queries.length];
        int queryIdx = 0;

        for (int[] query : queries) {
            int source = query[0];
            int target = query[1];

            graph.get(target).add(source);
            distances[source] = Math.min(distances[source], distances[target] + 1);
            updateDistances(graph, source, distances);

            answer[queryIdx++] = distances[0];
        }

        return answer;
    }

    private void updateDistances(List<List<Integer>> graph, int current, int[] distances) {
        int newDist = distances[current] + 1;

        for (int neighbor : graph.get(current)) {
            if (distances[neighbor] <= newDist) {
                continue;
            }

            distances[neighbor] = newDist;
            updateDistances(graph, neighbor, distances);
        }
    }

    /**
     * <b>MEDIUM</b>
     * 0 ms 100.00%
     * <a href="https://leetcode.com/problems/rotate-array/"> Rotate Array</a>
     **/
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * <b>MEDIUM</b>
     * 0 ms 100.00%
     * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/"> Best Time to Buy and Sell Stock II</a>
     **/
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }


    /**
     * <b>MEDIUM</b>
     * 1 ms 100.00%
     * <a href="https://leetcode.com/problems/add-two-numbers/description/"> 2. Add Two Numbers</a>
     **/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode result = dummy;
        int total;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            total = carry;

            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }

            int num = total % 10;
            carry = total / 10;
            dummy.next = new ListNode(num);
            dummy = dummy.next;
        }

        return result.next;
    }


}
