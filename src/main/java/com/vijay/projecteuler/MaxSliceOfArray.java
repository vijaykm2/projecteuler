package com.vijay.projecteuler;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class MaxSliceOfArray  implements CommandLineRunner {

    long getMaxSlice(long[] arr) {
        long longestSlice = 0;
        for(int i =0; i<arr.length; i++){
            Set<Long> uniqNums=new HashSet<>();
            uniqNums.add(arr[i]);
            long sliceLen = 1;

            for(int j = i+1; j<arr.length && uniqNums.size()<3; j++){
                uniqNums.add(arr[j]);
                if(uniqNums.size()<3){
                    sliceLen += 1;
                }

            }
            if (sliceLen > longestSlice) {
                longestSlice = sliceLen;
            }
        }
        return longestSlice;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("************* Running MaxSliceOfArray *************** ");
        long[] arr = new long[]{1,2,3};
        long maxSlice = getMaxSlice(arr);
        System.out.println("Max slice len = "+maxSlice);
    }
}
