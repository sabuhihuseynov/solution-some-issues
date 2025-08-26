package org.example.numproblems;

import org.example.model.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
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

    /**
     * <b>MEDIUM</b>
     * 1 ms 100.00%
     * <a href="https://leetcode.com/problems/reverse-integer/"> Reverse Integer</a>
     **/
    public int reverse(int x) {
        int rev = 0;
        int digit;
        while (x != 0) {
            digit = x % 10;
            x /= 10;

            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; // positive overflow
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; // negative overflow
            }

            rev = rev * 10 + digit;
        }
        return rev;
    }

    /**
     * <b>MEDIUM</b>
     * 1 ms 100.00%
     * <a href="https://leetcode.com/problems/string-to-integer-atoi/description/"> String to Integer (atoi)</a>
     **/
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int i = 0;
        int n = s.length();

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        boolean isNegative = false;
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            isNegative = s.charAt(i) == '-';
            i++;
        }

        long result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        result = isNegative ? -result : result;

        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) result;
    }

    /**
     * <b>MEDIUM</b>
     * 0 ms 100.00%
     * <a href="https://leetcode.com/problems/swap-nodes-in-pairs/description/"> Swap Nodes in Pairs</a>
     **/
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode first = head;
        ListNode second = head.next;
        ListNode next = second.next;

        while (second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;

            first = next;
            second = first == null ? null : first.next;
            next = second == null ? null : second.next;
        }

        return head;
    }

    public static void main(String[] args) {
        NumsMediumProblems numsMediumProblems = new NumsMediumProblems();
        int[] nums = new int[]{2,2};
        System.out.println(Arrays.toString(numsMediumProblems.searchRange(nums, 2)));
    }

    public int[] searchRange(int[] nums, int target) {
        var findingIndex = binarySearch(nums, target);
        if (findingIndex == -1) {
            return new int[]{-1, -1};
        }
        var first = findingIndex;
        var last = findingIndex;

        while ((first != 0 && nums[first - 1] == target) || (last != nums.length - 1 && nums[last + 1] == target)) {
            if (first != 0 && nums[first - 1] == target) {
                first--;
            }
            if (last != nums.length - 1 && nums[last + 1] == target) {
                last++;
            }
        }

        return new int[]{first, last};
    }

    private int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }




}
