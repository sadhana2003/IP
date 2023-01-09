package com.sb.ip;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
Problem: Find the length of the longest consecutive sequence in a given array of ints
This program assumes the array of ints is passed via the program arguments in String[] args
Pseudocode:
Input: nums = [0,3,7,2,5,8,4,6,0,1, 400, 401, 402]
sortedNums = [0,0,1,2,3,4,5,6,7,8,400,401,402]
Output: 9
    sort array
    initialize lengthOfConsecutiveSequence = 1
    initialize hashmap<int key, int value>
    loop through the array
        take current element
        if next element is same
            continue
        else if next elements is +1 of current element
            increase the lengthOfConsecutiveSequence by 1
        else
            lengthOfConsecutiveSequence = 1

        hashmap.put(current element, lengthOfConsecutiveSequence)

    iterate through hashmap and print the max value, which is the lengthOfConsecutiveSequence

 */
public class LongestConsecutiveSequenceLengthProblem1 {
    public static void main(String[] args) {
        LongestConsecutiveSequenceLengthProblem1 longestConsecutiveSequenceLengthProblem1 = new LongestConsecutiveSequenceLengthProblem1();
        int[] intArr = StringArrToIntArr(args);
        int lengthOfLongestConsecutive = longestConsecutiveSequenceLengthProblem1.longestConsecutive(intArr);
        System.out.println(lengthOfLongestConsecutive);
    }
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int lengthOfSequence = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length-1; i++) {
            int currElement = nums[i];
            int nextElement= nums[i+1];
            if (currElement == nextElement){
                continue;
            } else if(nextElement == currElement+1) {
                map.remove(currElement);
                lengthOfSequence++;
            } else {
                lengthOfSequence = 1;
            }

            map.put(nextElement,lengthOfSequence);
        }
        // now iterate through hashmap
        Iterator<Integer> valuesIterator = map.values().iterator();
        int maxValue = 0;
        while(valuesIterator.hasNext()){
            int value = valuesIterator.next();
            if (value > maxValue){
                maxValue = value;
            }
        }
        return maxValue;
    }

    public static int[] StringArrToIntArr(String[] s) {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }
}
