package com.sb.ip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given an array of strings, remove the elements that are anagrams of previous elements
 */
public class AnagramProblem2 {
    public static void main(String[] args) {
        List<String> resultList = new ArrayList<>();

        /*
        a
        b
        c
        a
         */

        for (int i = 0; i < args.length; i++) {
            String currElement = args[i];
            if (i == 0) {
                resultList.add(currElement);
            } else {
                boolean isAnagramFoundForCurrentElementInReturnList = false;
                for (String result : resultList) {
                    // check if args[i] and result are anagrams
                    boolean isAnagram = isAnagram(result, currElement);
                    if (isAnagram) {
                        isAnagramFoundForCurrentElementInReturnList = true;
                        break;
                    }
                }

                if (!isAnagramFoundForCurrentElementInReturnList) {
                    resultList.add(currElement);
                }

            }
        }
        for (String r : resultList) {
            System.out.println(r);
        }
    }

    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();


        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        boolean result = Arrays.equals(charArray1, charArray2);
        return result;
    }

}
