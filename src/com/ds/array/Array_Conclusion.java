package com.ds.array;

import java.util.ArrayList;
import java.util.Arrays;

public class Array_Conclusion {
    public static void main(String[] args) {
        //1 Height Checker
        int[] heights = {1,8,3,7,2,4};
        System.out.println("The mismatch for heights is at count : " + heightChecker(heights));
    }

    //1 Height Checker
    private static int heightChecker(int[] A) {
        int[] map = new int[101]; // heights go from 1 to 100
        for(int h: A) ++map[h];

        int res = 0;
        int h_ptr = 1;

        for(int h: A) {
            while(map[h_ptr] == 0) ++h_ptr;

            if(h_ptr != h) {
                ++res;
            }

            --map[h_ptr];
        }

        return res;
    }
}
