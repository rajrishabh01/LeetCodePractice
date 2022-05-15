package com.rough.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Random_problems_1 {
    public static void main(String[] args) {
        //2 Max Subarray
        int[] maxSub = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray is at : " + maxSubarray(maxSub));

        //3 The Recursive test
        List<Integer> sumArr = new ArrayList<>();
        Collections.addAll(sumArr, 2, 4, 6, 14, 2, 28, 1, -1, -5);
        System.out.println("recursive rep - " + recursiveSum(sumArr) + "- and the max of elements is " + recursiveMax(sumArr));
        System.out.println("Quicksorted - " + quickSort(sumArr));

    }

    //3 The Recursive test
    private static int recursiveSum(List<Integer> arr) {
        if (arr.size() == 0)
            return 0;
        return arr.get(0) + recursiveSum(arr.subList(1, arr.size()));
    }

    //3 The Recursive test
    private static int recursiveCounting(List<Integer> arr) {
        if (arr.size() == 0)
            return 0;
        return 1 + recursiveCounting(arr.subList(1, arr.size()));
    }

    //4 Max number in a list
    private static int recursiveMax(List<Integer> arr) {
        if (arr.size() == 0)
            return -1;
        return arr.get(0) > recursiveMax(arr.subList(1, arr.size())) ? arr.get(0) : recursiveMax(arr.subList(1, arr.size()));
    }

    //Quick sort
    private static List<Integer> quickSort(List<Integer> arr) {
        if (arr.size() < 2)
            return arr;

        int pivot = arr.get(0);
        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        for (int l : arr.subList(1,arr.size())) {
            if (l <= pivot)
                less.add(l);
            else
                greater.add(l);
        }

        current.addAll(quickSort(less));
        current.addAll(Arrays.asList(pivot));
        current.addAll(quickSort(greater));

        return current;
    }

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
}
