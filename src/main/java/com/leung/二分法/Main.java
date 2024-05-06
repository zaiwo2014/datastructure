package com.leung.二分法;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {15, 8, 2, 4, 8, 1, 25, 1};
        int[] ints = bubbleSort(arr);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 二分查找(leftmost版本)
     *
     * @param arr    有序数组
     * @param target 要查找的目标值
     * @return
     */
    public static int binarySearchBasic(int[] arr, int target) {
        //1.定义指针2
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int floor = (i + j) >>> 1;
            if (target <= arr[floor]) {
                j = floor - 1;  //右边界缩小
            } else if (target > arr[floor]) {
                i = floor + 1; //左边界缩小
            }
        }
        return i; //返回>= target最靠左的位置
    }

    /**
     * 冒泡排序法
     *
     * @param nums
     * @return
     */
    public static int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }
}