package com.sb.ip;

import java.util.Arrays;

/*
 Problem: find min regardless of how many times the array is rotated
 */
public class FindMin1 {
    public static void main(String[] args) {
        FindMin1 findMin1 = new FindMin1();
        int[] intArr = StringArrToIntArr(args);
        int minimumInArray = findMin1.findMin(intArr);
        System.out.println(minimumInArray);
    }
    // 2,4,6,3,1
    public int findMin(int[] array){
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min < array[i]){
                continue;
            } else {
                min = array[i];
            }
        }
        return min;
    }

    public static int[] StringArrToIntArr(String[] s) {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }
}
