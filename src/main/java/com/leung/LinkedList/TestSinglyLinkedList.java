package com.leung.LinkedList;

import com.leung.DynamicArrays.DynamicArrayAgain;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @title:Test
 * @Author:Leung
 * @Description:
 * @DATE:2024/5/7 05:42
 * @Version: 1.0
 */

public class TestSinglyLinkedList {

    @Test
    public void test() {
        SinglyLinkedListSentinel singlyLinkedList = new SinglyLinkedListSentinel();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);
        singlyLinkedList.remove(3);
        singlyLinkedList.loopList(System.out::println);
    }

    @Test
    public void test2() {
        SinglyLinkedListSentinel integers = new SinglyLinkedListSentinel();
        integers.addLast(1);
        integers.addLast(2);
        integers.addLast(3);
        integers.removeFirst();
        integers.loopList(System.out::println);
    }

    @Test
    public void test3() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addFirst(11);
        doublyLinkedList.addFirst(12);
        doublyLinkedList.addFirst(13);
        doublyLinkedList.addLast(14);

        for (Integer value : doublyLinkedList) {
            System.out.println(value);
        }

    }

    @Test
    public void test4() {
        DoublyLinkedCircularList list = new DoublyLinkedCircularList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.remove(0);
        list.addLast(100);
        list.insert(1000, 2);
        list.loopWithRecursion();
    }

    @Test
    public void test5() {
        DynamicArrayAgain dynamicArrayAgain = new DynamicArrayAgain();
        for (int i = 0; i < 10; i++) {
            dynamicArrayAgain.add(i);
            if (i == 9) {
                System.out.println(dynamicArrayAgain.capacity);
            }
        }
        for (Integer i : dynamicArrayAgain) {
            System.out.println(i);
        }
    }

}
