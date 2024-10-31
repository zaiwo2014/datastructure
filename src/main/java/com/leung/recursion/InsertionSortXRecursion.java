package com.leung.recursion;

/**
 * @author 丨一
 * @version 1.0
 * @title InsertionSortXRecursion
 * @description: 插入排序的递归实现
 * @date 2024/8/21 下午8:14
 */
public class InsertionSortXRecursion {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 7, 1};
        Solution(arr,5);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 
     * @param arr 待排序数组
     * @param low 未排序区域的上边界下标
     */
    private static void Solution(int[] arr,int low) {
        if (low == arr.length){
            return;
        }
        
        /* while循环方式
        int target = arr[low]; //插入值
        int index = low - 1;
        while (arr[index] > target){
            arr[index + 1] = arr[index]; 
            index--;
        }
        arr[index + 1] = target;
        */
        
        //反向冒泡找插入位置
        for (int i = low - 1; i >= 0; i--) {
            if (arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i + 1] = temp;
            }
        }
        
        Solution(arr,low+1);
    }
}
