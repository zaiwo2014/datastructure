package com.leung.链表;

/**
 * @title:SinglyLinkedList
 * @Author:Leung
 * @Description:单向链表
 * @DATE:2024/5/7 05:00
 * @Version: 1.0
 */

public class SinglyLinkedList {
    //特点:存储不连续,通过指针进行数据的串联

    //1.头结点
    private Node head;

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

    /**
     * 新增节点,采用头插法
     * @param value 需要插入的值
     */
    public void addFirst(int value){
        //1.链表为空,将头结点指向第一个节点
//        if (head == null){
//            head = new Node(value, null);
//        }else {
//            //2.链表非空(头插法)
//            head = new Node(value, head);
//        }
        head = new Node(value, head); //头插法,优化版本
        //尾插法比较复杂,需要引入哨兵节点
    }

    /**
     * 遍历算法
     */
    public void loopList(){
        Node point = head;
        while (point != null){
            System.out.println(point.value);
            point = point.next;
        }
    }

}

