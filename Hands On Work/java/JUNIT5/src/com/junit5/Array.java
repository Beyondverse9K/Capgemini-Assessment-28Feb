package com.junit5;

public class Array {
   
    public boolean isEven(int number) {
        return number % 2 == 0;
    }   
    public boolean isReversed(int[] arr1, int[] arr2) {   
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            return false;
        }       
        int length = arr1.length;
        for (int i = 0; i < length; i++) {           
            if (arr1[i] != arr2[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
    public int add(int a, int b) {
        return a + b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
}