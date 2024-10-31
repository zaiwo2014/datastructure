package com.leung.queue.impl;


import com.leung.queue.Queue;

import java.util.Iterator;

/**
 * @author 丨一
 * @version 1.0
 * @title QueueByArrayList
 * @description: 基于链表的环形数组(队列)
 * @date 2024/10/31 15:53
 */
public class QueueByArrayList<E> implements Iterable<E>, Queue<E> {

    private E[] array;
    private int head = 0;
    private int tail = 0;

    public QueueByArrayList(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public boolean offer(E element) {
        return false;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
