package com.vijay.projecteuler.leetcode;

import com.sun.source.tree.Tree;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class BinaryTree {
    TreeNode root;

    private TreeNode addRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }
        if (value < current.val) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.val) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public void add(int[] values) {
        for (int value : values) {
            add(value);
        }
    }
}

@Component
public class BinaryTreeZigZagLeverlOrderTraversal implements CommandLineRunner {
    public List<List<Integer>> zigzagLevelOrder(Queue<TreeNode> nodes, int level) {
        Queue<TreeNode> nextLevel = null;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove();
            if (node.left != null || node.right != null) {
                if (nextLevel == null) {
                    nextLevel = new LinkedList<>();
                }

                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }
            if(node != null) values.add(node.val);
        }
        if(level % 2 !=0){
            Collections.reverse(values);
        }
        result.add(values);

        if(nextLevel != null && nextLevel.size() >0 ){
            result.addAll(zigzagLevelOrder(nextLevel, level+1));
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
       return this.zigzagLevelOrder(queue, 0);
    }

    @Override
    public void run(String... args) throws Exception {

        BinaryTree tree = new BinaryTree();
        tree.add(new int[]{1, 4, -1, -3, 2});
        TreeNode node = tree.root;
        List<List<Integer>> values = zigzagLevelOrder(node);
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        List<List<Integer>> val2 = zigzagLevelOrder(root);

    }
}
