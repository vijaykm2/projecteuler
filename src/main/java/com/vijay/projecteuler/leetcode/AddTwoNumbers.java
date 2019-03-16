package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    void setNext(ListNode next) {
        this.next = next;
    }
}

@Component
public class AddTwoNumbers implements CommandLineRunner {
    private ListNode createListNode(int... values) {
        ListNode node = null;
        ListNode childNode = null;
        for(int i = values.length-1; i>=0;i--){
            node = new ListNode(values[i]);
            node.next=childNode;
            childNode = node;
        }
        return node;

    }
    private String getValFromNode( ListNode node){
        String result = "";
        if (node.next != null){
            result = getValFromNode(node.next)+node.val +result;
        } else {
            result = node.val +result;
        }

        return result;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        BigInteger val1 = new BigInteger(getValFromNode(l1));
        BigInteger val2 = new BigInteger(getValFromNode(l2));
        BigInteger sum = val1.add(val2);
        String resultStr = new StringBuilder(sum.toString()).reverse().toString();
        String[] resultarr = resultStr.split("");
        int[] resultint = new int[resultarr.length];
        for(int i = 0; i<resultarr.length;i++){

            resultint[i] = Integer.parseInt(resultarr[i]);

        }

        return  createListNode(resultint);
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int carryOver = 0;
        List<Integer> result = new ArrayList<>();
        ListNode currentL1 = l1;
        ListNode currentL2 = l2;
        while (currentL1 != null ||currentL2 != null){
            int val1 = currentL1 !=null ?currentL1.val : 0;
            int val2 = currentL2 !=null ?currentL2.val : 0;
            int temp = val1 +val2 + carryOver;
            //String tempStr = temp.toString();
            if(temp >=10){
                carryOver = 1;
                result.add(temp - 10);
            } else {
                carryOver = 0;
                result.add(temp);
            }/*
            if(carryOver == 1 &&currentL1!=null && currentL1.next == null && currentL2 !=null && currentL2.next ==null) {
                result.add(carryOver);
            }*/

            if(currentL1!= null){
                currentL1 = currentL1.next;
            }if(currentL2!= null){
                currentL2 = currentL2.next;
            }
        }
        if(carryOver ==1) {
            result.add(carryOver);
        }
        int[] sds = new int[result.size()];
        int j = 0;
        for(int i: result){
            sds[j] = i;
            j++;
        }
        return createListNode(sds);
    }
    @Override
    public void run(String... args) throws Exception {

        ListNode l1 =  createListNode(1);
        ListNode l2 = createListNode(9, 9);
        addTwoNumbers2(l1, l2);
    }
}
