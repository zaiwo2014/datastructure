package com.leung.动态数组;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @title:TestDynamicArray
 * @Author:Leung
 * @Description:
 * @DATE:2024/5/6 16:07
 * @Version: 1.0
 */

public class TestDynamicArray {

    @Test
    public void test() {
        DynamicArray dynamicArray = new DynamicArray();

        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(8);


        Assertions.assertEquals(2, dynamicArray.remove(1));
        dynamicArray.stream().forEach(System.out::println);

    }

}
