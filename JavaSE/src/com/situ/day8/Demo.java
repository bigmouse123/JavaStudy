package com.situ.day8;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/1/20 14:53
 */
public class Demo {

    @Test
    public void test1() {
        try {
            FileInputStream fis = new FileInputStream("io.txt");
            int read = fis.read();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("finally");
        }
    }

    @Test
    public void test2() {
        try {
            test3(200);
        } catch (A_Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void test3(int i) throws A_Exception {
        if (i > 1000) {
            throw new A_Exception("钱不够");
        }
        System.out.println("消费成功");
    }
}

class A_Exception extends Exception {
    public A_Exception(String message) {
        super(message);
    }
}
