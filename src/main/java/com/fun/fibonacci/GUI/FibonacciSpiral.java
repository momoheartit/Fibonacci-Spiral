package com.fun.fibonacci.GUI;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;

public class FibonacciSpiral extends JFrame {

    private int[] fibonacciNumbers;
    double picSizeWidth;
    double picSizeHeight;
    double zoom;
    int border = 20;
    int halfBorder = border/2;

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
        setResizable(false); 
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        ///////////////////////////////////////
        //we can delete this, just here to see clear
        g.setColor(Color.MAGENTA);
        g.drawLine(10, 0, 10, 800);
        g.drawLine(1190, 0, 1190, 800);
        
        g.setColor(Color.MAGENTA);
        g.drawLine(0, 10, 1200, 10);
        g.drawLine(0, 790, 1200, 790);
        ///////////////////////////////////////

        double startPointX = (getWidth() / 4) * 3;
        double startPointY = getHeight() / 2;
        if ((fibonacciNumbers.length - 1) % 4 == 0 || (fibonacciNumbers.length - 1) % 4 == 2) {
            picSizeWidth = getWidth() - border;
            System.out.println("picsizewidth" + picSizeWidth);
            picSizeHeight = fibonacciNumbers[fibonacciNumbers.length - 1] * zoom;
            zoom = (getWidth() - border) / (fibonacciNumbers[fibonacciNumbers.length - 1] + fibonacciNumbers[fibonacciNumbers.length - 2]);
            
            if ((fibonacciNumbers.length - 1) % 4 == 0) {
                startPointX = halfBorder + picSizeWidth*0.35 - zoom/2;
                startPointY = getHeight() - halfBorder - (getHeight() * 0.65) + zoom/2;
            } else {
                //this is what not ready yet
                startPointX = halfBorder + picSizeWidth*0.65 - zoom/2;
                startPointY = getHeight() - halfBorder - (getHeight() * 0.35) + zoom/2;
            }
        } else {
            picSizeWidth = fibonacciNumbers[fibonacciNumbers.length - 1] * zoom;
            picSizeHeight = getHeight() - border;
            zoom = picSizeHeight / fibonacciNumbers[fibonacciNumbers.length - 1];
            
            if ((fibonacciNumbers.length - 1) % 4 == 3) {
                startPointX = ((getWidth()/2) + (picSizeWidth * 0.65)) / 2;
                startPointY = getHeight()-halfBorder-(getHeight()*0.65);
            } else {
                startPointX = ((getWidth()/2) + (picSizeWidth * 0.35)) / 2 + zoom/2;
                startPointY = getHeight()-halfBorder-(getHeight()*0.35) + zoom/2;
            }
            
            
            
        }

        Drawer draw = new Drawer(g, fibonacciNumbers, zoom, startPointX, startPointY);
        draw.drawSquares();
        draw.drawCircles();
    }
}