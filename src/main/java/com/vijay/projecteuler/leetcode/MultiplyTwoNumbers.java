package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MultiplyTwoNumbers implements CommandLineRunner {
    /*private String multiply(String[] arr1, String[] arr2){
        List<List> intermediateResults = new ArrayList<>();
        for(long i= arr2.length -1; i >=0; i--) {
            List<String> intermediateResult = new ArrayList<>();
            long k =arr2.length-1-i;
            while (k!=0){
                intermediateResult.add("0");
                k--;
            }
            long co = 0l;
            for( long j = arr1.length-1; j >=0; j--) {
                int res = Integer.parseInt(arr2[i]);
            }

        }

        return null;
    }
    public String multiply(String num1, String num2) {
        String n1;
        String n2;
        if (num1 == num2) {
            n1 = num1;
            n2 = num2;
        } else {
            n1 = num1.length() >num2.length() ? num1 : num2;
            n2 = num1.length() >num2.length() ? num2 : num1;
        }
        long maxLength = n1.length() +n2.length();
        String[] n1Arr = n1.split("");
        String[] n2Arr = n2.split("");
        return multiply(n1Arr, n2Arr);
    }
    public void run(String... args){
        multiply("123", "456");
    }*/
    public void run(String... args) {

    }
}
