package com.leung.queue;


import com.leung.queue.impl.QueueByArrayList2;
import com.leung.queue.impl.QueueByArrayList3;
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
    public void listQueue1() {
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


    @Test
    void listQueue2() {
        QueueByArrayList2<Integer> queue = new QueueByArrayList2<>(10);
        int i = 0;
        while (!queue.isfull()) {
            queue.offer(i++);
        }
        queue.offer(i);
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    void listQueue3() {

        QueueByArrayList3<Integer> queue = new QueueByArrayList3<Integer>(2);
        for (int i = 0; i < 2; i++) {
            queue.offer(i);
        }
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
