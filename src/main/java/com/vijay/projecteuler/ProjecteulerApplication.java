package com.vijay.projecteuler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.vijay.projecteuler", "com.vijay.projecteuler.leetcode"})
public class ProjecteulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjecteulerApplication.class, args);
    }

}
