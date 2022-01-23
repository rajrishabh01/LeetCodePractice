package com.rough.practice;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CTCI_Arrays {

    public static void main(String[] args) {
        // No 1 Is Unique
        String uniqueTestString = "Thiis";
        System.out.println("The given string's uniqueness is : " + uniqueCharacterString2(uniqueTestString));

        //No 2 Check Permutation
        String a = "Thise";
        String b = "Tsihee";
        System.out.println("The given string are permutations : " + permutationCheck(a, b));

        //No 3 URLify
        String url = "A B C    ";
        int trueLength=5;
        System.out.println("URL flavor - " + String.valueOf(urlify(url.toCharArray(), trueLength)));

        //No 4 Palindrome Permuation Check
        String palindrome="Tact coa";
        System.out.println("This string is a palindrome permutation : " + palindromePermCheck(palindrome));

        //No 5 One Away
        String correct = "pale";
        String incorrect = "ble";
        System.out.println("This string is one edit, insert or remove away - " + oneAway(correct,incorrect));

        //No 6 String Compression
        String unCompressed = "aabbbcccc";
        System.out.println("The compressed version of this string is - " + stringCompression(unCompressed));

        //No 7 Rotate Matrix
        int matrix[][]= {
            {1,2,3},
            {4,5,6}, {7,8,9}
        };

        //System.out.println("Rotate Matrix - " + rotateMatrix(matrix));
    }

    /*private static boolean rotateMatrix(int[][] matrix) {
        if(matrix.length != matrix[0].length) return false;
        int n = matrix.length;

        for(int layer=0; layer < n/2 ;layer++){
            int first = layer;
            int last = n-1-layer;
            for(int i = first; i < last;i++){

            }
        }
    }*/

    private static String stringCompression(String unCompressed) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;

        for(int i=0; i < unCompressed.length();i++){
            countConsecutive++;

            if(i+1 >= unCompressed.length()|| unCompressed.charAt(i) != unCompressed.charAt(i+1)){
                compressed.append(unCompressed.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return unCompressed.length() < compressed.length() ? unCompressed : compressed.toString();
    }

    private static boolean oneAway(String correct, String incorrect) {
        if(Math.abs(correct.length() - incorrect.length()) > 1){
            return false;
        }
        String shorter = correct.length() < incorrect.length() ? correct : incorrect;
        String longer = correct.length() < incorrect.length() ? incorrect : correct;

        int indexA = 0;
        int indexB = 0;
        boolean foundDifference= false;
        while(indexA < shorter.length() && indexB < longer.length()){
            if(shorter.charAt(indexA) != longer.charAt(indexB)){
                if(foundDifference) return false; //found second difference, not one edit away
                foundDifference = true;

                //replace check
                if(shorter.length() == longer.length()){
                    indexA++;
                }
            } else {
                //Simply move to next index if elements match
                indexA++;
            }
            //Default move to next index if elements match/don't match
            indexB++;
        }
        return true;
    }

    //No 4 Palindrome Check
    private static boolean palindromePermCheck(String palindrome) {
        char[] palindromeArray = palindrome.toLowerCase(Locale.ROOT).toCharArray();
        int countOdd = 0;
        int[] val = new int[ Character.getNumericValue('z') - Character.getNumericValue('a')+1];
        for(char c:palindromeArray){
            int x= getCharNumber(c);
            if(x != -1){
                val[x]++;
                if(val[x] % 2 ==1){
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <=1;
    }

    private static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if(a <= val && z >=val){
            return val - a;
        }
        return -1;
    }


    //No 1 Check Unique Characters in a String --1
    private static boolean uniqueCharacterString(String uniqueTestString) {
        boolean[] uniqueCheck = new boolean[128];
        for (char c : uniqueTestString.toCharArray()) {
            int val = c;
            if (uniqueCheck[val])
                return false;
            uniqueCheck[val] = true;
        }
        return true;
    }

    //No 1 Check Unique Characters in a String -- 2
    private static boolean uniqueCharacterString2(String uniqueTestString) {
        Map<Character, Boolean> uniqueMap= new HashMap<>();
        for (Character c : uniqueTestString.toCharArray()) {
            if(null != uniqueMap.get(c) && uniqueMap.get(c) == true){
                return false;
            }
            uniqueMap.put(c, true);
        }
        return true;
    }

    //No 2 Check Permutation
    private static boolean permutationCheck(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int[] countChar = new int[128];
        for (char c : a.toCharArray()) {
            countChar[c]++;
        }
        for (char d : b.toCharArray()) {
            countChar[d]--;
            if (countChar[d] < 0) {
                return false;
            }
        }
        return true;
    }

    //No 3 URLify
    private static char[] urlify(char[] a, int truelength) {
        int index, spaceCount =0;

        for(int j= 0; j<truelength;j++){
            if(a[j] == ' '){
                spaceCount++;
            }
        }

        index = truelength + spaceCount*2;

        for(int i = truelength-1;i>=0;i--){
            if(a[i] == ' '){
                a[index-1]='0';
                a[index-2]='2';
                a[index-3]='%';
                index = index-3;
            } else {
                a[index-1]=a[i];
                index--;
            }
        }
        return a;
    }



}
