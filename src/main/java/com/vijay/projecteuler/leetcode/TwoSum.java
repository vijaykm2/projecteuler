package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class TwoSum implements CommandLineRunner {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i <nums.length; i++){
            for(int j = i+1; j< nums.length; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Given nums = [2, 7, 11, 15], target = 9 : "+ Arrays.toString(twoSum(new int[]{2,7,11, 15}, 30)));
    }
}
