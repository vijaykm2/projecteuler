package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TrappingRainWater implements CommandLineRunner
{
    public int trap(int[] height) {
        int result = 0;
        if(height == null || height.length == 0 ){
            return result;
        }
        int left = 0, right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right){
            if(height[left] < height[right]){
                if (height[left] >=leftMax) {
                    leftMax = height[left];
                } else {
                    result += leftMax-height[left];
                }
                left++;
            } else {
                if (height[right] >=rightMax) {
                    rightMax = height[right];
                } else {
                    result += rightMax-height[right];
                }
                right--;
            }
        }
        return result;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("trapped water: "+ trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
