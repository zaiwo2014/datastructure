package com.leung.Recursion.ReverseLinkedList;

import org.junit.jupiter.api.Test;

/**
 * @author 丨一
 * @version 1.0
 * @title ReverseLinkedList2
 * @description: 反转链表方法 2:构造一个新链表,依次将旧链表头节点移动到新链表,结果就是倒序的
 * @date 2024/8/30 23:38
 */
public class ReverseLinkedList2 {


    public static ListNode ReverseList(ListNode head) {
        return null;
    }

    /**
     * 链表容器
     */
    private static class List {
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public void addFirst(ListNode node) {
            node.next = head;
            head = node;
        }

        public void removeFirst() {
            head = head.next;
        }
        
    } 

    @Test
    public void test() {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
    }
}
