package com.leung.recursion;

import java.util.LinkedList;

/**
 * @author 丨一
 * @version 1.0
 * @title HanoiTower
 * @description: 递归经典题 汉诺塔
 * @date 2024/8/24 上午12:03
 */
public class HanoiTower {
    //源柱子
    private static LinkedList<Integer> a = new LinkedList<>();
    //缓冲柱
    private static LinkedList<Integer> b = new LinkedList<>();
    //目标柱
    private static LinkedList<Integer> c = new LinkedList<>();
    
    
    public static void init(int n) {
        for (int i = n; i > 0; i--) {
            a.addLast(i);
        }
    }

    public static void main(String[] args) {
        init(64);
        solution(64,a,b,c);
    }
    
    private static void solution(int n
            , LinkedList<Integer> a
            , LinkedList<Integer> b
            , LinkedList<Integer> c) {
        if (n == 0) {
            return;
        }
        /*
        * 思路:
        *       先把最大的圆盘移动到目标柱, 把每个问题都分成这个子问题
        *               所有问题都能近似归结为: b(缓冲柱)有n-1个盘子,c(目标柱)有最大的盘子
        *               
        * 
        * */
        
        solution(n - 1,a,c,b);
        c.addLast(a.removeLast());
        solution(n - 1,b,a,c);
    }
}
