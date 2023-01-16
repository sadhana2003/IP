package com.sb.ip;

import java.util.Arrays;

/*
Problem:
Given an array, return an array such that the returnArray[i] is equal
to the product of all elements of the array except givenArray[i]

Pseudocode:
for each element in the array
    firstProduct = multiply nums[i+1] up until nums[lastIndex]
        if nums[i-1] exists
            secondProduct = multiply nums[firstIndex] up until nums[i-1]
    nums[i] = firstProduct*secondProduct
 */
public class ProductOfArrayExceptSelf1 {
    public static void main(String[] args) {
        ProductOfArrayExceptSelf1 productOfArrayExceptSelf1 = new ProductOfArrayExceptSelf1();
        int[] intArr = StringArrToIntArr(args);
        System.out.println(Arrays.toString(intArr));

        //productOfArrayExceptSelf1.printElementsInArray(intArr);
        int[] productArray = productOfArrayExceptSelf1.productExceptSelf(intArr);
        System.out.println(Arrays.toString(productArray));
        //productOfArrayExceptSelf1.printElementsInArray(productArray);
    }

    public static int[] StringArrToIntArr(String[] s) {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }

    public void printElementsInArray(int[] array) {
        for (int value : array) {
            System.out.println(value);
        }
    }

    // [1,4,7,2]
    public int[] productExceptSelf(int[] nums) {
        int[] productArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            //System.out.println("Index:" + i + " Current Value:" + nums[i]);
//            if ((i + 1) < nums.length) {
//                //System.out.println("Next Value: " + nums[i + 1]);
//            }
            int productOfAllElementsExceptCurrent = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                productOfAllElementsExceptCurrent *= nums[j];
            }

            productArray[i] = productOfAllElementsExceptCurrent;
            System.out.println("Index:" + i + " Current Value:" + nums[i] + " Product Array Value " + productArray[i]);

        }
        return productArray;
    }

}
