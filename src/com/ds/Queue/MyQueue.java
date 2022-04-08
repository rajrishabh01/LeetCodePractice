package com.ds.Queue;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {

    private List<Integer> data;
    private int p_start;

    public MyQueue() {
        data= new ArrayList<>();
        this.p_start = 0;
    }

    public boolean enQueue(int x){
        data.add(x);
        return true;
    }

    public boolean deQueue(){
        if(isQueueEmpty()){
            return false;
        }
        p_start++;
        return true;
    }

    public boolean isQueueEmpty() {
        return p_start >= data.size();
    }

    public int inFront(){
        return data.get(p_start);
    }

}
