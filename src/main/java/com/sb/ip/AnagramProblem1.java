package com.sb.ip;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
    Problem: check if two given strings are anagrams of each other
 */
public class AnagramProblem1 {
    public static void main(String[] args) {
        String str1 = args[0];
        String str2 = args[1];
        AnagramProblem1 anagramProblem1 = new AnagramProblem1();
        boolean result = anagramProblem1.isAnagram(str1,str2);
        System.out.println("Anagrams of each other = " + result );
    }

    public boolean isAnagram(String s1, String s2 ){
        if(s1.length() != s2.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s1.toCharArray()) {
            //System.out.println(c);
            Integer counter = map.get(c);
            if(counter == null){
                counter = 0;
            }
            map.put(c, ++counter);
        }
        for (char c: s2.toCharArray()) {
            //System.out.println(c);
            Integer counter = map.get(c);
            if(counter == null){
                counter = 0;
            }
            map.put(c, --counter);
        }
        Iterator<Integer> mapValuesIterator = map.values().iterator();
        while(mapValuesIterator.hasNext()){
            if(mapValuesIterator.next() != 0){
                return false;
            }
        }

        return true;
    }
}
