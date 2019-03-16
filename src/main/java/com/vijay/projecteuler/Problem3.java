package com.vijay.projecteuler;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Problem3 implements CommandLineRunner {
    private boolean isPrime(Long num) {
        if (num <=3l) {
            return num >1l;
        }
        if(num %2 ==0 || num%3 ==0){
            return  false;
        }
        Long i = 5l;
        while (i*i <= num){
            if(num %i == 0 || num % (i+2) ==0 ){
                return false;
            }
            i = i+6;
        }
        return true;
    }
    @Override
    public void run(String... args) throws Exception {
        Long number = 600851475143l;
        Long largestPrime = 0l;
        for (Long n = 1l; n<=Math.sqrt(number) ; n++){
            if(isPrime(n) &&number%n == 0 && n >largestPrime) {
                largestPrime = n;
            }
        }
        System.out.println("Problem 3: Largest prime factor = "+largestPrime);
    }
}
