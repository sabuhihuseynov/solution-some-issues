package org.example;

import org.example.numproblems.NumsHardProblems;

public class Main {
    public static void main(String[] args) {
        NumsHardProblems numsHardProblems = new NumsHardProblems();
        int[] arr = new int[] {7, 3, 1, 5, 6, 10};
        System.out.println(numsHardProblems.maxProfit(arr));
    }
}
