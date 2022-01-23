package com.ds.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Array_Searching {

    public static void main(String[] args) {
        //Double exists in the array
        int[] doubleCheckArr = {10, 2, 5, 3};
        System.out.println("Check if a value and its double exist-- " + doubleCheck(doubleCheckArr));

        //Mountain array
        int[] mountainArray = {0, 1, 2, 3, 2, 1};
        System.out.println("This is a Mountain array -- " + mountainArrayCheck(mountainArray));
    }

    //Mountain array
    private static boolean mountainArrayCheck(int[] mountainArray) {
        if (mountainArray.length < 3) return false;
        int start = 0;
        int end = mountainArray.length - 1;
        while (start < end) {
            if (mountainArray[start + 1] > mountainArray[start]) {
                start++;
            } else if (mountainArray[end - 1] > mountainArray[end]) {
                end--;
            } else {
                break;
            }
        }
        return start != 0 && mountainArray.length - 1 != end && start == end;
    }

    //Double exists in the array
    private static boolean doubleCheck(int[] doubleCheckArr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < doubleCheckArr.length; i++) {
            if (map.containsValue(doubleCheckArr[i] * 2) || (doubleCheckArr[i] % 2 == 0 && map.containsValue(doubleCheckArr[i] / 2))) {
                return true;
            }
            map.put(i, doubleCheckArr[i]);
        }
        return false;
    }
}
