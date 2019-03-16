package com.vijay.projecteuler;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Problem1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Set<Integer> multiples = new HashSet<>();
        for(int i = 1; i<1000; i++){
            if(i%3 == 0 || i%5 ==0){
                multiples.add(i);
            }
        }
        Integer result = 0;
        for(Integer i: multiples){
            result += i;
        }
        System.out.println("Problem 1 : Sum of multiples of 3 & 5 = "+result);
    }
}
