package com.leung.DynamicArrays;

import java.util.Iterator;

public class DynamicArrayAgain implements Iterable<Integer>{
    
    public int size = 0;//数组中的逻辑大小 决定了添加元素的索引以及所含元素的个数
    
    private int capacity = 8;   //数组的初始化长度
    
    private int[] array = {};   //数组的懒惰初始化


    //添加元素 (要考虑容量问题)
    public void add(int element) {
        //容量判断
        CheckAndGrow();
        
        array[size] = element;
        size++;
    }

    public int remove(int index) {
        if (index > size) {
            throw new RuntimeException("out of Index");
        }
        int removedElement = array[index];
        System.arraycopy(array, index, array, index + 1, size - index - 1);
        size--;
        return removedElement;
    }
    
    /*
    任意点插入 
     */
    public void add(int index, int element) {
        if (index == size) {
            add(element);
        }
        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = element;
            size++;
        } else {
            throw new RuntimeException("index不合法");
        } 
        
    }

    public int getElement(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("越界");
        }
        return array[index];
    }

    


    /*
    迭代器的实现(匿名内部类)
     */
    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> integerIterator = new Iterator<>() {
            //迭代器内部维护一个index
            int index = 0;
            
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Integer next() {
                return array[index++];  //获取当前元素并让index自增
            }
        };
        
        return integerIterator;
    }
    
    /*
    动态数组的扩容
     */
    private void CheckAndGrow() {
        if (size == 0) {
            array = new int[capacity];
        } else {
            if (size == capacity) {
                capacity += capacity >> 1;
                int[] newArray = new int[capacity];
                System.arraycopy(array,0,newArray,0,size);
                array = newArray;
            }
        } 
    }
    
    
}