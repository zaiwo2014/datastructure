package com.leung.dynamicArrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

/**
 * @title:TestArrays
 * @Author:Leung
 * @Description:动态数组
 * @DATE:2024/5/6 12:48
 * @Version: 1.0
 */

public class DynamicArray implements Iterable<Integer> {
    private int capacity = 8; //容量
    private int[] array = {};   //懒惰初始化
    private int size = 0; //逻辑大小

    //给数组添加元素
    public void addLast(int element) {
        insertLast(element, size);
    }

    /**
     * 在指定位置插入元素
     *
     * @param element
     */
    public void insertLast(int element, int index) {
        //容量检查
        checkAndGroup();
        //涉及数组内的元素copy
        synchronized (this) {
            if (size < index && index >= 0) {
                System.arraycopy(array, index, array, index + 1, size - index);
            }
            array[index] = element;
            size++;
        }
    }

    private void checkAndGroup() {
        if (size == 0) {
            array = new int[capacity];
        } else if (size == capacity) {
            //扩容:一般是1.5倍
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    public int getElement(int index) {
        return array[index];
    }

    /**
     * 数组迭代器的实现
     *
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;  //扫描下标

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }

    /**
     * 将数组以流的形式返回
     */
    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }

    /**
     * 删除指定下标的元素,并返回该元素的值
     */
    public int remove(int index) {
        int removed = array[index];
        synchronized (this) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            size--;
        }
        return removed;
    }


}
