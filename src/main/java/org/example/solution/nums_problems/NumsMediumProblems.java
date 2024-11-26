package org.example.solution.nums_problems;

import java.util.Arrays;

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
            if (num == 0)
                break;
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
        boolean[] isUndefeated = new boolean[n];
        Arrays.fill(isUndefeated, true);

        for (int[] edge : edges) {
            var loser = edge[1];
            isUndefeated[loser] = false;
        }

        var champion = -1;
        var championCount = 0;

        for (int team = 0; team < n; team++) {
            if (isUndefeated[team]) {
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


}
