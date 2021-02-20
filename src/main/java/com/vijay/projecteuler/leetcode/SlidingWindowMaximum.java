/*
package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SlidingWindowMaximum else if{
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length ==0){
            return new int[0];
        }
        int[] result = new int[nums.length-k+1];
        int index = 0;
        for(int i=0;i<=nums.length-k; i++){
            int max = Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                if(nums[j]>max){
                    max = nums[j];
                }
            }
            result[index] = max;
            index++;
        }
        return result;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("sliding window max: "+maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));

    }
}
*/
