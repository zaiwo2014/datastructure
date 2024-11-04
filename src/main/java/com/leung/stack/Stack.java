package com.leung.stack;


/**
 * @author 丨一
 * @version 1.0
 * @title Stack
 * @description:
 * @date 2024/11/4 18:12
 */
public interface Stack<E> {

    /**
     * 向栈顶压入元素
     * @param element
     * @return 操作是否成功
     */
    boolean push(E element);

    /**
     * 获取栈顶元素(弹栈)
     * @return 栈顶元素
     */
    E pop();

    /**
     * 查看栈顶元素(不弹出)
     * @return 栈顶元素
     */
    E peek();

    /**
     * 判空
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * 判满
     * @return 是否已满
     */
    boolean isfull();
}
