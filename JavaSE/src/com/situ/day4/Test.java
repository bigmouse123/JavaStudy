package com.situ.day4;

/**
 * @author 李建坤
 * @version 1.0
 * @date 2025/1/14 11:34
 */
public class Test {//外部类

    public Test() {//构造器
        Inner s1 = new Inner();
        s1.a = 10;
        Inner s2 = new Inner();
        System.out.println(s2.a);
    }

    class Inner {//内部类，成员内部类
        public int a = 5;
    }

    public static void main(String[] args) {
        Test t = new Test();//5
        Inner r = t.new Inner();
        System.out.println(r.a);//5
    }

}
