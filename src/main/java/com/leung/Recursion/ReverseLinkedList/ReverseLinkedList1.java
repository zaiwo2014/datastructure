package com.leung.Recursion.ReverseLinkedList;

/**
 * @author 丨一
 * @version 1.0
 * @title ReverseLinkedList
 * @description: 反转单向链表方法 1:构造一个新链表,依次从旧链表拿到每个结点添加到新链表的头部
 * @date 2024/8/30 23:04
 */
public class ReverseLinkedList1 {
    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode tail = head;
        while (tail != null) {
            //标准的链表循环
            newHead = new ListNode(tail.value,newHead);
            tail = tail.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node = reverseList(node1);
        System.out.println(node1);
        System.out.println(node);
    }
}
