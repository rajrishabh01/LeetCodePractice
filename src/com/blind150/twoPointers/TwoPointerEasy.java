package com.blind150.twoPointers;

public class TwoPointerEasy {
    public static void main(String[] args) {
        //1 Valid Palindrome
        String palidromeIp = "A man, A plan, A canal: Panama";
        System.out.println("The given statement is a palindrome -" + palidromeIp(palidromeIp));
    }

    private static boolean palidromeIp(String s) {
        if(s.isEmpty())
            return true;

        int head=0;
        int tail=s.length()-1;

        char cHead,cTail;

        while(head<=tail){
            cHead = s.charAt(head);
            cTail = s.charAt(tail);

            if(!Character.isLetterOrDigit(cHead)){
                head++;
            }else if(!Character.isLetterOrDigit(cTail)){
                tail--;
            } else {
                if(Character.toLowerCase(cHead) != Character.toLowerCase(cTail)){
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }

}
