package org.example;


import java.util.Arrays;
import java.util.stream.IntStream;
import solution.NumsProblem2;
import solution.SearchingAlgorithms;
import solution.SortingAlgorithms;
import solution.StringProblems;


public class Main {
    public static void main(String[] args) {

        StringProblems stringProblems = new StringProblems();
        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
        SearchingAlgorithms searchingAlgorithms = new SearchingAlgorithms();
        NumsProblem2 numsProblem2 = new NumsProblem2();

        String s = "abbcccddddeeeeedcba";
        long startTime = System.currentTimeMillis();
        System.out.println(stringProblems.maxPower(s));
        long endTime = System.currentTimeMillis();
        System.out.println("Time for execution method :" + (endTime - startTime));
    }
}