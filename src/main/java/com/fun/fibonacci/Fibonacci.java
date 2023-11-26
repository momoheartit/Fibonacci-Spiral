package com.fun.fibonacci;

import com.fun.fibonacci.GUI.FibonacciSpiral;
import javax.swing.SwingUtilities;

public class Fibonacci {

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            int arraySize = 7; 
            Numbers numbers = new Numbers(arraySize);
            numbers.calculateFibonacci();
            numbers.printFibonacciNumbers();

            FibonacciSpiral fibonacciSpiral = new FibonacciSpiral(numbers.getFibonacciNumbers());
        });
    }
}
