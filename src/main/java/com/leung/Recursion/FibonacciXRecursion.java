package com.leung.Recursion;

import org.junit.jupiter.api.Test;


/**
 * @author 丨一
 * @version 1.0
 * @title FibonacciXRecursion
 * @description: 多路递归经典概念:斐波那契数列 多路递归的本质:树. 斐波那契的变体问题:兔子问题、青蛙跳台阶
 * @date 2024/8/22 下午8:37
 */
public class FibonacciXRecursion {
    
    @Test
    public void test() {
        System.out.println(Solution(12).toString());
    }
    
    
    
    private static Integer Solution(int index){
        if (index == 0 || index == 1){
            return index;
        }
        return Solution(index - 1) + Solution(index - 2);
        
    }
}
