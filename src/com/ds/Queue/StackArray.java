package com.ds.Queue;

public class StackArray {
    int[] vals;
    int top;

    StackArray(int x){
        vals = new int[x];
        this.top=-1;
    }

    //peek
    public int peek(){
        if(!isEmpty()) {
            return vals[top];
        }
        return -1;
    }

    private boolean isEmpty() {
        return top < 0;
    }

    //push
    public void push(int ip){
        if(++top > vals.length){
            return;
        }
        vals[++top] = ip;
    }

    //pop
    public int pop(){
        if(!isEmpty()) {
            return vals[top--];
        }
        return -1;
    }

}
