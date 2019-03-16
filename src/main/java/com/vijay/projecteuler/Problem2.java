package com.vijay.projecteuler;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Problem2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Long prevFib = 1l;
        Long currentFib =2l;
        Long result = 2l;
        while(currentFib<4000000l){
            Long nextFib = prevFib+currentFib;
            prevFib = currentFib;
            currentFib = nextFib;
            if(nextFib%2 == 0){
                result += nextFib;
            }

        }
        System.out.println("Problem 2: Sum of even fibs = "+ result);

    }
}
