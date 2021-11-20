package com.ds.array;

import java.util.Arrays;

public class Array_Intro {
    public static void main(String[] args) {

        //1
        int[] consOnes = new int[]{1,0,1,1,1,0,1,1};
        System.out.println(consecutiveOnes(consOnes));

        //2
        int[] evenDigitsArray = new int[]{123,1001,66,1};
        System.out.println(findNumbers(evenDigitsArray));

        //3
        int[] squaredArray = new int[]{-4,-1,0,3,6};
        System.out.println(Arrays.toString(sortedSquares(squaredArray)));

    }

    //3   Squares of a Sorted Array
    //Given an integer array nums sorted in
    // non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
    static int[] sortedSquares(int[] input) {
        int[] answer = new int[input.length];
        int start=0;
        int end = input.length-1;
        for(int endCursor=input.length-1;endCursor>=0;endCursor-- ){
            if(Math.abs(input[start]) > Math.abs(input[end])){
                answer[endCursor] = input[start] * input[start];
                start++;
            } else {
                answer[endCursor] = input[end] * input[end];
                end--;
            }
        }
        return answer;
    }


    //2 Find Numbers with Even Number of Digits
    // Given an array nums of integers, return how many of them contain an even number of digits.
    static int findNumbers(int[] input) {
        int count=0;
        for (int j : input) {
            int num = j;
            int evenCounter = 0;
            while (num != 0) {
                num = num / 10;
                evenCounter++;
            }
            if (evenCounter % 2 == 0) {
                count++;
            }
        }
        return count;
    }


    //1 EASY Max Consecutive Ones - Given a binary array nums,
    // return the maximum number of consecutive 1's in the array.
    static int consecutiveOnes(int[] arr){
        int count = 0;
        int maxCount = 0;
        for (int j : arr) {
            if (j == 1) {
                count++;
            } else {
                count = 0;
            }
           // maxCount = count > maxCount ? count : maxCount;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
