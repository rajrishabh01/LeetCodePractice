package com.ds.Queue;

import java.util.ArrayList;
import java.util.List;

public class QueueMain {
    public static void main(String[] args) {
        int value = 0;
        Integer value1 = 0;

        Integer answer1 = value1 % 5;
        int answer = value % 5;

        List<Integer> tryNew = new ArrayList<>(5);
        int[] tryNew1 = new int[5];

        System.out.println("List value - " + tryNew.size());
        System.out.println("int[] value - " + tryNew1.length);
    }
}
