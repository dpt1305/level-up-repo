package com.example.bt9;

public class FindMaxValueInArray {
    public static int findSecondMaxIndex(int[] arr, int maxIndex) {
        int secondMax = Integer.MIN_VALUE;
        int secondMaxIndex = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (i != maxIndex && arr[i] > secondMax) {
                secondMax = arr[i];
                secondMaxIndex = i;
            }
        }
        
        return secondMaxIndex;
    }


    // 3 10 6 1 8 
    public static int findSecondMaxValueWithRecursive(int[] arr, int index, int maxIndex) {
        if(index >= arr.length ) {
            return Integer.MIN_VALUE;
        }
        if(index != maxIndex && arr[index] > findSecondMaxValueWithRecursive(arr, index+1, maxIndex)) {
            return arr[index];
        } else {
            return findSecondMaxValueWithRecursive(arr, index+1, maxIndex);
        }

    }

    public static int findMaxIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;  // Return -1 for empty or null array
        }
        
        int maxIndex = 0;
        
        // Iterate through the array starting from second element
        for (int i = 1; i < arr.length; i++) {
            // Update maxIndex if current element is larger
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        
        return maxIndex;
    }
}
