package com.situ.day2;

/**
 * @author 李建坤
 * @version 1.0
 * @date 2025/1/11 9:46
 */
public class Demo2 {
    public static void main(String[] args) {
        C c = new C();
        Demo2 d = new Demo2();
        d.m1();
    }

    public void m1() {
        System.out.println("m1()");
    }
}

class A {//A 类

    public A() {
        System.out.println("我是 A 类");
    }
}

class B extends A { //B 类,继承 A 类
    public B() {
        //main 方法中： Cc=newC(); 输出么内容?3min
        System.out.println("我是 B 类的无参构造");
    }

    public B(String name) {
        System.out.println(name + "我是 B 类的有参构造");
    }
}

class C extends B { //C 类，继承 B类
    public C() {
        this("hello");
        System.out.println("我是 c 类的无参构造");
    }

    public C(String name) {
        super("hahah");
        System.out.println("我是c类的有参构造");
    }
}
