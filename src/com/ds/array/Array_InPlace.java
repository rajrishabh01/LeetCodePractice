package com.ds.array;

public class Array_InPlace {
    public static void main(String[] args) {
        //1 Replace with greatest
        int[] replaceGreatestInput = {19, 18, 7, 4, 3};
        System.out.println("The greatest values to the right of original - "
        + replaceGreatest(replaceGreatestInput).toString());
    }

    //1 Replace with greatest
    private static int[] replaceGreatest(int[] A) {
        int max=-1;
        for(int i = A.length-1;i>=0;i--){
            int a=A[i];
            A[i]=max;
            max = Math.max(max,a);
        }
        return A;
    }
}
