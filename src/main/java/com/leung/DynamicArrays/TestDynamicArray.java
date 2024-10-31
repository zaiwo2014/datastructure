package com.leung.DynamicArrays;





import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.Iterator;

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

    @Test
    @DisplayName("动态数组")
    public void test2() {
        DynamicArrayAgain dynamicArrayAgain = new DynamicArrayAgain();
        dynamicArrayAgain.add(1);
        dynamicArrayAgain.add(2);
        dynamicArrayAgain.add(3);
        dynamicArrayAgain.add(4);
        Iterator<Integer> iterator = dynamicArrayAgain.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
