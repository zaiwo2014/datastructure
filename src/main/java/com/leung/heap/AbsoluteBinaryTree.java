package com.leung.heap;

/**
 * Java 实现完全二叉树
 * 完全二叉树的概念 :
 *      1. 除最后一层外，其他各层都被完全填满
 *      2. 最后一层的结点都连续集中在左边
 *      3. 如果一个结点缺少右子结点，则其必定也缺少左子结点
 *
 * 完全二叉树与堆:
 *      1. 小顶堆 : 子节点的值必须大于等于父节点的值
 *      2. 大顶堆 : 子节点的值必须小于等于父节点的值
 *
 * java 中的实现:
 *      建议用数组, 如果用传统链式结构需要维护额外的 node
 */


public class AbsoluteBinaryTree {

    private int[] heapTree;

    private int size;

    public AbsoluteBinaryTree(int size) {
        heapTree = new int[size];
    }

    /**
     * 插入元素
     */
    public void add(int value) {
        if (size + 1 > this.heapTree.length) {
            throw new RuntimeException("Heap overflow");
        }

        heapTree[size] = value;


        //小顶堆特性的实现
        heapIfyUp(size);
        size++;
    }


    private void heapIfyUp(int index) {
        if (index == 0) {
            return;
        }

        int parentIndex = (index - 1) / 2;

        if (heapTree[parentIndex] > heapTree[index]) {
            int temp = heapTree[parentIndex];
            heapTree[parentIndex] = heapTree[index];
            heapTree[index] = temp;
        }

        heapIfyUp(parentIndex);

    }

    public int[] getHeapTree() {
        return this.heapTree;
    }

    public int getSize() {
        return this.size - 1;
    }
}
