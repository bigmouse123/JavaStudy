package com.situ.day2;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author 李建坤
 * @version 1.0
 * @date 2025/1/10 17:15
 */
public class HomeWork {
    public static void main(String[] args) {
        System.out.println(factorial(9));
    }

    @Test
    public void days() {
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
    public void swap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数:");
        int n1 = scanner.nextInt();
        System.out.println("请输入第二个数:");
        int n2 = scanner.nextInt();
        System.out.println("n1=" + n1 + ",n2=" + n2);
        int temp = n1;
        n1 = n2;
        n2 = temp;
        System.out.println("交换后");
        System.out.println("n1=" + n1 + ",n2=" + n2);
    }

    @Test
    public void buy() {
        Scanner scanner = new Scanner(System.in);
        Cashier cashier = new Cashier();
        System.out.println("设置单价:");
        double price = scanner.nextDouble();
        cashier.setPrice(price);
        System.out.println("设置数量:");
        double count = scanner.nextDouble();
        cashier.setCount(count);
        //计算总价
        cashier.setSum(cashier.getCount() * cashier.getPrice());

        if (cashier.getSum() >= 500) {
            System.out.println("超过500元，给您打八折!");
            cashier.setSum(cashier.getSum() * 0.8);
        }

        do {
            System.out.println("用户输入金额:");
            double money = scanner.nextDouble();

            if (money >= cashier.getSum()) {
                System.out.println("找您:" + (money - cashier.getSum()) + "元");
                break;
            } else {
                System.out.println("金额不足，请重新输入!");
            }
        } while (true);


    }

    @Test
    public void number() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    @Test
    public void triangle() {
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Test
    public void untriangle() {
        for (int i = 6; i >= 1; i--) {
            for (int j = 1; j <= 6 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Test
    public void add() {
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                evenSum = evenSum + i;
            } else {
                oddSum = oddSum + i;
            }
        }
        System.out.println("oddSum=" + oddSum + ",evenSum=" + evenSum);
    }

    @Test
    public void divisible5() {
        int count = 0;
        for (int i = 1; i <= 1000; i++) {
            if (i % 5 == 0) {
                count++;
                System.out.print(i + " ");
                if (count % 3 == 0) {
                    System.out.println();
                }
            }
        }
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }


}

class Cashier {

    private double price;
    private double count;
    private double sum;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
