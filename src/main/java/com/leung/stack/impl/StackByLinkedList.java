package com.leung.stack.impl;


import com.leung.stack.Stack;

import java.util.Iterator;

/**
 * @author 丨一
 * @version 1.0
 * @title StackByLinkedList
 * @description: 基于单向链表实现的栈 -> 每次都往head的下个节点添加元素,就能实现后进先出
 * @date 2024/11/4 18:17
 */
public class StackByLinkedList<E> implements Stack<E>, Iterable<E> {

    private final Node<E> head = new Node<>(null, null);
    private int capacity;
    private int size;

    public StackByLinkedList(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean push(E element) {
        if (isfull()) {
            throw new IndexOutOfBoundsException("栈已满");
        }
        /**
         * 头插法
         * 如果你有一个链表 Head -> A -> B，并且想要在 Head 后插入一个新节点 C，执行上述代码后，链表会变成 Head -> C -> A -> B
         */
        head.nextNode = new Node<>(element, head.nextNode);
        size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return null;
        }
        Node<E> returnNode = head.nextNode;
        head.nextNode = head.nextNode.nextNode;
        size--;
        return returnNode.element;
    }

    @Override
    public E peek() {
        return (E) head.nextNode.element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isfull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> thisHead = head;

            @Override
            public boolean hasNext() {
                return thisHead.nextNode != null;
            }

            @Override
            public E next() {
                E element = (E) thisHead.nextNode.element;
                thisHead.nextNode = thisHead.nextNode.nextNode;
                return element;
            }
        };
    }

    private static class Node<E> {
        public E element;
        public Node nextNode;

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node nextNode) {
            this.element = element;
            this.nextNode = nextNode;
        }
    }
}
