package com.ds.Queue;

public class StackLL {

    class Node {
        Node next;
        int val;

        Node(int k) {
            this.val = k;
        }
    }

    Node top;
    Node bottom;
    int length;

    //constructor
    StackLL() {
        this.top = null;
        this.bottom = null;
        this.length = 0;
    }

    //peek
    public int peek() {
        if (isEmpty()) {
            return -1;
        }

        return this.top.val;
    }

    private boolean isEmpty() {
        if (this.length == 0 || this.top == null) {
            return true;
        }
        return false;
    }

    //push
    public void push(int x) {
        Node temp = new Node(x);
        temp.next = top;
        top = temp;
        length++;
    }


    //pop
    public int pop() {
        if (!isEmpty()) {
            top = top.next;
            length--;
            return top.val;
        }
        return -1;
    }
}
