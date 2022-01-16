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


    //No 1 Check Unique Characters in a String
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
