package com.ds.array;

import java.util.*;

public class Array_Popular {
    public static void main(String[] args) {
        //1 Two Sum
        int[] twoSumInput = new int[]{1, 2, 3, 4};
        int target = 4;
        System.out.println(Arrays.toString(twoSum(twoSumInput, target)));

        //2 Max Subarray
        int[] maxSub = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray is at : " + maxSubarray(maxSub));

        //3 Move Zeroes
        int[] moveZeroesIp = {0, 1, 0, 5, 13};
        System.out.println("Moving all the zeroes to the end: " + Arrays.toString(moveZeroes(moveZeroesIp)));

        //4 Contains Duplicate
        int[] containsDuplicateIp= {0, 1, 2, 3};
        System.out.println("Moving all the zeroes to the end: " + containsDuplicate(containsDuplicateIp));

        //5 Rotate Array
        int[] rotateArrayIp= {0, 1, 2, 3, 4, 5, 6};
        int k = 3;
        System.out.println("Moving all the zeroes to the end: " + Arrays.toString(rotateArray(rotateArrayIp, k)));
    }

    //5 Rotate Array
    private static int[] rotateArray(int[] A, int k) {
        k %= A.length;

        reverse(A, 0, A.length-1);
        reverse(A, 0, k-1);
        reverse(A, k, A.length-1);

        return A;
    }

    //Classic Reverse - VERY USEFUL
    private static void reverse(int[] A, int start, int end) {
        while(start<end){
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }

    //4 Contains Duplicate
    private static boolean containsDuplicate(int[] A) {
        Set<Integer> ansMap = new HashSet<>();
        for(int i=0; i<A.length;i++){
            if(!ansMap.add(A[i]))
                return true;
        }
        return false;
    }

    //3 Move Zeroes
    private static int[] moveZeroes(int[] A) {
        if (A.length > 1) {
            int count, j;
            count = j = 0;

            for (int i = 0; i <= A.length - 1; i++) {
                if (A[i] == 0)
                    count++;
                else
                    A[j++] = A[i];
            }

            int k = A.length - 1 - count;
            for (int i = A.length - 1; i > k; i--) {
                A[i] = 0;
            }
            return A;
        }
        return A;
    }

    //2 Max Subarray
    private static int maxSubarray(int[] maxSub) {
        int sum, max;
        sum = max = maxSub[0];
        for (int i = 1; i < maxSub.length; i++) {
            if (sum < 0)
                sum = maxSub[i];
            else
                sum += maxSub[i];
            max = Math.max(max, sum);
        }

        return max;
    }

    //1 Two Sum
    private static int[] twoSum(int[] twoSumInput, int target) {
        Map<Integer, Integer> complementMap = new HashMap<>();
        for (int i = 0; i < twoSumInput.length; i++) {
            int complement = target - twoSumInput[i];
            if (complementMap.containsKey(complement)) {
                return new int[]{
                        complementMap.get(complement), i
                };
            } else {
                complementMap.put(twoSumInput[i], i);
            }
        }
        return null;
    }
}
