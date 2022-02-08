package com.rough.practice;

public class Random_problems_1 {
    public static void main(String[] args) {
        //2 Max Subarray
        int[] maxSub = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Maximum subarray is at : " + maxSubarray(maxSub));
    }

    private static int maxSubarray(int[] maxSub) {
        int sum ,max;
        sum = max = maxSub[0];
        for(int i=1; i<maxSub.length;i++){
            if(sum < 0)
                sum = maxSub[i];
            else
                sum += maxSub[i];
            max = Math.max(max, sum);
        }

        return max;
    }
}
