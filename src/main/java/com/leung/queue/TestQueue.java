package com.leung.queue;


import com.leung.queue.impl.QueueByLinkedList;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

/**
 * @author 丨一
 * @version 1.0
 * @title Test
 * @description:
 * @date 2024/10/31 15:30
 */
public class TestQueue {

    @Test
    public void test() {
        QueueByLinkedList<Integer> queue = new QueueByLinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue.poll());
        System.out.println("-----------------------");
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
