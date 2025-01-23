package com.situ.day3;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author 李建坤
 * @version 1.0
 * @date 2025/1/13 19:09
 */
public class HomeWork {

    @Test
    public void count() {
        int[] scores = {0, 0, 1, 2, 3, 5, 4, 5, 2, 8, 7, 6, 9, 5, 4, 8, 3, 1, 0, 2, 4, 8, 7, 9, 5, 2, 1, 2, 3, 9};
        int counts[] = new int[10];
        for (int i = 0; i < scores.length; i++) {
            counts[scores[i]]++;
        }
        for (int count : counts) {
            System.out.print(count + " ");
        }
    }

    @Test
    public void nums() {
        int[] scores = {0, 0, 1, 2, 3, 5, 4, 5, 2, 8, 7, 6, 9, 5, 4, 8, 3, 1, 0, 2, 4, 8, 7, 9, 5, 2, 1, 2, 3, 9};
        int oddNums = 0;
        int evenNums = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] % 2 == 0) {
                evenNums++;
            } else {
                oddNums++;
            }
        }
        System.out.println("evenNums: " + evenNums + " oddNums: " + oddNums);
    }

    @Test
    public void palindrome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = scanner.next();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length / 2; i++) {
            if (charArray[i] != charArray[charArray.length - 1 - i]) {
                System.out.println("不是回文串");
                return;
            }
        }
        System.out.println("是回文串");
    }

    @Test
    public void num() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = scanner.nextLine();
        char[] charArray = str.toCharArray();
        int letterCount = 0;
        int digitCount = 0;
        int spaceCount = 0;
        int otherCount = 0;

        for (char c : charArray) {
            if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                letterCount++;
            } else if (c == ' ') {
                spaceCount++;
            } else if (c >= 48 && c <= 57) {
                digitCount++;
            } else {
                otherCount++;
            }
        }

        System.out.println("letterCount: " + letterCount + " digitCount: " + digitCount + " spaceCount: " + spaceCount + " otherCount: " + otherCount);
    }

}
