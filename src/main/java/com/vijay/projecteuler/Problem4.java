package com.vijay.projecteuler;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Problem4 implements CommandLineRunner {
    private boolean isPalindrome(Long number){
        String numStr = number.toString();
        String revStr = new StringBuilder(numStr).reverse().toString();
        if(numStr.equals(revStr)){
            return true;
        }return false;
    }
    @Override
    public void run(String... args) throws Exception {
        Long largestPalin = 0l;
        for ( long i = 100l; i< 1000l; i++ ){
            for(long j = 100l; j< 1000l; j++){
                long product = i*j;
                if(product > largestPalin && isPalindrome(product)){
                    largestPalin = product;
                }
            }
        }
        System.out.println("Problem 4: Largest palindrome is = "+largestPalin);

    }
}
