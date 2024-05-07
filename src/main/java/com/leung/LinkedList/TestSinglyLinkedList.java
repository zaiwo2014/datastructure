package com.leung.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;

/**
 * @title:Test
 * @Author:Leung
 * @Description:
 * @DATE:2024/5/7 05:42
 * @Version: 1.0
 */

public class TestSinglyLinkedList {

    @Test
    public void test(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);
        singlyLinkedList.remove(3);
        singlyLinkedList.loopList(System.out::println);
    }
}
