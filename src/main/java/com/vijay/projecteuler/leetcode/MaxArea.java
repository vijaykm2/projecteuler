package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MaxArea implements CommandLineRunner {
    public int maxArea(int[] height){
        int maxArea = 0;
        for(int i = 0; i <height.length; i++){
            int height1 = height[i];
            for(int j = height.length-1; j > i; j--){
                int height2 = height[j];
                int smallestHeight = height1 <height2 ? height1 : height2;
                int width = j - i;
                int area = width * smallestHeight;
                maxArea = area > maxArea ? area : maxArea;
            }
        }
        return maxArea;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("=====    Running max area ====");
        System.out.println("max area of [1,8,6,2,5,4,8,3,7]"+maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
