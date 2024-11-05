package com.leung.stack.leetCode;


import com.leung.stack.impl.StackByLinkedList;

import javax.swing.*;

/**
 * @author 丨一
 * @version 1.0
 * @title leetCode20
 * @description:
 * 
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 * 3. 每个右括号都有一个对应的相同类型的左括号。
 * @date 2024/11/4 21:52
 */
public class leetCode20 {


    public static boolean solution(String s) {
        StackByLinkedList<Character> stack = new StackByLinkedList<>(s.length());
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push(')');
                    count++;
                    break;
                case '{':
                    stack.push('}');
                    count++;
                    break;
                case '[':
                    stack.push(']');
                    count++;
                    break;
                case ')': {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character pop = stack.pop();
                    count--;
                    if (Character.valueOf(')').equals(pop)) {
                        break;
                    } else {
                        return false;
                    }
                }
                case '}': {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character pop = stack.pop();
                    count--;
                    if (Character.valueOf('}').equals(pop)) {
                        break;
                    } else {
                        return false;
                    }
                }
                case ']': {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character pop = stack.pop();
                    count--;
                    if (Character.valueOf(']').equals(pop)) {
                        break;
                    } else {
                        return false;
                    }
                }

            }
        }
        return count == 0; 
    }

    public static void main(String[] args) {
        String s = "(){}[]";
        System.out.println(solution(s));
    }
}
