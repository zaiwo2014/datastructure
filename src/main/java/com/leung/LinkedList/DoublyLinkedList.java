package com.leung.LinkedList;

import java.util.Iterator;

/**
 * @title:DoublyLinkedList
 * @Author:Leung
 * @Description:双向链表(带哨兵)
 * @DATE:2024/5/8 18:12
 * @Version: 1.0
 */

public class DoublyLinkedList implements Iterable<Integer> {

    private Node head; //头哨兵
    private Node tail; //尾哨兵

    /**
     * 节点类
     */
    private static class Node {
        private Node prev;
        private int value;
        private Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 构造方法
     */
    public DoublyLinkedList() {
        head = new Node(null, 111, null);
        tail = new Node(null, 222, null);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 根据指定下标找到当前节点
     */
    private Node findNode(int index) {
        int flag = -1; //头哨兵
        for (Node p = head; p != tail; p = p.next, flag++) {
            if (flag == index) {
                return p;
            }
        }
        return null;
    }

    /**
     * 指定索引位置插入值
     */
    public void insert(int index, int value) {
        Node preNode = findNode(index - 1);
        if (preNode == null) {
            throw new IllegalArgumentException("下标不合法");
        }
        Node nextNode = preNode.next;
        Node insertedNode = new Node(preNode, value, nextNode);
        preNode.next = insertedNode;
        nextNode.prev = insertedNode;
    }

    /**
     * 头插法
     */
    public void addFirst(int value) {
        if (head.next == tail) {
            insert(0, value);
        } else {
            Node nextNode = head.next;
            Node thisNode = new Node(head, value, nextNode);
            head.next = thisNode;
            nextNode.prev = thisNode;
        }
    }


    /**
     * 尾插法
     */
    public void addLast(int value) {
        if (head.next == tail) { //链表为空的情况
            insert(0, value);
        }else {
            Node prevNode = tail.prev;
            Node thisNode = new Node(prevNode, value, tail);
            prevNode.next = thisNode;
            tail.prev = thisNode;
        }
    }


    /**
     * 移除指定索引的值
     */
    public void remove(int index) {
        Node removedNode = findNode(index);
        if (removedNode == null) {
            throw new IllegalArgumentException("不合法下标");
        } else {
            Node prevNode = removedNode.prev;
            Node nextNode = removedNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
    }

    /**
     * 迭代器的实现
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }


}
