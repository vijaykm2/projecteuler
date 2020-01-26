package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import static com.vijay.projecteuler.leetcode.MergeTwoLinkedLists.*;


@Component
public class SwapPairs implements CommandLineRunner {
    public ListNode swapPair(ListNode listNode){
        if(listNode.next == null ){
            return listNode;
        }
        ListNode temp = new ListNode(-1);
        temp.next = listNode.next;
        listNode.next = null;
        temp.next.next = listNode;
        return temp.next;

    }
    public ListNode swapPairs(ListNode head) {
        ListNode currentNode = head;
        List<ListNode> swappedPairs = new ArrayList<>();
        while (currentNode!=null){
            if(currentNode.next!=null){
                ListNode nextNode = currentNode.next;
                ListNode nextCurNode = nextNode.next;
                swappedPairs.add(swapPair(currentNode));
                currentNode = nextCurNode;
            } else {
                swappedPairs.add(currentNode);
                currentNode = currentNode.next;
            }
        }
        ListNode result = new ListNode(-1);
        ListNode lastNode = null;
        for (ListNode n: swappedPairs
             ) {
            if(result.next == null){
                result.next = n;
                lastNode = result.next.next;
            } else {
                lastNode.next = n;
                lastNode = lastNode.next.next;
            }
        }
        return result.next;
    }
    @Override
    public void run(String... args) throws Exception {
        int[] n1 = new int[]{1,2,3,4,5};
        ListNode node1 = null;
        for(int i : n1){
            node1 = makeListNode(i, node1);
        }
        System.out.println("node 1 contents");
        printListNode(node1);
        ListNode result = swapPairs(node1);

        printListNode(result);

    }
}
