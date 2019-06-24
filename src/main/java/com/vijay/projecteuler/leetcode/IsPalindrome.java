package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class IsPalindrome implements CommandLineRunner {
    public boolean isPalindrome(int x){
        String str = Integer.toString(x);
        return str.equals(new StringBuilder(str).reverse().toString());
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n *******Running number is palindrome by converting to string*********\n");

        System.out.println("is palindrome 123  = "+isPalindrome(123));
        System.out.println("is palindrome 121  = "+isPalindrome(121));
        System.out.println("is palindrome 1221  = "+isPalindrome(1221));
        System.out.println("is palindrome -1221  = "+isPalindrome(-1221));
    }
}
