package com.leung.stack;


import com.leung.stack.impl.StackByArray;
import com.leung.stack.impl.StackByLinkedList;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

/**
 * @author 丨一
 * @version 1.0
 * @title Client
 * @description:
 * @date 2024/11/4 18:35
 */
public class Client {

    @Test
    public void test() {
        StackByLinkedList<Integer> integers = new StackByLinkedList<>(5);
        for (int i = 0; i < 5; i++) {
            integers.push(i);
        }
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    @Test
    public void test2() {
        StackByArray<Integer> integers = new StackByArray<>(10);
        for (int i = 0; i < 10; i++) {
            integers.push(i);
        }
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
