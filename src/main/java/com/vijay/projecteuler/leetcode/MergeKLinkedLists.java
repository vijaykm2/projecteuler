package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.vijay.projecteuler.leetcode.MergeTwoLinkedLists.*;

@Component
public class MergeKLinkedLists implements CommandLineRunner {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        ListNode result = lists[0];
        if(lists.length ==1){
            return result;
        }
        for(int i = 1; i< lists.length; i++){
            result = mergeTwoLists(result, lists[i]);
        }
        return result;

    }

    @Override
    public void run(String... args) throws Exception {
        int[] n1 = new int[]{1,2,4};
        ListNode node1 = null;
        for(int i : n1){
            node1 = makeListNode(i, node1);
        }
        System.out.println("node 1 contents");
        printListNode(node1);
        int[] n2= new int[]{1,3,4, 5};
        ListNode node2 = null;
        for(int i : n2){
            node2 = makeListNode(i, node2);
        }
        System.out.println("node 2 contents: ");
        printListNode(node2);
        int[] n3= new int[]{3,4, 7};
        ListNode node3 = null;
        for(int i : n3){
            node3 = makeListNode(i, node3);
        }
        System.out.println("node 3 contents: ");
        printListNode(node3);
        ListNode[] nodes = new ListNode[]{node1, node3, node2};
        ListNode result = mergeKLists(nodes);
        System.out.println("merge k lists = ");
        printListNode(result);


    }
}
