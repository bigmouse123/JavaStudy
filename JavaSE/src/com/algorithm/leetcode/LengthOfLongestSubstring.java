package com.algorithm.leetcode;

import java.util.HashSet;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/12 11:59
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
//        int i = lengthOfLongestSubstring(" ");
//        int i = lengthOfLongestSubstring("au");
        int i = lengthOfLongestSubstring("abcabcbb");
//        int i = lengthOfLongestSubstring("bbbbb");
//        int i = lengthOfLongestSubstring("pwwkew");
        System.out.println(i);
    }

//    public static int lengthOfLongestSubstring(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        int maxLength = 1;
//        for (int i = 0; i < s.length(); i++) {
//            int length = 1;
//            StringBuffer sb = new StringBuffer();
//            sb.append(String.valueOf(s.charAt(i)));
//            for (int j = i + 1; j < s.length(); j++) {
//                if (sb.toString().contains(String.valueOf(s.charAt(j)))) {
//                    break;
//                } else {
//                    sb.append(String.valueOf(s.charAt(j)));
//                    length++;
//                }
//            }
//            if (length > maxLength) {
//                maxLength = length;
//            }
//            if (maxLength >= (s.length() - (i + 1))) {
//                break;
//            }
//        }
//        return maxLength;
//    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int maxLength = 1;
        HashSet<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                maxLength = (set.size() > maxLength) ? set.size() : maxLength;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
}
