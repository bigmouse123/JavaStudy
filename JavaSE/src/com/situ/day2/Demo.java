package com.situ.day2;

import org.junit.Test;

import java.util.Random;
import java.util.Scanner;

/**
 * @author 李建坤
 * @version 1.0
 * @date 2025/1/10 9:09
 */

public class Demo {
    public static void main(String[] args) {
//        for (int i = 0; i < 4; i++) {
//            if (i == 2) {
//                System.out.println(i);
//                return;
//            }
//            System.out.println("hello" + i);
//        }
//        System.out.println("world");
//        "hello".equals("hsp");
        System.out.println(11.0 == 11);
    }

    @Test
    public void demo1() {
        Scanner s = new Scanner(System.in);
        String sc = s.next();
    }

    /**
     * *
     * *
     * *
     * *
     * *
     **/
    @Test
    public void demo2() {
        int level = 20;
        for (int i = 1; i <= level; i++) {
            for (int j = 1; j <= level - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1 || i == level) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    @Test
    public void demo3() {
        label1:
        for (int j = 0; j < 4; j++) {
            label2:
            for (int i = 0; i < 10; i++) {
                if (i == 2) {
                    //看看分别输出什么值，并分析
//                    continue;
//                    continue label2;
                    continue label1;
                }
                System.out.println("i=" + i);
            }
        }
    }

    @Test
    public void demo4() {
        //random
        Random random = new Random();
        int i = 1;
        while (i <= 100) {
            int num = random.nextInt(1000);
            System.out.println("num=" + num);
            i++;
        }
    }

    @Test
    public void demo5() {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入月份:");
        int month = s.nextInt();
        System.out.println("请输入年份:");
        int year = s.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("31天");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("30天");
                break;
            case 2:
                if (isLeapyear(year)) {
                    System.out.println("29天");
                } else {
                    System.out.println("28天");
                }

        }
    }

    public boolean isLeapyear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void demo6() {
        int[] a = new int[]{1, 5, 9, 4, 3};
        System.out.println(add(a));
    }

    public int add(int... a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
}
