package com.jiankun.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/27 11:10
 */
public class ProxyFactory {
    public static Object getProxyInstance(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开启事务");
                        Object resultVal = method.invoke(target, args);
                        System.out.println("关闭事务");
                        return resultVal;
                    }
                });
    }
}
