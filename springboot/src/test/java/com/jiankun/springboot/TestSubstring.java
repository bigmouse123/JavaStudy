package com.jiankun.springboot;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/3/3 16:09
 */
public class TestSubstring {
    public static void main(String[] args) {
        String str = "abc.png";
        int i = str.lastIndexOf(".");
        System.out.println(i);
        str = str.substring(i);
        System.out.println(str);
    }
}
