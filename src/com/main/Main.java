package com.main;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, String> testMap = new HashMap<>();

        testMap.put("one", "R");
        testMap.put("one", "A");
        testMap.put("one", "T");

        boolean accept = Boolean.FALSE;
        accept = testMap.keySet().stream().allMatch(v -> v == "one");

        System.out.println("this value is - " + accept);

    }
}
