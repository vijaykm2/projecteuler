package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LongestNonRepeatingSubstring implements CommandLineRunner {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals(" ")){
            return 1;
        }
        if(s.equals("")){
            return 0;
        }
        Set<String> uniqueStrings = new HashSet();
        String[] chars =  s.split("");
        int longestString = 0;
        for(int i = 0; i<chars.length; i++) {
           // if(i == 0){
                uniqueStrings.add(chars[i]);
           // }

            for (int j = i+1; j< chars.length; j++) {
                if(uniqueStrings.contains(chars[j])){
                    /*if(uniqueStrings.size() > longestString){
                        longestString = uniqueStrings.size();
                    }
                    uniqueStrings.clear();*/
                    break;
                } else {
                    uniqueStrings.add(chars[j]);
                }
            }if(uniqueStrings.size() > longestString){
                longestString = uniqueStrings.size();
            }
            uniqueStrings.clear();
        }
        if(longestString == 0 && uniqueStrings.size() > 0){
            longestString = uniqueStrings.size();
        }
        return longestString;
    }

    @Override
    public void run(String... args) throws Exception {
      System.out.println("Longest string of abcabdcbb = "+ lengthOfLongestSubstring("abcabdcbb"));
      System.out.println("Longest string of pwwkew = "+ lengthOfLongestSubstring("pwwkew"));
      System.out.println("Longest string of aab = "+ lengthOfLongestSubstring("aab"));
        System.out.println("Longest string of '' = "+ lengthOfLongestSubstring(""));
    }
}
