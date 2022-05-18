package com.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AlgoExpertMedium {
    public static void main(String[] args) {
        //3 Sum
        int[] inputthree = {10,-5,4,-16,-5,12};
        System.out.println("The 3 sum output here is " + threeSum(inputthree, 0));

        //Smallest Difference
        int[] arr1 = {-5,10,5};
        int[] arr2 = {15,100,45};
        System.out.println("The smallest diff between the 2 arrs is " + Arrays.toString(smallestDiff(arr1, arr2)));

        //Move Element to the end
        List<Integer> endArrIp = new ArrayList<>();
        Collections.addAll(endArrIp,2,1,2,3,2,4,8,9,2);
        int target = 2;
        System.out.println("The update array is " + (moveElementToEnd(endArrIp, target)).toString());

        //Monotonic Array
        int[] monoIp = {-1,-2,-3,5};
        System.out.println("This is a monotonic array " + monotonicArray(monoIp));

        //Longest Peak
        int[] longPeakIp = {1,2,3,4,1,0,3};
        System.out.println("The longest peak is " + longestPeak(monoIp));

    }

    //Longest Peak
    private static int longestPeak(int[] A) {
        int i=1;
        int maxLength = 0;

        while(i < A.length){
            int increase = 0, decrease = 0;

            while(i < A.length && A[i-1] < A[i]) {i++; increase++;}
            while(i < A.length && A[i-1] > A[i]) {i++; decrease++;}

            if(increase >0 && decrease >0) maxLength = Math.max(maxLength,
                    increase+decrease+1);
            while(i<A.length && A[i-1] == A[i]) i++;

        }

        return maxLength;
    }

    //Monotonic Array
    private static boolean monotonicArray(int[] monoIp) {
        if(monoIp.length == 0) return true;
        int less =0, more=0;
        for(int i =1; i<monoIp.length;i++){
            if(monoIp[i] <= monoIp[i-1]) less++;
            if(monoIp[i] >= monoIp[i-1]) more++;
        }

        return less == monoIp.length-1 || more == monoIp.length-1;
    }

    private static List<Integer> moveElementToEnd(List<Integer> endArrIp, int target) {
        int count=0;
        int ptr=0;
        for(int i=0; i<endArrIp.size(); i++){
            if(endArrIp.get(i) == target){
                count++;
            }
            else {
                endArrIp.set(ptr, endArrIp.get(i));
                ptr++;
            }
        }

        int reverseCount = (endArrIp.size() - 1) - count;
        for(int r = endArrIp.size()-1; r>reverseCount; r--){
            endArrIp.set(r, target);
        }

        return endArrIp;
    }

    //Smallest Difference
    private static int[] smallestDiff(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int a=0, b = 0;
        int minDiff = Integer.MAX_VALUE;
        int[] resultArr = new int[2];
        while(a < arr1.length && b < arr2.length){
            int diff = Math.abs(arr1[a] - arr2[b]);
            if(diff < minDiff){
                minDiff = diff;
                resultArr = new int[]{arr1[a], arr2[b]};
            }
            if (arr1[a] < arr2[b])
                a++;
            else if (arr1[a] > arr2[b])
                b++;
            else
                return new int[]{arr1[a], arr2[b]};
        }
        return resultArr;
    }

    private static List<Integer[]> threeSum(int[] inputthree, int target) {
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
