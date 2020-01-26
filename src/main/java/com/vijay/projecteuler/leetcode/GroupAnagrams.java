package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GroupAnagrams implements CommandLineRunner {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result =  new ArrayList<>();
        if(strs ==null || strs.length ==0){
            return result;
        }
        Map<String, List<String>> anagramsSet= new HashMap<>();
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            StringBuilder orderd = new StringBuilder();
            /*for(String chr: chars){
                orderd.append(chr);
            }*/
            String orderedStr = new String(chars);
            if(!anagramsSet.containsKey(orderedStr)){
                anagramsSet.put(orderedStr, new ArrayList<>());
            }
            anagramsSet.get(orderedStr).add(str);
        }
        for(List<String> res: anagramsSet.values()){
            result.add(res);
        }
        return result;
    }
    @Override
    public void run(String... args) throws Exception {
        List<List<String>> result = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println("after group anagrams");
    }
}
