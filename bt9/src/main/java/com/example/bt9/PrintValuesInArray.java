package com.example.bt9;

public class PrintValuesInArray {
    public static void printIndexValue(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Index: " + i + ", Value: " + arr[i]);
        }
    }

    // print even-indexed values
    public static void printEvenIndexedValues(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                System.out.println("Index: " + i + ", Value: " + arr[i]);
            }
        }
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