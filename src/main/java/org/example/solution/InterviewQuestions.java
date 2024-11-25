package org.example.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class InterviewQuestions {

    //Slicing problem
    //input  :  int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    //output :  49
    public int largestContainer(int[] array) {
        int maxArea = Integer.MIN_VALUE;
        int begin = 0;
        int end = array.length - 1;
        while (begin < end) {
            int weight = end - begin;
            int height = Math.min(array[begin], array[end]);
            int area = weight * height;
            maxArea = Math.max(area, maxArea);
            if (array[begin] < array[end]) {
                begin++;
            } else end--;
        }
        return maxArea;
    }


    // Slicing problem 2
    // input  : 0 1 1 0 1 0 1
    // output : 4
    public int longestOne(int[] arr) {
        int longLen = Integer.MIN_VALUE;
        int beforeZero = 0;
        int afterZero = 0;
        for (int j : arr) {
            if (j == 1) {
                afterZero++;
            } else {
                longLen = Math.max(longLen, beforeZero + afterZero + 1);
                beforeZero = afterZero;
                afterZero = 0;
            }
        }
        return Math.max(longLen, beforeZero + afterZero + 1);
    }

    // input : 1 2 3 4
    //         5 6 7 8
    //         9 10 11 12
    //         13 14 15 16
    // output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
    public List<Integer> getSprialList(int[][] arr) {
        List<Integer> sprialList = new ArrayList<>();
        int firstRow = 0;
        int lastRow = arr.length - 1;
        int firstCol = 0;
        int lastCol = arr[0].length - 1;

        while (firstRow < lastRow && firstCol < lastCol) {
            for (int i = firstCol; i <= lastCol; i++) {
                sprialList.add(arr[firstRow][i]);
            }
            for (int i = firstRow + 1; i <= lastRow; i++) {
                sprialList.add(arr[i][lastCol]);
            }
            for (int i = lastCol - 1; i >= firstCol; i--) {
                sprialList.add(arr[lastRow][i]);
            }
            for (int i = lastRow - 1; i > firstRow; i--) {
                sprialList.add(arr[i][firstCol]);
            }
            firstRow++;
            lastRow--;
            firstCol++;
            lastCol--;
        }
        return sprialList;
    }

    public int mostCommonWord(String text) {
        int max = Integer.MIN_VALUE;
        String[] strings = text.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String string : strings) {
            int freq = map.getOrDefault(string, 1);
            map.put(string, freq);
        }
        for (String string : map.keySet()) {
            if (map.get(string) > max) {
                max = map.get(string);
            }
        }
        return max;
    }

    public int longestSub(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int index = map.getOrDefault(c, -1);
            if (index != -1) {
                int len = i - index;
                maxLen = Math.max(maxLen, len);
            }
            map.put(c, i);
        }
        return maxLen;
    }

    public boolean isValidBrackets(String text) {
        Stack<Character> stack1 = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            stack1.push(text.charAt(i));
        }
        boolean isValid = true;
        Stack<Character> stack2 = new Stack<>();

        while (!stack1.isEmpty()) {
            char bracket = stack1.pop();
            if (bracket == ')') {
                stack2.push(bracket);
            } else {
                if (stack2.isEmpty()) {
                    isValid = false;
                    break;
                } else stack2.pop();
            }
        }
        return isValid;
    }

    // StreamRating 3, 5, 2, 4, 5, 3, 2, 2
    // k=3
    //Output : [4,5,5]
    public void kthTopRating(int[] streamRating, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int rating : streamRating) {
            priorityQueue.add(rating);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        System.out.println(priorityQueue);
    }

}
