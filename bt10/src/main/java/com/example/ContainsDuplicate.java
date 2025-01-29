package com.example;

import java.util.HashSet;

public class ContainsDuplicate {
    /*
     * Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
     * Link: https://neetcode.io/problems/duplicate-integer
     * Example 1:

        Input: nums = [1, 2, 3, 3]

        Output: true

        Example 2:

        Input: nums = [1, 2, 3, 4]

        Output: false
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Solution.hasDuplicate(nums));
    }

}
class Solution {
    public static boolean hasDuplicate(int[] nums) {
        HashSet<Integer> seenArr = new HashSet<>();
        boolean result = false;

        for (int num: nums) {
            if(seenArr.contains(num)) {
                result = true;
            } else {
                seenArr.add(num);
            }
        }

        return result;
    }
}
