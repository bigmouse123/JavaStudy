package com.situ.day8;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/1/20 19:53
 */
public class Demo2 {
    public static void main(String[] args) {
        USB<Double, Integer> usb = new USB<Double, Integer>();
        usb.text(2.0);
        usb.text3();
    }
}

class USB<T, R> {
    R text(T t) {
        return null;
    }

    <E> E text2() {
        return null;
    }

    <T> int text3() {
        return 5;
    }

    public <U> void text4(U u, T t) {

    }

    T name;
}