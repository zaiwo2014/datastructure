package com.leung.queue.impl;


import com.leung.queue.Queue;

import java.util.Iterator;

/**
 * @author 丨一
 * @version 1.0
 * @title QueueByLinkedList
 * @description: 基于链表实现队列
 * @date 2024/10/31 14:36
 */
public class QueueByLinkedList<E> implements Queue<E>,Iterable<E> {
    
    private final Node<E> head = new Node<>(null,null);
    private Node<E> tail;

    public QueueByLinkedList() {
        tail = head;
    }

    @Override
    public boolean offer(E element) {
        Node<E> newNode = new Node<>(element);
        if (tail == head) {
            head.nextNode = newNode;
        }
        tail.nextNode = newNode;
        tail = newNode;
        newNode.nextNode = head;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        Node<E> pollNode = head.nextNode;
        head.nextNode = pollNode.nextNode;
        return pollNode.element;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return tail == head;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>(){
            Node<E> thisNode = head.nextNode;

            @Override
            public boolean hasNext() {
                return thisNode != head;
            }

            @Override
            public E next() {
                E element = thisNode.element;
                thisNode = thisNode.nextNode;
                return element;
            }
        };
    }


    private  static class Node<E> {
        E element;
        Node<E> nextNode;

        public Node() {
        }

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node<E> nextNode) {
            this.element = element;
            this.nextNode = nextNode;
        }
    }
}
