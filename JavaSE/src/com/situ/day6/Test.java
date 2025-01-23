package com.situ.day6;

import java.util.HashSet;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/1/18 15:57
 */

public class Test {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");
        hashSet.add("python");
        System.out.println(hashSet);
    }
}