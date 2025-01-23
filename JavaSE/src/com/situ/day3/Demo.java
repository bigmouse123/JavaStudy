package com.situ.day3;

/**
 * @author 李建坤
 * @version 1.0
 * @date 2025/1/13 20:49
 */
public class Demo {
    public static void main(String[] args) {
        new A();
        //(1)B的静态代码块(2)A的静态代码块(3)B的普通代码块(4)B的构造方法
        //(5)A的普通代码块(6)A的构造方法
    }
}

class B {
    public B() {
        System.out.println("B的构造方法");
    }

    {
        System.out.println("B的普通代码块");
    }

    static {
        System.out.println("B的静态代码块");
    }
}

class A extends B {

    public A() {
        System.out.println("A的构造方法");
    }

    {
        System.out.println("A的普通代码块");
    }

    static {
        System.out.println("A的静态代码块");
    }
}
