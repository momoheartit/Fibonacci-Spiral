package com.fun.fibonacci;

import javax.swing.SwingUtilities;

public class Fibonacci {

    public static void main(String[] args) {

        //Scanner sc = new Scanner(System.in);
        //System.out.print("How many Fibonacci numbers you want to see?");
        //int arraySize = sc.nextInt();
        SwingUtilities.invokeLater(() -> {
            int arraySize = 15; // Az első 10 Fibonacci számra
            Numbers numbers = new Numbers(arraySize);
            numbers.calculateFibonacci();

            FibonacciSpiral fibonacciSpiral = new FibonacciSpiral(numbers.getFibonacciNumbers());
        });
    }
}
