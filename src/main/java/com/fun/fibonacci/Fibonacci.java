package com.fun.fibonacci;

import com.fun.fibonacci.GUI.FibonacciSpiral;
import javax.swing.SwingUtilities;

public class Fibonacci {

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            int arraySize = 11; //a 46. még jó, a 47. már nem
            Numbers numbers = new Numbers(arraySize);
            numbers.calculateFibonacci();
            numbers.printFibonacciNumbers();

            FibonacciSpiral fibonacciSpiral = new FibonacciSpiral(numbers.getFibonacciNumbers());
        });
    }
}