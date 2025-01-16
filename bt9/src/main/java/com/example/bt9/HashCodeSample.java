package com.example.bt9;

public class HashCodeSample {
    public final int[] arr = new int[10];

    
    public HashCodeSample() {
        this.add(1);
        this.add(2);
        this.add(3);
        this.add(4);
        this.add(5);
        this.add(6);
        this.add(7);
        this.add(8);
        this.add(9);
        this.add(10);
        this.add(11);
    }

    // find a hashCode of an integer in context this integer will be put to an array size 10, 20, ...
    public int findIndexByValue(int value) {
        int notFoundHashCode = -1;

        // find the index of the integer in the array
        int index = hashCodeValue(value);
        if(arr[index] == value) {
            return index;
        } else {
            return notFoundHashCode;
        }
    }

    public void add(int value) {
        int index = hashCodeValue(value);
        arr[index] = value;
        System.out.println("Value " + value + " added to index " + index);
    }

    public int hashCodeValue(int value) {
        return value % arr.length;
    }
}