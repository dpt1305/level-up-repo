package com.example.bt9;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        // 1. Find seond max value 
        // int[] arr = {12, 35, 1, 10, 34, 1};
        // int maxIndex = 1;  // index of 35, which is the maximum value
        
        // int secondMaxIndex = FindMaxValueInArray.findSecondMaxIndex(arr, maxIndex);
        // System.out.println("Index of second maximum value: " + secondMaxIndex);  // Should print 4 (index of 34)

        // 2. Subarray Sum
        // int[] arr = {1, 2, 3, 4, 5, 6, 7};
        // int k = 3;
        // int start = 1;
        // SubarraySum.findSubarraySums(arr, k, start);
        // SubarraySum.findAllSubarraySums(arr, k);

        // 3. Hashcode of integer
        Integer a = 2;
        System.out.println( Objects.hash(a));

    }
}