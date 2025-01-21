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
        
        // Calculate sum of all subarrays starting from start index
        int totalSum = 0;
        for (int i = start; i <= arr.length - k; i++) {
            int windowSum = 0;
            for (int j = i; j < i + k; j++) {
                windowSum += arr[j];
            }
            totalSum += windowSum;
            System.out.println("Sum of subarray ["+ i + "," + (i+k-1) + "]: " + windowSum);
        }
        
        System.out.println("Total sum of all subarrays starting from index " + start + ": " + totalSum);
    }

    /**
     * 1 2 3 4 5 6 7 8 9 10
     * k = 3
     * 123 -> 6
     * 234 -> 9
     * 345 -> 12
     * 456 -> 15
     * 567 -> 18
     * 678 -> 21
     * 789 -> 24
     * 8910 -> 27
     */
    public static int findSumOfSubarrayWithRecursive(int[] arr, int start, int k) {
        if(k <= 0 || start >= arr.length || start < 0 || k > arr.length) {
            return 0;
        }
        int sumOfWindow = calculateSumInWindow(arr, start, k);
        return sumOfWindow + findSumOfSubarrayWithRecursive(arr, start+1, k);
    }

    public static int calculateSumInWindow(int[] arr, int start, int k) {
        if(k == 0 || start >= arr.length || start < 0 || k > arr.length || (start + k) > arr.length) {
            return 0;
        }
        return arr[start] + calculateSumInWindow(arr, start+1, k-1);
    }

    public static void findAllSubarraySums(int[] arr, int k) {
        // Check if array length is less than k
        if (arr.length < k) {
            System.out.println("Array length is less than k");
            return;
        }
        
        // Calculate sum of first window of size k
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        
        // Print first subarray sum
        System.out.println("Sum of subarray [0," + (k-1) + "]: " + windowSum);
        
        // Slide the window and calculate sums for remaining subarrays
        for (int i = k; i < arr.length; i++) {
            // Add next element and remove first element of previous window
            windowSum = windowSum + arr[i] - arr[i - k];
            System.out.println("Sum of subarray [" + (i-k+1) + "," + i + "]: " + windowSum);
        }
    }

    //find max of all sum of all subarray with length k (A subarray is a contiguous non-empty sequence of elements within an array.)
    public static int findMaxOfAllSubarraySums(int[] arr, int k) {
        int maxSum = 0;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    // find max of all sum of subarray with length k recursively
    public static int findMaxOfAllSubarraySumsWithRecursive(int[] arr, int k, int start) {
        if(k <= 0 || start >= arr.length || start < 0 || k > arr.length || (start + k) > arr.length) {
            return 0;
        }
        int sumOfWindow = calculateSumInWindow(arr, start, k);
        return Math.max(sumOfWindow, findMaxOfAllSubarraySumsWithRecursive(arr, k, start+1));
    }
}