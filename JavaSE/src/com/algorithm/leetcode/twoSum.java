package com.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/11 8:43
 */
public class twoSum {
    public static void main(String[] args) {
        int[] ints = new Solution().twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}