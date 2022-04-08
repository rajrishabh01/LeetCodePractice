package com.ds.Queue;

import java.util.ArrayList;
import java.util.List;

public class MyCircularQueue {
    private int[] data;
    private int head = 0;
    private int tail = -1;
    private int length = 0;

    public MyCircularQueue(int k) {
        data = new int[k];
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        tail = (tail + 1) % data.length;
        data[tail] = value;
        length++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        head = (head +1) % data.length;
        length--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : data[head];
    }

    public int Rear() {
        return isEmpty() ? -1 : data[tail];
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == data.length;
    }
}
