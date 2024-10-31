package com.leung.linkedList;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @title:SinglyLinkedList
 * @Author:Leung
 * @Description:单向链表
 * @DATE:2024/5/7 05:00
 * @Version: 1.0
 */

public class SinglyLinkedList implements Iterable<Integer> {
    //特点:存储不连续,通过指针进行数据的串联

    //1.头结点
    private Node head;

    /**
     * 新增节点,采用头插法
     *
     * @param value 需要插入的值
     */
    public void addFirst(int value) {
        //1.链表为空,将头结点指向第一个节点
//        if (head == null){
//            head = new Node(value, null);
//        }else {
//            //2.链表非空(头插法)
//            head = new Node(value, head);
//        }
        head = new Node(value, head); //头插法,优化版本
    }

    /**
     * 尾插法
     */
    public void addLast(int value) {
        //找到尾部指针
        if (head == null) {
            addFirst(value);
        } else {
            Node last = findLast();
            last.next = new Node(value, null);
        }
    }

    private Node findLast() {
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    /**
     * 遍历算法
     */
    public void loopList(Consumer<Integer> consumer) {
        Node point = head;
        while (point != null) {
            consumer.accept(point.value);
            point = point.next;
        }
    }

    /**
     * 实现迭代器
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head;

            /**
             * 存在后续节点时,返回true,否则返回false
             */
            @Override
            public boolean hasNext() {
                return p != null;
            }

            /**
             * 返回节点的值,并指向下一个节点
             */
            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    /**
     * 获取指定下标的元素
     */
    public int getByIndex(int index) {
        Node node = fineIndex(index);
        if (node == null) {
            throw new IllegalArgumentException(
                    String.format("index [%d] 不合法%n", index));
        }
        return node.value;
    }

    /**
     * 获取指定下标的节点
     */
    private Node fineIndex(int index) {
        int flag = 0;
        for (Node p = head; p != null; p = p.next, flag++) {
            if (flag == index) {
                return p;
            }
        }
        return null;
    }

    /**
     * 指定位置插入元素,原索引位置的元素往后移一个位置
     */
    public void insertByIndex(int value, int index) {
        //索引位置为0(直接采用头插法)
        if (index == 0) {
            addFirst(value);
        } else {
            //插入点在中间,执行打断逻辑
            Node preNode = fineIndex(index - 1);
            if (preNode != null) {
                preNode.next = new Node(value, preNode.next);
            } else throw new IllegalArgumentException(
                    String.format("index [%d] 不合法%n", index));
        }
    }

    /**
     * 删除头节点
     */
    public void removeFirst() {
        if (head != null) {
            head = head.next;
        } else {
            throw new IllegalArgumentException("链表为空");
        }
    }

    /**
     * 按索引删除
     */
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
        } else {
            Node preNode = fineIndex(index - 1);
            if (preNode == null) {
                throw new IllegalArgumentException("不合法的索引");
            } else {
                Node removeNode = preNode.next;
                if (removeNode == null) {
                    throw new IllegalArgumentException("不合法的索引");
                } else {
                    preNode.next = removeNode.next;
                }
            }
        }
    }

    /**
     * 节点类
     */
    private static class Node {
        private int value; //值
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}

