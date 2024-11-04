package com.leung.queue.impl;


import com.leung.queue.Queue;

import java.util.Iterator;

/**
 * @author 丨一
 * @version 1.0
 * @title QueueByArray3
 * @description: 实现方法 3: 指针本身不再作为索引. 作为计算插入位置时的计算变量
 * @date 2024/11/4 09:46
 */
public class QueueByArrayList3<E> implements Queue<E>,Iterable<E> {
    
    
    private E[] array;
    
    private int head = 0;
    
    private int tail = 0;

    public QueueByArrayList3(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public boolean offer(E element) {
        if (isfull()) {
            System.out.println("队列已满");
            return false;
        } else {
            array[tail % array.length] = element;
            tail++;
            return true;
        }
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return null;
        } else {
            E element = array[head % array.length];
            head++;
            return element;
        } 
    }

    @Override
    public E peek() {
        return array[head % array.length];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isfull() {
        return tail - head == array.length; //尾 - 头 = 数组长度 此时队满
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int point = head;
            
            @Override
            public boolean hasNext() {
                return point != tail;
            }

            @Override
            public E next() {
                E element = array[point % array.length];
                point++;
                return element;
            }
        };
    }
}
