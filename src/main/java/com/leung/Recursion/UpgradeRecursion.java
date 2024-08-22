package com.leung.Recursion;

import org.junit.jupiter.api.Test;

import java.util.Arrays;



/**
 * @author 丨一
 * @version 1.0
 * @title UpgradeRecursion
 * @description: 多路递归的优化 思路:剪枝 (记忆法) 时间复杂度 O(n) 记忆法:很重要
 * @date 2024/8/22 下午9:13
 */
public class UpgradeRecursion {

    @Test
    public void test() {
        System.out.println(fibonacci(12));
    }
    
    
    /**
     * 创建一个记录数组,用于记录递归的解
     * @return 第n项的值
     */
    private static int fibonacci(int n){
        int[] cache = new int[n + 1]; //n+1:
        Arrays.fill(cache,-1);
        cache[0] = 0;
        cache[1] = 1;
        return solution(n,cache);
    }

    /**
     * 递归体
     * @param n 求解的项
     * @param cache 记忆体
     * @return 目标值
     */
    private static int solution(int n, int[] cache) {
        if (cache[n] != -1) {
            return cache[n];
        }

        int x = solution(n - 1, cache);
        int y = solution(n - 2, cache);
        cache[n] = x + y;
        return cache[n];
    }
}
