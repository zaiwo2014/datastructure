package com.leung.dp;


import java.math.BigInteger;

/**
 * @author 丨一
 * @version 1.0
 * @title ClimbingStairs
 * @description: 爬楼梯问题 构造递推核心思路 : 最后总是剩下 1 阶或者 2阶
 * @date 2024/12/5 下午11:48
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(method2(10));
    }

    /**
     * 递归法 -> 数值较大时,会造成递归深度太深导致效率及其低下 甚至导致死递归(这里的时间复杂度为 O(2^n))
     */
    public static int method1(int nums) {
        if (nums == 0) {
            return nums;
        } else if (nums == 1) {
            return nums;
        } else if (nums == 2) {
            return nums;
        }
        System.out.println("flag");
        return method1(nums - 1) + method1(nums - 2);
    }

    /**
     * 动态规划法(状态压缩成迭代法)
     * @param nums
     * @return
     */
    public static Long method2(int nums) {
        if (nums == 0) {
            return (long) nums;
        } else if (nums == 1) {
            return (long) nums;
        } else if (nums == 2) {
            return (long) nums;
        }
        Long[] dp = new Long[nums + 1];
        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 2L;
        for (int i = 3; i <= nums; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        
        return dp[nums];
    }
}
