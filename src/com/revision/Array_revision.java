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

    }

    private static int[] twoSum(int[] twoSumInput, int target) {
        Map<Integer, Integer> complementMap = new HashMap<>();
        for(int i=0; i<twoSumInput.length; i++){
            int complement = target - twoSumInput[i];
            if(complementMap.containsKey(complement))
                return new int[]{complementMap.get(complement), i};
            complementMap.put(twoSumInput[i], i);
        }
        return null;
    }
}
