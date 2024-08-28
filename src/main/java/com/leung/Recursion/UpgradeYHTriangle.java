package com.leung.Recursion;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author 丨一
 * @version 1.0
 * @title UpgradeYHTriangle
 * @description: 记忆法改进杨辉三角
 * @date 2024/8/26 下午11:15
 */
public class UpgradeYHTriangle {

    @Test
    public void test() {
        System.out.println(packSolution(3, 2));
    }

    @Test
    public void test2() {
        System.out.println(Arrays.toString(getCreatRowArr(4)));
    }

    public static Integer packSolution(int i, int j) {
        int[][] cache = new int[i+1][j+1];
        return solution(i,j,cache);
    }

    /**
     * 记忆法思路:记录每一次递归的数据(二位数组版本)
     * @param i
     * @param j
     * @return
     */
    private static Integer solution(int i,int j,int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        
        if (j == 1 || j == i){
            cache[i][j] = 1;
            return 1;
        }

        return cache[i][j] = solution(i - 1, j - 1, cache) + solution(i - 1, j, cache);
    }
    
    

    /**
     * 用数组记录前一行,利用前一行来推出下一行
     * @param row 用来记录前一行的数组
     * @param i 要求的行序号
     */
    private static void creatRow(int[] row,int i) {
        /**
            0   0   0   0   0   i = 0
            1   0   0   0   0   i = 1
            1   1   0   0   0   i = 2
            1   2   1   0   0   i = 3
            1   3   3   1   0   i = 4
         */
        if (i == 0) {
            row[0] = 1;
            return;
        }
        
        //j:所求行的列 
        for (int j = i; j > 0; j--) {
            row[j] = row[j] + row[j - 1];
        }
    }
    
    private static int[] getCreatRowArr(int n) {
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            creatRow(arr,i);
        }
        return arr;
    }
    
    
    
}
