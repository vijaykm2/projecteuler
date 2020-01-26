package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;

class Node {
    int val;

    Node next;
    Node random;

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}

@Component
public class CopyListWithRandomPointer implements CommandLineRunner {
   HashMap<Node, Node> visitedHash = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        if(visitedHash.containsKey(head)){
            return visitedHash.get(head);
        }
        Node node = new Node(head.val, null, null);
        visitedHash.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;

    }
    @Override
    public void run(String... args) throws Exception {

    }
}
