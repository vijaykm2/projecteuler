package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MultiplyTwoNumbers implements CommandLineRunner {
    public Integer findBiggest(LinkedList<Integer> num1, LinkedList<Integer> num2){
        if(num1.size() < num2.size()){
            return -1;
        } else if(num1.size() >num2.size()){
            return 1;
        }else {

            for(int i = 0; i<num1.size(); i++){
                if(num1.get(i) >num2.get(i)){
                    return 1;
                } else if(num1.get(i) <num2.get(i)){
                    return -1;
                }
            }
            return 0;
        }
    }
    public LinkedList<Integer> addTwoNumbers(LinkedList<Integer> num1, LinkedList<Integer> num2){
        if(num1.size() <num2.size()){
            while (num1.size() != num2.size()){
                num1.add(0, 0);
            }
        }else if(num1.size() >num2.size()) {
            while (num1.size() != num2.size()){
                num2.add(0, 0);
            }
        }
        Iterator<Integer>num1Iter = num1.descendingIterator();
        Iterator<Integer>num2Iter = num2.descendingIterator();
        Integer carryover = 0;
        LinkedList<Integer> result = new LinkedList<>();
        while(num1Iter.hasNext()){
            Integer temp = num1Iter.next()+num2Iter.next() +carryover;
            result.add(0, temp%10);
            carryover = temp/10;
            if(!num1Iter.hasNext() && carryover >0){
                result.add(0, carryover);
            }
        }
        return result;
    }
    public LinkedList<Integer> addIntermediateResults(List<LinkedList<Integer>> intermediateResults ){
        LinkedList<Integer> result = intermediateResults.get(0);
        for(int i = 1; i<intermediateResults.size();i++){
            result = addTwoNumbers(result, intermediateResults.get(i));
        }
        return result;

    }
    public LinkedList<Integer> multiply(LinkedList<Integer> multiplicand, LinkedList<Integer> multiplier){
        Iterator<Integer> multiplierIter = multiplier.descendingIterator();
        List<LinkedList<Integer>> intermediateResults = new ArrayList<>();
        int multiplierItercnt = 0;
        while(multiplierIter.hasNext()){
            Integer num1 = multiplierIter.next();
            Iterator<Integer> multiplicandIter = multiplicand.descendingIterator();
            LinkedList<Integer> intermediateResult = new LinkedList<>();
            for(int i = 0;i< multiplierItercnt; i++){
                intermediateResult.add(0, 0);
            }
            Integer carryOver = 0;
            while(multiplicandIter.hasNext()){
                Integer num2 = multiplicandIter.next();
                Integer tempRes = num1 * num2 +carryOver;
                if(multiplicandIter.hasNext()){
                    carryOver = tempRes/10;
                    intermediateResult.add(0, tempRes%10);
                }else {
                    intermediateResult.add(0, tempRes%10);
                    if (tempRes/10>0) {
                        intermediateResult.add(0, tempRes/10);
                    }
                }
            }
            intermediateResults.add(intermediateResult);
            multiplierItercnt++;

        }
        return addIntermediateResults(intermediateResults);
    }
    public String multiply(String num1, String num2){
        LinkedList<Integer> num1List = new LinkedList<>();
        LinkedList<Integer> num2List = new LinkedList<>();
        Arrays.stream(num1.split("")).forEach(s -> num1List.add(Integer.parseInt(s)));
        Arrays.stream(num2.split("")).forEach(s -> num2List.add(Integer.parseInt(s)));
        /*LinkedList<Integer> multiplicand = null;
        LinkedList<Integer> multiplier = null;
        Integer biggest = findBiggest(num1List,num2List);
        if( biggest== 0 || biggest == -1){
            multiplicand =num2List;
            multiplier = num1List;
        } else {
            multiplicand =num1List;
            multiplier = num2List;
        }*/
        LinkedList<Integer> res = multiply(num1List, num2List);
        StringBuilder temp = new StringBuilder("");
        Boolean isZero = true;
        for(Integer s: res){
            if(!isZero || s >0){
                temp.append(s.toString());
                isZero = false;
            }
        }
        if(isZero) {
            temp.append("0");
        }
        return temp.toString();
    }
    public void run(String... args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Multiply 99, 99 = "+multiply("123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789","987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321"));
        long endTime = System.currentTimeMillis();
        System.out.println("multiplication took : "+ (endTime-startTime));

    }
}
