package com.leung.Recursion;

import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;

/**
 * @title YHTriangle
 * @author 丨一
 * @description: 递归经典问题:杨辉三角
 * @version 1.0
 * @date 2024/8/26 22:13
 */



public class YHTriangle {
    
    @Test
    public void test(){
        PrintYHTriangle(10);
    }

    /**
     * 打印某一项
     * @param i
     * @param j
     * @return 返回第 i 行 j 列的值
     */
    private static Integer solution(int i,int j) {
        if (j == 1 || j == i){
            return 1;
        }
        
        return solution(i - 1,j - 1) + solution(i - 1,j);
    }


    /**
     * 打印杨辉三角
     */
    private static void PrintYHTriangle(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%-4d",solution(i,j));
            }
            System.out.println();
        }
    }
}
