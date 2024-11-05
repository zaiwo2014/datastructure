package com.leung.stack.impl;


import com.leung.stack.Stack;

import java.util.Iterator;

/**
 * @author 丨一
 * @version 1.0
 * @title StackByArray
 * @description:
 * @date 2024/11/4 20:53
 */
public class StackByArray<E> implements Stack<E>, Iterable<E> {

    private int size = 0;

    private E[] array;


    public StackByArray(int capacity) {
        this.array = ((E[]) new Object[capacity]);
    }

    @Override
    public boolean push(E element) {
        if (isfull()) {
            throw new IndexOutOfBoundsException("栈满");
        } else {
            array[size] = element;
            size++;
            return true;
        }
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return null;
        } else {
            return array[--size];
        }
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return null;
        } else {
            int point = size - 1;
            return array[point];
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isfull() {
        return size == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int thisSize = size;

            @Override
            public boolean hasNext() {
                return thisSize > 0;
            }

            @Override
            public E next() {
                return array[--thisSize];
            }
        };
    }
}
