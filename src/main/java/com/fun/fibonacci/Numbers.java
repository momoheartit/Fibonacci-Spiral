package com.fun.fibonacci;

public class Numbers {
    
    public int arraySize;
    public int[] fibonacciNumbers;
    
    public Numbers(int arraySize) {
        this.arraySize = arraySize;
        this.fibonacciNumbers = new int[arraySize];
        fibonacciNumbers[0] = 0;
        fibonacciNumbers[1] = 1;
    }
    
    public void calculateFibonacci() {
        for (int i = 2; i < arraySize; i++) {
            fibonacciNumbers[i] = fibonacciNumbers[i-1] + fibonacciNumbers[i-2];
        }
    }
    
    public int[] getFibonacciNumbers() {
        return fibonacciNumbers;
    }
    
    public void printFibonacciNumbers() {
        System.out.println("The first " + arraySize + " Fibonacci numbers:");        
        for (int i = 0; i < arraySize; i++) {
            System.out.println("[" + i + "] " +fibonacciNumbers[i]);
        }
    }
}