package com.leung.二分法;

import java.util.Arrays;

/**
 * @title:TestBinarySearch
 * @Author:Leung
 * @Description:
 * @DATE:2024/5/6 06:43
 * @Version: 1.0
 */

public class TestBinarySearch {
    public static void main(String[] args) {
        int[] a = {2, 5, 8};
        int key = 4;
        int i = Arrays.binarySearch(a, key); //返回值为切入点
        /**
         * 需求:如果数组中没有要查找的key,将这个key插入到他的插入点,并返回这个新数组
         */
        if (i < 0) {
            int insertIndex = Math.abs(i + 1);
            int[] b = new int[a.length + 1];
            System.arraycopy(a, 0, b, 0, insertIndex);
            b[insertIndex] = key;
            System.arraycopy(a, insertIndex, b, insertIndex + 1, a.length - insertIndex);
            System.out.println(Arrays.toString(b));
        }

    }
}
