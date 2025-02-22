package com.situ.day25.homework;

import java.lang.reflect.Field;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/21 17:28
 */
public class HomeWork {
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("=============teacher=============");
        changeField(new Teacher());
        System.out.println("=============student=============");
        changeField(new Student());
    }

    public static void changeField(Object obj) throws IllegalAccessException {
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == String.class) {
                field.setAccessible(true);
                System.out.println(field.getName() + " : " + field.get(obj));
                field.set(obj, field.get(obj).toString().replace('a', 'b'));
            }
        }
        System.out.println("=========");
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName() + " : " + field.get(obj));
        }
    }
}

class Teacher {
    private String name = "android";
    private int age = 18;
    private String address = "qingdao";

    @Override
    public String toString() {
        return "Teacher [name=" + name + ", age=" + age + ", address="
                + address + "]";
    }
}

class Student {
    private String name = "an apple";
    private int age = 18;
    private String address = "jinan";

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", address="
                + address + "]";
    }
}
