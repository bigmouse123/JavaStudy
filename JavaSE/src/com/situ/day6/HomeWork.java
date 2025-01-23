package com.situ.day6;

import org.junit.Test;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/1/16 19:25
 */
public class HomeWork {

    @Test
    public void trim() {
//        String str = "   java Android    ";
//        String str = "  ";
//        String str = "";
        String str = "    a    ";
        if (str == null || str.length() == 0) {
            System.out.println("");
            return;
        }
        int left = 0;
        int right = str.length() - 1;
        while (left <= str.length() - 1 && str.charAt(left) == ' ') {
            left++;
        }
        while (right >= 0 && str.charAt(right) == ' ') {
            right--;
        }
        if (left > right) {
            System.out.println("");
            return;
        }
        String substring = str.substring(left, right + 1);
        System.out.println(substring);
    }

    @Test
    public void toUpperCase() {
        String str = "I Love Java!";
        if (str == null || str.length() == 0) {
            return;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] -= 32;
            }
        }
        System.out.println(chars);
    }
}
