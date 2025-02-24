package com.situ.day26;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/24 13:57
 */
@Author(name = "张三")
public class AuthorDemo {
    @Author(name = "王五")
    private String name;

    @Author(name = "李四")
    public void add() {

    }

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        Class<AuthorDemo> cls = AuthorDemo.class;
        Author author1 = cls.getAnnotation(Author.class);
        System.out.println(author1.name());

        Method method = cls.getMethod("add");
        Author author2 = method.getAnnotation(Author.class);
        System.out.println(author2.name());

        Field field = cls.getDeclaredField("name");
        Author author3 = field.getAnnotation(Author.class);
        System.out.println(author3.name());
    }
}
