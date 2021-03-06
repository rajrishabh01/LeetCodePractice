package com.ds.array;

import java.util.Arrays;

//Check this class again
public class Array_Inserting_Recheck {

    public static void main(String[] args) {
        //Duplicate Zeroes
        int[] duplicateZeroesInput = new int[]{1,0,0,2,3,0,4};
        System.out.println(Arrays.toString(duplicateZeroes(duplicateZeroesInput)));
    }

    //Duplicate Zeroes
    static int[] duplicateZeroes(int[] input){
        int shift=0;
        for(int i=0; i+shift < input.length;++i){
            if(input[i]==0){
                shift+=1;
            }
        }
        return input;
    }
}
