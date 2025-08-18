package org.example.stringproblems;

import java.util.ArrayList;
import java.util.List;

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
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        solveParenthesis(sb, n, 0, 0, res);

        return res;
    }

    public static void main(String[] args) {
        StringMediumProblems sm = new StringMediumProblems();
        sm.generateParenthesis(3);
    }


}
