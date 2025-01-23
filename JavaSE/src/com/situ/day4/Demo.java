package com.situ.day4;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author 李建坤
 * @version 1.0
 * @date 2025/1/14 9:38
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println(Season.SPRING);
    }

    @Test
    public void isLeapyear() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份:");
        int year = scanner.nextInt();
        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
            System.out.println(year + " is a leap year");
        } else {
            System.out.println(year + " is not a leap year");
        }
    }
}

enum Season {
    SPRING("春天", "温暖"),
    SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"),
    WINTER("冬天", "寒冷");


    String name;
    String state;

    private Season(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
