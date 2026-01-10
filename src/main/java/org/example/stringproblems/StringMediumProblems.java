package org.example.stringproblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringMediumProblems {

    /**
     * MEDIUM
     * 1ms
     * 99.49%
     * <a href="https://leetcode.com/problems/word-break/description/"> Word Break</a>
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= Math.max(i - maxLen - 1, 0); j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }


    public void solveParenthesis(StringBuilder sb, int n, int open, int close, List<String> res){
        if(sb.length() == 2*n){
            res.add(sb.toString());
            return ;
        }
        if(open < n){
            sb.append('(');
            solveParenthesis(sb, n, open+1, close, res);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close < open){
            sb.append(')');
            solveParenthesis(sb, n, open, close+1, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    /**
     * <b>MEDIUM</b>
     * 0 ms 100.00%
     * <a href="https://leetcode.com/problems/generate-parentheses/description/"> Generate Parentheses</a>
     **/
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        solveParenthesis(sb, n, 0, 0, res);

        return res;
    }

    /**
     * <b>MEDIUM</b>
     * 2 ms 77.43%
     * <a href="https://leetcode.com/problems/valid-sudoku/description/"> Valid Sudoku</a>
     **/
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            if (isNotValidUnit(board, row, 0, 0, 1)) {
                return false;
            }
        }

        for (int col = 0; col < 9; col++) {
            if (isNotValidUnit(board, 0, col, 1, 0)) {
                return false;
            }
        }

        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                if (!isValid3x3Box(board, boxRow * 3, boxCol * 3)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isNotValidUnit(char[][] board, int startRow, int startCol, int rowInc, int colInc) {
        Set<Character> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            int row = startRow + i * rowInc;
            int col = startCol + i * colInc;
            char cell = board[row][col];

            if (cell != '.') {
                if (seen.contains(cell)) {
                    return true;
                }
                seen.add(cell);
            }
        }

        return false;
    }

    private boolean isValid3x3Box(char[][] board, int startRow, int startCol) {
        Set<Character> seen = new HashSet<>();

        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                char cell = board[row][col];

                if (cell != '.') {
                    if (seen.contains(cell)) {
                        return false;
                    }
                    seen.add(cell);
                }
            }
        }

        return true;
    }

}
