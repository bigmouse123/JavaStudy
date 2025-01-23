package com.situ.day1;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author 李建坤
 * @version 1.0
 * @date 2025/1/9 11:36
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");

    }

    @Test
    public void test() {
        double n1 = 2.7;
        double n2 = 8.1 / 3;
        if ((n1 - n2) < 0.00001) {
            System.out.println("相等");
            System.out.println(n2);
        } else {
            System.out.println("不相等");
        }
    }

    @Test
    public void test1() {
        int n1 = Integer.parseInt("132");
        System.out.println(n1);
    }

    @Test
    public void test2() {
        int a = 4;
        int b = 9;
        if (a > 1 | ++b > 4) {//可以换成|测试
            System.out.println("ok300");
        }
        System.out.println("a=" + a + "b=" + b);//410
    }

    @Test
    public void test3() {
        boolean x = true;
        boolean y = false;
        short z = 46;
        if ((z++ == 46) && (y = true)) {
            z++;
        }
        System.out.println(z);
//        if ((x = false) || (++z == 49)) {
//            z++;
//        }
//        System.out.println(z);
        System.out.println(x = false);
    }

    @Test
    public void test4() {
        int a = 10;
        int b = 99;
        //解读
//1.a>b为false
        //2.返回b--,先返回b的值,然后在b-1
        //3.返回的结果是99
        int result = a > b ? a++ : b--;
        System.out.println("result=" + result);//99
        System.out.println("a=" + a);//10
        System.out.println("b=" + b);//98
    }

    @Test
    public void test5() {
        //表达式1和表达式2要为可以赋给接收变量的类型
//(或可以自动转换/或者强制转换)
        int a = 3;
        int b = 8;
        int c = a > b ? (int) 1.1 : (int) 3.4;//可以的
        System.out.println(c);
        double d = a > b ? a : b + 3;//可以的，满足int->double
        System.out.println(d);
    }

    @Test
    public void test6() {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(str);
    }

    @Test
    public void test7() {
        System.out.println(~2);//-3
        System.out.println(2 & 3);//2
        System.out.println(2 | 3);//3
        System.out.println(2 ^ 3);//1
    }

}
