package com.example.leetcode;

import java.util.*;

/**
 * @Tagged: Medium
 * @Date: 2 Nov 2023
 * <p>
 * Problem Statement
 * <p>
 * Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.
 * <p>
 * Note:
 * <p>
 * The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
 * A subtree of root is a tree consisting of root and all of its descendants.
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class CountNodesEqualToAverageOfSubtree {

    public static void main(String[] args) {
        CountNodesEqualToAverageOfSubtree obj = new CountNodesEqualToAverageOfSubtree();
        TreeNode root = new TreeNode(4, new TreeNode(8, new TreeNode(0), new TreeNode(1)), new TreeNode(5, null, new TreeNode(6)));
        System.out.println(obj.averageOfSubtreeModified(root));
    }

    /**
     * Time O(n + n)
     * Space: O(Nodes in the tree)
     *
     * @param root
     * @return
     */
    public int averageOfSubtree(TreeNode root) {
        Map<Integer, List<Integer>> nodes = new HashMap<>();
        populate(root, nodes);

        return nodes.keySet().stream().map( key -> {

            Stack<Integer> stack = new Stack<>();
            stack.push(key);
            int sum = 0;
            int counter=0;

            while(!stack.isEmpty()) {
                Integer val = stack.pop();
                sum += val;
                counter++;
                nodes.get(val).forEach(stack::push);
            }

            int avg = sum / counter;
            if(avg == key) return 1;
            return 0;

        }).reduce(0, (a, b) -> a + b);
    }

    private void populate(TreeNode root, Map<Integer, List<Integer>> nodes) {
        if(root == null) return;
        List<Integer> children = nodes.getOrDefault(root.val, new ArrayList<>());

        if(root.left != null )  children.add(root.left.val);

        if(root.right != null ) children.add(root.right.val);

        nodes.put(root.val, children);

        populate(root.left, nodes);
        populate(root.right, nodes);
    }

    int counter = 0;
    int sum = 0;
    public int averageOfSubtreeModified(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int nodeCount = 0;

        while(!stack.isEmpty()) {
            TreeNode val = stack.pop();

            counter = 1;
            sum = val.val;

            iterate(val.left);
            iterate(val.right);

            int avg = sum / counter;

            if(avg == val.val) nodeCount++;


            if(val.left != null ) stack.push(val.left);
            if(val.right != null ) stack.push(val.right);
        }
        return nodeCount;
    }

    public void iterate(TreeNode node) {
        if(node == null ) return;

        iterate(node.left);
        counter++;
        sum += node.val;
        iterate(node.right);
    }
}
