package com.vijay.projecteuler;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MissingNum implements CommandLineRunner {

    long getMissingNum(long[] arr){
        long missingNum = 0;

        boolean isNumMissing = false;
        for(int i = 0; i< arr.length-1; i++){
            if(arr[i]+1 != arr[i+1]){
                isNumMissing = true;
                missingNum = arr[i]+1;
            }
        }
        if (!isNumMissing){
            System.out.println("There is no missing number.");
        }
        return missingNum;
    }
    

    @Override
    public void run(String... args) throws Exception {
        System.out.println("***************** Missing NUm *****");
        long missingNum  = getMissingNum(new long[]{1,2,3,4,5,6,7,9});
        System.out.println("Missing Num is "+ missingNum);
    }
}
