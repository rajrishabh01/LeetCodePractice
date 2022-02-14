package com.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_Conclusion {
    public static void main(String[] args) {
        //1 Height Checker
        int[] heights = {1, 8, 3, 7, 2, 4};
        System.out.println("The mismatch for heights is at count : " + heightChecker(heights));

        //2 Third Maximum Number
        int[] thirdMaxIp = {30, 2, 1, 1, -3};
        System.out.println("The third highest number here is : " + thirdMax(thirdMaxIp));

        //3 Find All Numbers Disappeared in an Array
        int[] disappNumsIp = {4, 1, 2, 5, 6, 8, 1, 2};
        System.out.println("The disappeared numbers are : " + disappNumbers(disappNumsIp));

        //4 Squares of a Sorted Array
        int[] sortSqIp = {-4, -1, 2, 5, 22};
        System.out.println("The disappeared numbers are : " + Arrays.toString(sortSq(sortSqIp)));


    }

    //4 Squares of a Sorted Array
    private static int[] sortSq(int[] A) {
        int[] ans = new int[A.length];
        int start =0;
        int end = A.length-1;
        for (int i = A.length - 1; i >= 0; i--) {
            if(Math.abs(A[start]) > Math.abs(A[end])){
                ans[i] = A[start] * A[start];
                start++;
            } else {
                ans[i] = A[end] * A[end];
                end--;
            }
        }
        return ans;

    }

    //3 Find All Numbers Disappeared in an Array
    private static List<Integer> disappNumbers(int[] A) {
        for (int i = 0; i < A.length; i++) {
            while (A[i] != i + 1 && A[i] != A[A[i] - 1]) {
                int temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1] = temp;
            }
        }
        List<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1)
                ans.add(i + 1);
        }
        return ans;
    }

    //2 Third Maximum Number
    private static int thirdMax(int[] A) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;

        for (Integer n : A) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }

        return max3 == null ? max1 : max3;
    }

    //1 Height Checker
    private static int heightChecker(int[] A) {
        int[] map = new int[101]; // heights go from 1 to 100
        for (int h : A) ++map[h];

        int res = 0;
        int h_ptr = 1;

        for (int h : A) {
            while (map[h_ptr] == 0) ++h_ptr;

            if (h_ptr != h) {
                ++res;
            }

            --map[h_ptr];
        }

        return res;
    }
}
