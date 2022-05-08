package com.algoexpert;

public class AlgoExpertEasy {
    public static void main(String[] args) {
        //1 Validate Subsequence
        int[] valSubseqIp1 = {5,1,4,5,6,7};
        int[] valSubseqIp2 = {1,4,7};

        System.out.println("The 2nd array is subsequence of 1st - " + validateSubsequence(valSubseqIp1, valSubseqIp2));
    }

    private static boolean validateSubsequence(int[] input, int[] subseq) {
        int ip = 0, sub=0;
        while(ip<input.length && sub < subseq.length){
            if(input[ip] == subseq[sub]){
                sub++;
            }
            ip++;
        }

        return sub == subseq.length-1;
    }
}
