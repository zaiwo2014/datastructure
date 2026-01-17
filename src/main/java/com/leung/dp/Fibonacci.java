package com.leung.dp;


/**
 * @author 丨一
 * @version 1.0
 * @title Fibonacci
 * @description: 0 1 1 2 3 5 8 13 ...
 * @date 2024/12/5 下午10:02
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(method1(15));
        System.out.println(method2(15));
        System.out.println(method3(15));
    }

    /**
     * 斐波那契的递归实现
     * @param index
     * @return
     */
    public static int method1(int index) {

        if (index < 0) {
            return -1;
        }
        
        if (index == 0) {
            return 0;
        }

        if (index == 1) {
            return 1;
        }
        
        return method1(index -1) + method1(index -2);
    }

    /**
     * 斐波那契数列的动规实现
     * @param index
     * @return
     */
    public static int method2(int index) {
        if (index < 0) {
            return -1;
        }
        if (index == 0) {
            return 0;
        }

        if (index == 1) {
            return 1;
        }
        int[] dp = new int[index + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= index; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[index];
    }

    /**
     * 斐波那契数列的迭代法实现
     * @param index
     * @return
     */
    public static int method3(int index) {
        if (index < 0) {
            return -1;
        }

        if (index == 0) {
            return 0;
        }

        if (index == 1) {
            return 1;
        }
        int a = 0,b = 1,c = 0;
        for (int i = 2; i <= index; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
