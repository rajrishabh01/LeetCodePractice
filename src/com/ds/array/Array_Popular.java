package com.ds.array;

import java.util.HashMap;
import java.util.Map;

public class Array_Popular {
    public static void main(String[] args) {
        //Two Sum
        int[] twoSumInput = new int[]{1,2,3,4};
        int target = 4;
        System.out.println(twoSum(twoSumInput, target).toString());
    }

    //Two Sum
    private static int[] twoSum(int[] twoSumInput, int target) {
        Map<Integer, Integer> complementMap = new HashMap<>();
        for(int i=0; i< twoSumInput.length;i++){
            int complement = target - twoSumInput[i];
            if(complementMap.containsKey(complement)){
                return new int[] {
                        complementMap.get(complement),i
                };
            } else {
                complementMap.put(twoSumInput[i],i);
            }
        }
        return null;
    }
}
