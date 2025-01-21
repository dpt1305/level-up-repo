package com.example.bt9;

// import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};

        // 1. Print index and value
        // PrintValuesInArray.printIndexValue(arr);
        // PrintValuesInArray.printIndexValueWithRecursive(arr, 0);

        // 2. Print even-indexed values
        // System.out.println(PrintValuesInArray.sumEvenIndexedValues(arr));
        // System.out.println(PrintValuesInArray.sumEvenIndexedValuesWithRecursive(arr, 0));

        // 3. Find max value
        // int maxValue = PrintValuesInArray.findMaxValue(arr);
        // int maxValueWithRecursive = PrintValuesInArray.findMaxValueWithRecursive(arr, 0);
        // System.out.println("Max value: " + maxValueWithRecursive);

        // 4. Find seond max value 
        // int maxIndex = 1;  // index of 35, which is the maximum value
        // int secondMaxIndex = FindMaxValueInArray.findSecondMaxIndex(arr, maxIndex);
        // System.out.println("Index of second maximum value: " + secondMaxIndex);  // Should print 4 (index of 34)
        // int secondMaxValueWithRecursive = FindMaxValueInArray.findSecondMaxValueWithRecursive(arr, 0, maxIndex);
        // System.out.println("Second max value: " + secondMaxValueWithRecursive);

        // 5. Find all subarray's Sum
        // int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int start = 1;
        SubarraySum.findSubarraySums(arr, k, start);
        // SubarraySum.findAllSubarraySums(arr, k);
        System.out.println(SubarraySum.findSumOfSubarrayWithRecursive(arr, start, k));
        
        // // 6. find max of all sum of all subarray with length k (A subarray is a contiguous non-empty sequence of elements within an array.)
        // // int k = 3;
        // int maxSum = SubarraySum.findMaxOfAllSubarraySums(arr, k);
        // System.out.println("Max sum of all subarray with length " + k + ": " + maxSum);

        // 7. Hashcode finding
        // HashCodeSample hashCodeSample = new HashCodeSample();
        // System.out.println(hashCodeSample.findIndexByValue(12));


        // 8. iteration a linked list
        // IterationLinkedList.iterationLinkedList();

        // // 9. reverse a linked list
        // IterationLinkedList.reverseLinkedList();


    }
}