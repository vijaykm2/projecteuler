package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LongestValidParen implements CommandLineRunner {

    private int getNumberofChars(String src, char c){
        char[] chars = src.toCharArray();
        int numberOfchars = 0;
        for(char s: chars){
            if(s == c){
                numberOfchars++;
            }
        }
        return numberOfchars;
    }
    public int longestValidParentheses(String s) {
        int indexOfOpen = s.indexOf("(");
        int indexOfClose = s.lastIndexOf(")");
        String substring = "";
        int length = s.length();
        if (indexOfClose < indexOfOpen || indexOfOpen == -1 || indexOfClose == -1) return 0;
        if(indexOfClose == length - 1){
            substring = s.substring(indexOfOpen);
        }else {
            substring = s.substring(indexOfOpen, indexOfClose+1);
        }
        int numberOfOpens = getNumberofChars(substring, '(');
        int numberOfCloses = getNumberofChars(substring, ')');

        if (numberOfCloses - numberOfOpens == 0){
            length =  substring.length();
        } else if(numberOfCloses -numberOfOpens > 0){
            return longestValidParentheses(substring.substring(0, substring.length() -1));
        } else if (numberOfCloses - numberOfOpens < 0 ) {
            return longestValidParentheses(substring.substring(1));
        }
        return length;


    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running Longest valid Paren");
        System.out.println(longestValidParentheses("()"));
        System.out.println(longestValidParentheses("()))()())"));
        System.out.println(longestValidParentheses(")(())))(())())"));
    }
}
