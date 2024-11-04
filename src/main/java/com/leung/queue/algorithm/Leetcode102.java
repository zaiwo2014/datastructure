package com.leung.queue.algorithm;


import com.leung.queue.impl.QueueByArrayList2;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 丨一
 * @version 1.0
 * @title Leetcode102
 * @description: 队列算法: 二叉树层序遍历(BFS广度优先)
 * @date 2024/11/4 14:16
 */
public class Leetcode102 {
    

    public static void main(String[] args) {

        TreeNode root = new TreeNode(
                1,
                new TreeNode(2,new TreeNode(4),new TreeNode(5)),
                new TreeNode(3,new TreeNode(6),new TreeNode(7))
        );

        QueueByArrayList2<TreeNode> integers = new QueueByArrayList2<TreeNode>(8);
        integers.offer(root);
        //基于循环的广度优先遍历
        while (!integers.isEmpty()) {
            TreeNode poll = integers.poll();
            if (poll.left != null) {
                integers.offer(poll.left);
            }
            if (poll.right != null) {
                integers.offer(poll.right);
            }
            System.out.println(poll.val);
        }
        
        
    }
    
    @Test
    public void test() {
        TreeNode root = new TreeNode(
                1,
                new TreeNode(2,new TreeNode(4),new TreeNode(5)),
                new TreeNode(3,new TreeNode(6),new TreeNode(7))
        );
        
        List<List<Integer>> list = new ArrayList<>();
        
        //基于每层节点个数的循环遍历
        QueueByArrayList2<TreeNode> queue = new QueueByArrayList2<>(10);
        queue.offer(root);
        int c1 = 1; //root层的节点个数
        while (!queue.isEmpty()) {
            int c2 = 0;
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < c1; i++) {
                TreeNode poll = queue.poll();
                levelNodes.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                    c2++;
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    c2++;
                    
                }
            }
            list.add(levelNodes);
            c1 = c2;
        }
        for (List<Integer> integers : list) {
            System.out.println(integers.toString());
        }
        
    }
    
    
    
    

    private static class TreeNode {
        public int val;
        
        public TreeNode left;
        
        public TreeNode right;


        public TreeNode(int val,TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
            this.val = val;
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
