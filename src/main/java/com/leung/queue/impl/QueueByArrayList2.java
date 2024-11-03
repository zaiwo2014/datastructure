package com.leung.queue.impl;


import com.leung.queue.Queue;

import java.util.Iterator;

/**
 * @author 丨一
 * @version 1.0
 * @title QueueByArrayList2
 * @description: 容量标记法 维护一个了逻辑容量
 * @date 2024/11/3 17:16
 */
public class QueueByArrayList2<E> implements Queue<E>,Iterable<E> {
    
    private final E[] array;
    
    //从 0 到 (size - 1) 个
    private int size = 0;
    
    private int head = 0;
    
    private int tail = 0;

    public QueueByArrayList2(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public boolean offer(E element) {
        if (isfull()) {
            System.out.println("队列已满");
            return false;
        } else {
            array[tail] = element;
            tail = (tail + 1) % array.length;
            size++;
            return true;
        } 
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return null;
        } else {
            E element = array[head];
            head = (head + 1) % array.length;
            size--;
            return element;
        } 
        
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return null;
        }else {
            return array[head];
        }
            
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isfull() {
        return size == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int point = head;
            int count = 0;
            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                E element = array[point];
                point = (point + 1) % array.length;
                count++;
                return element;
            }
        };
    }
}
