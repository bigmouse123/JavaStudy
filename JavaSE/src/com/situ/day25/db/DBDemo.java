package com.situ.day25.db;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/21 17:00
 */
public class DBDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ClassLoader classLoader = DBDemo.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("db1.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String classPath = properties.getProperty("classPath");
        Class<?> cls = Class.forName(classPath);
        Constructor<?> constructor = cls.getConstructor();
        IDB db = (IDB) constructor.newInstance();
        db.getConnection();
    }
}
