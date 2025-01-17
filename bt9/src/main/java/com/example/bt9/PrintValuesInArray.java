package com.example.bt9;

public class PrintValuesInArray {
    public static void printIndexValue(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Index: " + i + ", Value: " + arr[i]);
        }
    }

    public static void printIndexValueWithRecursive(int[] arr, int index) {
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.println("Index: " + i + ", Value: " + arr[i]);
        // }
        if(index >= arr.length) {
            System.out.println("out of array");
            return ;
        } else {
            System.out.println("Index: " + index + ", Value: " + arr[index]);
            printIndexValueWithRecursive(arr, index+1);
        }
    }

    // print sum of even-indexed values
    public static int sumEvenIndexedValues(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                sum += arr[i];
            }
        }
        return sum;
    }

    // find max value in array
    public static int findMaxValue(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}