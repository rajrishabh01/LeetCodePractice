package com.blind150.binarySearch;

public class BinarySeachEasy {
    public static void main(String[] args) {
        //1 Binary Search
        int[] nums = {-1, 0, 4, 5, 9};
        int target = 19;
        System.out.println("The target is at - " + binarySearch(nums, target));
    }

    private static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low)/ 2;
            //First check to match
            if (target == nums[mid])
                return mid;
            //then go for if else adjustments
            if (target > nums[mid]) {
                low = mid+1;
            } else if (target < nums[mid]) {
                high = mid-1;
            }
        }

        return -1;
    }
}

