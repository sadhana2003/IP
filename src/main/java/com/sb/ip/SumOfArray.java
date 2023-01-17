package com.sb.ip;

/*
Problem: Given an array, return the total of all the elements in the array
 */
public class SumOfArray {
    public static void main(String[] args) {
        SumOfArray sumOfArray = new SumOfArray();
        int[] intArr = StringArrToIntArr(args);
        int total = sumOfArray.sum(intArr);
        System.out.println(total);
    }

    public static int[] StringArrToIntArr(String[] s) {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }

    public int sum(int[] intArr) {
        int sum = 0;
        for (int i = 0; i < intArr.length; i++) {
            sum += intArr[i];
        }
        return sum;
    }
}
