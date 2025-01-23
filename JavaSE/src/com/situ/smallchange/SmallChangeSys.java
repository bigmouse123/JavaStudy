package com.situ.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author 李建坤
 * @version 1.0
 * @date 2025/1/11 20:56
 */
public class SmallChangeSys {
    public static void main(String[] args) {

        boolean loop = true;
        int key;
        String details = "--------------零钱通明细--------------\n";
        String item;
        String choice;
        double money;
        double balance = 0;
        Scanner scanner = new Scanner(System.in);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        do {
            System.out.println("==============零钱通菜单==============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退出");
            System.out.printf("请输入选择(1~4):");
            key = scanner.nextInt();


            switch (key) {
                case 1:
                    System.out.println(details);
                    break;
                case 2:
                    System.out.printf("请输入收益金额:");
                    money = scanner.nextDouble();
                    if (money <= 0) {
                        System.out.println("收益金额应大于0");
                        break;
                    }
                    balance += money;
                    details = details + "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case 3:
                    System.out.print("请输入消费项目:");
                    item = scanner.next();
                    System.out.printf("请输入消费金额:");
                    money = scanner.nextDouble();
                    if (money <= 0 || money > balance) {
                        System.out.println("消费金额应在0~" + balance + "之间");
                        break;
                    }
                    balance -= money;
                    details = details + "\n" + item + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case 4:
                    while (true) {
                        System.out.println("是否要退出(y/n)");
                        choice = scanner.next();
                        if (choice.equals("y") || choice.equals("n")) {
                            break;
                        }
                    }
                    if (choice.equals("y")) {
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("输入有误，请重新输入!");
            }

        } while (loop);
    }
}
