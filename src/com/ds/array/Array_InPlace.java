package com.ds.array;

public class Array_InPlace {
    public static void main(String[] args) {
        //1 Replace with greatest
        int[] replaceGreatestInput = {19, 18, 7, 4, 3};
        System.out.println("The greatest values to the right of original - "
        + replaceGreatest(replaceGreatestInput));

        //2 A Better Repeated Deletion Algorithm
        int[] inPlaceDeletionArray = {0,0,0,1,1,1,2,2};
        System.out.println("In place deletion of duplicates - "
                + inPlaceDeletion(inPlaceDeletionArray));
    }

    //2 In Place Deletion of duplicates
    private static int inPlaceDeletion(int[] ip) {
        int count = 1;
        for(int i=1;i<ip.length;i++){
            if(ip[i-1]!=ip[i])
                ip[count++]=ip[i];
        }
        return count;
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
