package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.vijay.projecteuler.leetcode.MergeTwoLinkedLists.*;

@Component
public class ReverseKNodes implements CommandLineRunner {
    int count = 0;
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pointer = head;
        if (k<=1){
            return head;
        }
        if(head == null){
            return head;
        }
        while(pointer !=null){
            count ++;
            pointer = pointer.next;
        }
        if(count < k){
            return head;
        }
        List<ListNode> reversedNodes = splitAndReverseNodes(head, k);
        ListNode result = null;
        ListNode last = null;
        for(ListNode node: reversedNodes){
            if(result == null){
                result = node;
                last = node;
            } else {
                ListNode next = last.next;
                while(next.next !=null){
                    next = next.next;
                }
                next.next = node;
                last = node;
                // result = mergeTwoLists( node, result);
            }
        }
        return result;

    }
    public List<ListNode> splitAndReverseNodes(ListNode head, int k) {
        List<ListNode> splittedNodes = new ArrayList<>(count/k+1);
        ListNode next = head;
        ListNode first = null;
        ListNode last = null;
        while (next!=null){
            // first = next;
            for(int i = 0; i< k; i++){
                if(first == null){
                    first = next;
                }
                if(i == k-1){
                    last = next;
                }
                next = next != null ? next.next : null;
            }

           // next = next.next;
            if(last != null) {
                last.next = null;
                splittedNodes.add(reverseNodes(first, k));
            } else {
                splittedNodes.add(first);
            }
            // splittedNodes.add(first);
            first = null;
            last = null;
        }
        return splittedNodes;
    }
    ListNode reverseNodes(ListNode node, int k){
        ListNode last = node;
        List<ListNode> nodes = new ArrayList<>(k);
        while(last !=null){
            nodes.add(last);
            last = last.next;
        }
        ListNode result = new ListNode(-1);
        for(int i = k-1; i>=0; i--){
            if(result.next == null){
                result.next = nodes.get(i);
                last = result.next;
            } else {
                last.next = nodes.get(i);
                last = last.next;
            }
        }
        last.next = null;
        return result.next;
    }
    @Override
    public void run(String... args) throws Exception {
        int[] n1 = new int[]{1,2,3,4,5, 6, 7, 8, 9, 10};
        ListNode node1 = null;
        for(int i : n1){
            node1 = makeListNode(i, node1);
        }
        System.out.println("node 1 contents");
        printListNode(node1);
        ListNode result = reverseNodes(node1, 10);
        printListNode(result);
        ListNode result2 = reverseKGroup(result, 3);
        printListNode(result2);
        System.out.println("end reverse k nodes");


    }
}
