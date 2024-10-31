package com.leung.recursion;

/**
 * @author 丨一
 * @version 1.0
 * @title BubbleSortXRecursion
 * @description: 冒泡排序法的递归实现
 * @date 2024/8/20 下午10:27
 */
public class BubbleSortXRecursion {
    public static void main(String[] args) {
        int[] arr = new int[]{12,58,852,48,952,68,722,412};
        Solution2(arr,arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
    
    

    /**
     * 
     * @param arr
     * @param lastIndex 待排序区域的尾下标
     */
    private static void Solution(int[] arr,int lastIndex) {
        if (lastIndex < 0){
            return;
        }
        for (int i = 0; i < lastIndex - 1; i++){
            if (arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        
        lastIndex--;
        Solution(arr,lastIndex);
    }

    /**
     * 
     * @param arr
     * @param lastIndex 带排序区域边界的冒泡递归
     */
    private static void Solution2(int[] arr,int lastIndex) {
        if (lastIndex == 0){
            return;
        }
        int flag = 0;
        for (int i = 0; i < lastIndex; i++){
            if (arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                flag = i;
            }
        }
        
        Solution2(arr,flag);
    }
}
