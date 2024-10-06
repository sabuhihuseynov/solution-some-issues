package org.example;


import org.example.custom_data_structures.LinkedList;
import org.example.solution.Calculator;
import org.example.solution.NumsProblem2;
import org.example.solution.SearchingAlgorithms;
import org.example.solution.SortingAlgorithms;
import org.example.solution.StringProblems;


public class Main {
    public static void main(String[] args) {

        StringProblems stringProblems = new StringProblems();
        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
        SearchingAlgorithms searchingAlgorithms = new SearchingAlgorithms();
        NumsProblem2 numsProblem2 = new NumsProblem2();
        Calculator calculator = new Calculator();

        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        System.out.println(linkedList);

        linkedList.addHead("0");
        System.out.println(linkedList);
        linkedList.addTail("4");
        System.out.println(linkedList);

        System.out.println(linkedList.removeHead().get());
        System.out.println(linkedList);
        System.out.println(linkedList.removeTail().get());
        System.out.println(linkedList);

        System.out.println(linkedList.update(2,"10").get());
        System.out.println(linkedList);
        System.out.println(linkedList.insert(3, "11").get());
        System.out.println(linkedList);

        System.out.println(linkedList.delete(1).get());
        System.out.println(linkedList);
        System.out.println(linkedList.delete(2).get());
        System.out.println(linkedList);

        System.out.println(linkedList.delete("1").get());
        System.out.println(linkedList);
        System.out.println(linkedList.toArray());
    }
}
