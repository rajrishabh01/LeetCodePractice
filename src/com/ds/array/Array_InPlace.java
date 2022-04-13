package com.ds.array;

import java.util.Arrays;

public class Array_InPlace {
    public static void main(String[] args) {
        //1 Replace with greatest
        int[] replaceGreatestInput = {19, 18, 7, 4, 3};
        System.out.println("The greatest values to the right of original - "
        + replaceGreatest(replaceGreatestInput));

        //2 A Better Repeated Deletion Algorithm
        int[] inPlaceDeletionArray = {0,0,0,1,1,1,2,2};
        System.out.println("In place deletion of duplicates - "
                + inPlaceDeletion(inPlaceDeletionArray));

        //3 Move Zeroes
        int[] moveZeroesIp = {0, 1, 0, 5, 13};
        System.out.println("Moving all the zeroes to the end: " + Arrays.toString(moveZeroes(moveZeroesIp)));

        //4   Sort Array By Parity
        int[] sortByParityIp = {0, 1, 0, 5, 13};
        System.out.println("Moving all even to the end: " + Arrays.toString(sortByParity(sortByParityIp)));

        //5 Remove Element k from Array
        int[] remElemIp = {0, 1, 0, 5, 13};
        int element = 0;
        System.out.println("Remove Element k we are left with element count : " + removeElementK(remElemIp, element));
    }

    //5 Remove Element k from Array
    private static int removeElementK(int[] A, int k) {
        int count = 0;
        for(int i=0; i < A.length;i++){
            if(A[i] != k) {
                A[count++]=A[i];
            }
        }
        return count;
    }

    //4   Sort Array By Parity
    private static int[] sortByParity(int[] A) {
        int index=0;
        for(int i=0; i<A.length;i++){
            if(A[i] % 2 == 0) {
                int temp = A[index];
                A[index++] = A[i];
                A[i] = temp;
            }
        }
        return A;
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

    //2 In Place Deletion of duplicates
    private static int inPlaceDeletion(int[] ip) {
        int count = 1;
        for(int i=1;i<ip.length;i++){
            if(ip[i-1]!=ip[i])
                ip[count++]=ip[i];
        }
        return count;
    }

    //1 Replace with greatest
    private static int[] replaceGreatest(int[] A) {
        int max=-1;
        for(int i = A.length-1;i>=0;i--){
            int a=A[i];
            A[i]=max;
            max = Math.max(max,a);
        }
        return A;
    }
}
