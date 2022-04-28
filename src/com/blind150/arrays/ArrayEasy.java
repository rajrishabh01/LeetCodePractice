package com.blind150.arrays;

import java.util.*;

public class ArrayEasy {
    public static void main(String[] args) {
        //1 Contains Duplicate
        int[] nums1= {1,2,3,5};
        System.out.println("The given input has a duplicate element - " + duplicateElement(nums1));

        //2 is Anagram
        String str1= "anagram";
        String str2= "amhagran";

        System.out.println("The given input is an anagram - " + isAnagram(str1, str2));

        //3 Two sum
        int[] twoSumip= {1,2,3,2};
        int target = 5;
        System.out.println("The given input is a valid two sum - " + Arrays.toString(twoSum(twoSumip, target)));
    }

    private static int[] twoSum(int[] twoSumip, int target) {
        Map<Integer, Integer> complementMap = new HashMap<>();
        for(int i=0; i<twoSumip.length;i++){
            int comp = target - twoSumip[i];
            if(complementMap.containsKey(twoSumip[i])){
                return new int[]{complementMap.get(twoSumip[i]),i};
            }
            complementMap.put(comp, i);
        }
        return null;
    }

    private static boolean isAnagram(String str1, String str2) {
        if(str1.length() != str2.length()) return false;
        if(str1.equals(str2)) return true;

        int[] answer = new int[126];
        for(char c: str1.toCharArray()){
            answer[c]++;
        }
        for(char d: str2.toCharArray()){
            answer[d]--;
            if(answer[d] < 0)
                return false;
        }
        return true;
    }

    private static boolean duplicateElement(int[] nums1) {
        Set<Integer> answer = new HashSet<>();
        for(int c : nums1){
            if(answer.contains(c)) return true;
            answer.add(c);
        }

        return false;
    }
}
