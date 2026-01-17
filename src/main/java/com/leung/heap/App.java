package com.leung.heap;

public class App {

    public static void main(String[] args) {
        AbsoluteBinaryTree absoluteBinaryTree = new AbsoluteBinaryTree(10);

        absoluteBinaryTree.add(10);
        absoluteBinaryTree.add(1);
        absoluteBinaryTree.add(5);

        for (int i : absoluteBinaryTree.getHeapTree()) {
            System.out.println(i);
        }
    }
}
