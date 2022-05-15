package com.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlgoExpertMedium {
    public static void main(String[] args) {
        //3 Sum
        int[] inputthree = {10,-5,4,-16,-5,12};
        System.out.println("The 3 sum output here is " + threeSum(inputthree, 0));
    }

    private static List<Integer[]> threeSum(int[] inputthree, int target) {
        if(inputthree == null) return null;
        Arrays.sort(inputthree);
        List<Integer[]> answer = new ArrayList<>();
        for(int i=0; i < inputthree.length-2 ; i++){
            int left = i+1;
            int right = inputthree.length-1;
            while(left < right){
                int current = inputthree[i] + inputthree[left] + inputthree[right];
                if(current == target){
                    Integer[] inner = {inputthree[i], inputthree[left] ,inputthree[right]};
                    answer.add(inner);
                    left++;
                    right--;
                }
                else if(current < target){
                    left++;
                }else if(current > target){
                    right--;
                }
            }
        }
        return answer;
    }
}
