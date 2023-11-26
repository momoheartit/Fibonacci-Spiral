package com.fun.fibonacci.GUI;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;

public class FibonacciSpiral extends JFrame {
    
    private int[] fibonacciNumbers;
    

    public FibonacciSpiral(int[] fibonacciNumbers) {
        super("Fibonacci Spiral");
        this.fibonacciNumbers = fibonacciNumbers;
        initialize();
    }

    private void initialize() {
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
                
        int zoom = (getWidth() - 30) / fibonacciNumbers[fibonacciNumbers.length-1];  
        double startPointX = (getWidth()/4)*3;
        double startPointY = getHeight()/2;
        
        Drawer draw = new Drawer(g, fibonacciNumbers, zoom, startPointX, startPointY);
        draw.drawSquares();
        draw.drawCircles();
    }
}
