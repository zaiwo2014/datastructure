package com.leung.linkedList;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @title:DoublyLinkedCircularList
 * @Author:Leung
 * @Description:环形双向链表(带哨兵)
 * @DATE:2024/5/8/22:56
 * @Version:1.0
 */

public class DoublyLinkedCircularList implements Iterable<Integer> {
    private Node sentinel = new Node(null, -1, null); //哨兵节点对象

    /**
     * 构造方法
     */
    public DoublyLinkedCircularList() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /**
     * 根据下标返回对应节点
     */
    private Node findNode(int index) {
        int flag = -1;
        for (Node p = sentinel; p.next != sentinel; p = p.next, flag++) {
            if (flag == index) {
                return p;
            }
        }
        return sentinel;
    }

    /**
     * 实现迭代器
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    /**
     * 头插法
     */
    public void addFirst(int value) {
        insert(value, 0);
    }

    /**
     * 尾插法
     */
    public void addLast(int value) {
        Node lastNode = sentinel.prev;
        Node thisNode = new Node(lastNode, value, sentinel);
        lastNode.next = thisNode;
        sentinel.prev = thisNode;
    }

    /**
     * 指定下标插入当前值
     */
    public void insert(int value, int index) {
        Node preNode = findNode(index - 1);
        Node nextNode = preNode.next;
        Node thisNode = new Node(preNode, value, nextNode);
        nextNode.prev = thisNode;
        preNode.next = thisNode;
    }

    /**
     * 根据下标移除对应节点
     */
    public void remove(int index) {
        Node thisNode = findNode(index);
        if (thisNode == sentinel) {
            throw new IllegalArgumentException("下标不合法");
        }
        Node preNode = thisNode.prev;
        Node nextNode = thisNode.next;
        preNode.next = nextNode;
        nextNode.prev = preNode;
    }


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
     * 将链表以流的形式返回(有序)
     */
    public Stream<Integer> getStream() {
        return StreamSupport.stream(spliterator(), false);
    }

    /**
     * 删除头节点
     */
    public void removeFist() {
        Node removedNode = sentinel.next;
        if (removedNode == sentinel){
            throw new IllegalArgumentException("不合法下标");
        }
        Node nextNode = removedNode.next;
        nextNode.prev = sentinel;
        sentinel.next = nextNode;
    }

    /**
     * 删除尾节点
     */
    public void removeLast() {
        Node removedNode = sentinel.prev;
        if (removedNode == sentinel) {
            throw new IllegalArgumentException("不合法下标");
        }
        Node prevNode = removedNode.prev;
        prevNode.next = sentinel;
        sentinel.prev = prevNode;
    }

    /**
     * 根据值删除
     */
    public void removeByValue(int value) {
        Node thisNode = findNodeByValue(value);
        if (thisNode != null) {
            Node prevNode = thisNode.prev;
            Node nextNode = thisNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
    }

    /**
     * 根据值查找节点
     */
    private Node findNodeByValue(int value) {
        Node p = sentinel.next;
        while (p != sentinel) {
            if (p.value == value) {
                return p;
            }else {
                p = p.next;
            }
        }
        return null;
    }


    //递归遍历
    private void recursion(Node point,Consumer<Integer> consumer) {
        if (point != sentinel) {
            int value = point.value;
            consumer.accept(value);
            recursion(point.next, consumer);
        }
    }

    public void loopWithRecursion() {
        recursion(sentinel.next, System.out::println);
    }

}
