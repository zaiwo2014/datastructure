package com.leung.Recursion;

/**
 * @author 丨一
 * @version 1.0
 * @title RecursionXBinarySearch
 * @description: 递归二分法 返回所查找值在有序数组中的下标
 * @date 2024/8/20 下午9:10
 */
public class RecursionXBinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{10,20,333,421,553};
        System.out.println(search(arr, 553));
    }
    
    private static int search(int[] arr, int target){
        return solution(arr, target, 0, arr.length - 1);
    }
    
    private static int solution(int[] arr,int target,int low,int high) {
        if (low > high){
            return -1;
        }

        int m = (low + high) >>> 1;
        if (target < arr[m]){
            //target比中间值小,左侧递归
            return solution(arr, target, low, m - 1);
        }
        if (target > arr[m]){
            return solution(arr,target,m + 1,high);
        }
        return m;
    }
}
