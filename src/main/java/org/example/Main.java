package org.example;

import org.example.solution.nums_problems.NumsMediumProblems;

public class Main {
    public static void main(String[] args) {
        NumsMediumProblems numsMediumProblems = new NumsMediumProblems();
        int[][] queries = {{2, 4}, {0, 2}, {0, 4}};
        int[] result = numsMediumProblems.shortestDistanceAfterQueries(5, queries);
        for (int res : result) {
            System.out.println(res);
        }
    }
}
