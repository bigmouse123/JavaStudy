package com.situ.day2;

/**
 * @author 李建坤
 * @version 1.0
 * @date 2025/1/11 16:15
 */
public class Finalize_ {
    public static void main(String[] args) {
        Car car = new Car("宝马");
        car = null;
        System.gc();
        System.out.println("程序退出");
    }

}

class Car {
    private String name;

    //属性, 资源。。
    public Car(String name) {
        this.name = name;
    }

    //重写finalize
    @Override
    protected void finalize() throws Throwable {
        System.out.println("我们销毁 汽车" + name);
        System.out.println("释放了某些资源...");
    }
}
