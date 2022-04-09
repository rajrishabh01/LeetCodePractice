package com.revision;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Array_revision {

    public static void main(String[] args) {
        //1 Two Sum
        int[] twoSumInput = new int[]{1, 2, 3, 4};
        int target = 4;
        System.out.println(Arrays.toString(twoSum(twoSumInput, target)));

        //2 Max Consecutive Ones
        int[] consOnes = new int[]{1, 1, 1, 0, 1, 1, 1, 0, 1, 1};
        System.out.println(consecutiveOnes(consOnes));

        //3
        int[] squaredArray = new int[]{-4, -1, 0, 3, 6};
        System.out.println(Arrays.toString(sortedSquares(squaredArray)));

        //1 Replace with greatest
        int[] replaceGreatestInput = {19, 18, 7, 4, 3};
        System.out.println("The greatest values to the right of original - "
                + replaceGreatest(replaceGreatestInput));

        //2 A Better Repeated Deletion Algorithm
        int[] inPlaceDeletionArray = {0, 0, 0, 1, 1, 1, 2, 2};
        System.out.println("In place deletion of duplicates - "
                + Arrays.toString(inPlaceDeletion(inPlaceDeletionArray)));
    }

    private static int[] inPlaceDeletion(int[] input) {
        int count =1;
        for(int i=1; i< input.length; i++){
            if(input[i-1] != input[i])
                input[count++] = input[i];
        }

        return input;
    }

    private static int[] replaceGreatest(int[] input) {
        int max = 1;
        for (int i = input.length - 1; i >= 0; i--) {
            int a = input[i];
            input[i] = max;
            max = Math.max(a, max);
        }
        return input;

    }

    private static int[] sortedSquares(int[] input) {
        int[] answer = new int[input.length];
        int start = 0, end = input.length - 1;
        for (int i = input.length - 1; i >= 0; i--) {
            if (Math.abs(input[start]) > Math.abs(input[end])) {
                answer[i] = input[start] * input[start];
                start++;
            } else {
                answer[i] = input[end] * input[end];
                end--;
            }
        }

        return answer;
    }

    private static int consecutiveOnes(int[] input) {
        int count = 0, max = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] == 1) {
                count++;
                max = max > count ? max : count;
            } else
                count = 0;
        }
        return max;
    }

    private static int[] twoSum(int[] twoSumInput, int target) {
        Map<Integer, Integer> complementMap = new HashMap<>();
        for (int i = 0; i < twoSumInput.length; i++) {
            int complement = target - twoSumInput[i];
            if (complementMap.containsKey(complement))
                return new int[]{complementMap.get(complement), i};
            complementMap.put(twoSumInput[i], i);
        }
        return null;
    }
}
