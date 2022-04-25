package com.ds.Queue;

import java.util.Arrays;
import java.util.Stack;

public class StackProblems_1 {

    public static void main(String[] args) {
        //1 Valid Parenthesis - check open and close of brackets, in order
        String bracketIp = "(){}[]";
        System.out.println("The String with Brackets is valid : " + validParenthesis(bracketIp));

        //2 Daily Temperatures - find the number of days to the next highest temp
        int[] temps = {74, 75, 1, 2, 3, 78};
        System.out.println("The array for the next highest temp is : " + Arrays.toString(dailyTempsStack(temps)));

        //3 Evaluate Polish Reverse Notation
        String[] evaluate = {"2", "3", "+", "5", "*"};
        System.out.println("The RPN evaluation gives - " + evalRPN(evaluate));

    }

    //3 Evaluate Polish Reverse Notation
    private static int evalRPN(String[] evaluate) {
        int a, b;
        Stack<Integer> stack = new Stack<>();
        //can use switch instead
        for (String s : evaluate) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a - b);
            } else if (s.equals("/")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a / b);
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }

    //2 Daily Temperatures - Stack
    private static int[] dailyTempsStack(int[] temps) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temps.length];

        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && temps[i] > temps[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        return answer;
    }

    //2 Daily Temperatures - Array
    private static int[] dailyTempsArray(int[] temps) {
        int[] stack = new int[temps.length];
        int top = -1;
        int[] answer = new int[temps.length];
        for (int i = 0; i < temps.length; i++) {
            while (top > -1 && temps[i] > temps[stack[top]]) {
                int idx = stack[top--];
                answer[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return answer;
    }

    //1 Valid Parenthesis
    private static boolean validParenthesis(String bracketIp) {
        Stack<Character> stack = new Stack<>();

        for (char c : bracketIp.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }

        return stack.isEmpty();
    }
}
