package com.leung.recursion.ReverseLinkedList;

/**
 * @author 丨一
 * @version 1.0
 * @title ListNode
 * @description:
 * @date 2024/8/30 23:00
 */

/**
 * 链表类
 */
public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
