package com.situ.day2;

/**
 * @author 李建坤
 * @version 1.0
 * @date 2025/1/11 14:20
 */
public class Demo4 {
    public static void main(String[] args) {
        A1 a = new B1();
        System.out.println(a.sum());
        System.out.println(a.sum1());
    }
}

class A1 {
    public int i = 10;

    public int getI() {
        return i;
    }

    public int sum() {
        return getI() + 10;
    }

    public int sum1() {
        return i + 10;
    }
}

class B1 extends A1 {
    public int i = 20;

    public int getI() {
        return i;
    }

    public int sum() {
        return i + 20;
    }

    public int sum1() {
        return i + 10;
    }
}
