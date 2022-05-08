package com.blind150.stack;

import java.util.Stack;

public class StackEasy {

    public static void main(String[] args) {

        //1 Valid Parenthesis
        String validParenIp = "{}([]";
        System.out.println("The given string has valid parenthesis - " + validParen(validParenIp));
    }

    private static boolean validParen(String validParenIp) {
        if(validParenIp==null){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for(Character c : validParenIp.toCharArray()){
            if(c == '{')
                stack.push('}');
            else if(c == '(')
                stack.push(')');
            else if(c == '[')
                stack.push(']');
            else if(stack.isEmpty() || !stack.pop().equals(c))
                return false;
        }
        return stack.isEmpty();
    }


}
