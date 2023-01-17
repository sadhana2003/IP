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

    // [0, 1,4,7,2, 0, 8 , 9 , 3 , 4 , 5]
    // find
    public int[] productExceptSelf(int[] nums) {
        int[] productArray = new int[nums.length];
        // step 1: find product of entire array excluding 0s and count of zeroes
        int product = 1;
        int numberOfZeroes = 0;
        for (int element : nums) {
            if (element == 0){
                numberOfZeroes++;
            } else {
                product *= element;
            }
        }
        // step 2:
        // productArray[i] = 0 if count of zeroes is greater than 1
        // productArray[i] = "divide product by nums[i]" if count of zeroes is 0
        // productArray[i] = "product" if count of zeroes is 1 and nums[i] == 0
        // productArray[i] = "0" if count of zeroes is 1 and nums[i] != 0

        for (int i = 0; i < nums.length ; i++) {
             if(numberOfZeroes == 0) {
                productArray[i] = product / nums[i];
            } else if (numberOfZeroes > 1){
                 productArray[i] = 0;
             } else if (numberOfZeroes == 1 && nums[i] == 0) {
                 productArray[i] = product;
             } else if (numberOfZeroes == 1 && nums[i] != 0){
                 productArray[i] = 0;
             }
        }
        return productArray;
    }

}
