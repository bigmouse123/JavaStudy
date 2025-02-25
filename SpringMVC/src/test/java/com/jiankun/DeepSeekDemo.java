package com.jiankun;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/24 20:12
 */
@SuppressWarnings("all")
public class DeepSeekDemo {
    @Test
    public void deepSeek() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的问题:");
        while (true) {
            String s = scanner.nextLine();
            System.out.println("思考中...");
            Thread.sleep((int) (Math.random() * 10000));
            System.out.println("服务器繁忙，请稍后再试");
        }
    }
}
