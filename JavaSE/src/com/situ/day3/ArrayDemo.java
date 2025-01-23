package com.situ.day3;

import org.junit.Test;

/**
 * @author 李建坤
 * @version 1.0
 * @date 2025/1/13 13:47
 */
public class ArrayDemo {

    @Test
    public void demo1() {
        int array[] = {20, 23, 16, 14, 15};
        for (int item : array) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = " + args[i]);
        }
    }
}
