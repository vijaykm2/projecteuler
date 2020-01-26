package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class MergeTwoLinkedLists implements CommandLineRunner {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;

    }
    public static ListNode makeListNode(int val, ListNode ln){
        ListNode result = ln;
        if(result == null){
            result = new ListNode(val);
        } else {
            ListNode lastNode = result;
            while(lastNode.next !=null){
                lastNode = lastNode.next;
            }
            ListNode last = new ListNode(val);
            lastNode.next = last;
        }
        return result;
    }
    public static void printListNode(ListNode node){
        while (node!=null){
            System.out.print(node.val+", ");
            node = node.next;
        }
        System.out.println();
    }

    @java.lang.Override
    public void run(java.lang.String... args) throws Exception {
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
        ListNode result = mergeTwoLists(node1, node2);

        System.out.println("result contents: ");
        printListNode(result);
    }
}
