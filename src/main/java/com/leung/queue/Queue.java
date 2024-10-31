package com.leung.queue;


/**
 * @author 丨一
 * @version 1.0
 * @title queue
 * @description: 先进先出
 * @date 2024/10/31 14:30
 */
public interface Queue<E> {

    /*
    入队
     */
    boolean offer(E element);

    /*
    出队
     */
    E poll();

    /**
     * 获取队头元素,不含出队操作
     * @return
     */
    E peek();

    /*
    判断队列是否为空
     */
    boolean isEmpty();
}
