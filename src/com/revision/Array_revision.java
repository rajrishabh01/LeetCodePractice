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

        //3 Move Zeroes
        int[] moveZeroesIp = {0, 1, 0, 5, 13};
        System.out.println("Moving all the zeroes to the end: " + Arrays.toString(moveZeroes(moveZeroesIp)));

        //4   Sort Array By Parity
        int[] sortByParityIp = {0, 12, 5, 15, 32, 35};
        System.out.println("Moving all odd to the end: " + Arrays.toString(sortByParity(sortByParityIp)));

        //5 Remove Element k from Array
        int[] remElemIp = {0, 1, 0, 5, 13};
        int element = 0;
        System.out.println("Remove Element k we are left with element count : " + removeElementK(remElemIp, element));

    }

    private static int removeElementK(int[] remElemIp, int element) {
        int count = 0;
        for (int i = 0; i < remElemIp.length; i++) {
            if (remElemIp[i] != element) {
                remElemIp[count++] = remElemIp[i];
            }
        }
        return count;
    }

    private static int[] sortByParity(int[] input) {
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] % 2 == 0) {
                int temp = input[index];
                input[index++] = input[i];
                input[i] = temp;
            }
        }
        return input;
    }

    private static int[] moveZeroes(int[] input) {
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != 0) {
                input[count++] = input[i];
            }
        }
        int k = input.length - count;
        for (int j = input.length - 1; j > k; j--) {
            input[j] = 0;
        }

        return input;
    }

    private static int[] inPlaceDeletion(int[] input) {
        int count = 1;
        for (int i = 1; i < input.length; i++) {
            if (input[i - 1] != input[i])
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
                max = Math.max(max, count);
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
