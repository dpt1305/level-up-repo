package com.example.bt9;

public class SubarraySum {
    public static void findSubarraySums(int[] arr, int k, int start) {
        // Check if array length is less than k
        if (arr.length < k) {
            System.out.println("Array length is less than k");
            return;
        }
        if(start < 0 || start > arr.length) {
            System.out.println("Start of window: error");
            return;
        }
        
        // Calculate sum of first window of size k
        int windowSum = 0;
        for (int i = start; i < k; i++) {
            windowSum += arr[i];
        }
        
        // Print first subarray sum
        System.out.println("Sum of subarray [0," + (k-1) + "]: " + windowSum);
    }
}
