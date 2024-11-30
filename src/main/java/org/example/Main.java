package org.example;

import org.example.solution.nums_problems.NumsHardProblems;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 3, 2}, {5, 1, 2, 5}, {4, 3, 8, 6}};
        NumsHardProblems numsHardProblems = new NumsHardProblems();
        System.out.println(numsHardProblems.minimumTime(grid));


    }
}
