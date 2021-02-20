package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RemoveDuplicatesFromSortedArray implements CommandLineRunner {
    public int removeDuplicates(int[] nums) {
        if(nums== null || nums.length <2){
            return 0;
        }
        int duplicateCount = 0;
        int length = nums.length;
        for(int i=0;i<length-duplicateCount;i++){
            if(i+1<length && nums[i]==nums[i+1]&& i+1!=length-duplicateCount){
                int duplicate=nums[i+1];
                for(int j=i+1;j<length-1;j++){
                    nums[j]=nums[j+1];
                }
                nums[length-1]=duplicate;
                duplicateCount++;
                i--;
            }
        }
        return length -duplicateCount;

    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println(
                "Remove duplicates ****"
        );
        System.out.println(removeDuplicates(new int[]{1,2}));
    }
}
