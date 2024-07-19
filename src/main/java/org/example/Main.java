package org.example;

import solution.Calculator;
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
        Calculator calculator = new Calculator();

        System.out.println(calculator.calculatePi(100));
    }
}