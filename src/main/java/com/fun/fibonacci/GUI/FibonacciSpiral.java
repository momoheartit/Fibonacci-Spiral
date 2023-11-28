package com.fun.fibonacci.GUI;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;

public class FibonacciSpiral extends JFrame {

    private int[] fibonacciNumbers;
    double picSizeWidth;
    double picSizeHeight;
    double zoom;
    int border = 100;
    int margin = border / 2;

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
        g.drawLine(50, 0, 50, 800);
        g.drawLine(1150, 0, 1150, 800);

        g.setColor(Color.MAGENTA);
        g.drawLine(0, 50, 1200, 50);
        g.drawLine(0, 750, 1200, 750);
        ///////////////////////////////////////

        int startPointX;
        int startPointY;
        if ((fibonacciNumbers.length - 1) % 4 == 0 || (fibonacciNumbers.length - 1) % 4 == 2) {
            picSizeWidth = getWidth() - border;
            zoom = picSizeWidth / (fibonacciNumbers[fibonacciNumbers.length - 1] + fibonacciNumbers[fibonacciNumbers.length - 2]);
            picSizeHeight = fibonacciNumbers[fibonacciNumbers.length - 1] * zoom;
            if ((fibonacciNumbers.length - 1) % 4 == 0) { //0
                startPointX = (int) (margin + picSizeWidth * 0.35 - zoom / 2);
                startPointY = (int) (getHeight() - margin - (getHeight() * 0.65) + zoom / 2);
            } else { //2
                /////////////////new work on this.
                int x = 0;
                for (int i = 1; i < fibonacciNumbers.length; i++){
                    if ( i % 4 == 0)
                    x += fibonacciNumbers[i];
                }
                startPointX = (int) (getWidth() - margin - (x * zoom));
                
                int y = 0;
                for (int i = 1; i < fibonacciNumbers.length; i++){
                    if ( i % 4 == 3)
                    y += fibonacciNumbers[i];
                }
                System.out.println("y: " + y);
                startPointY = (int) (getHeight() - margin - (y * zoom));
            }

        } else {
            picSizeWidth = fibonacciNumbers[fibonacciNumbers.length - 1] * zoom;
            picSizeHeight = getHeight() - border;
            zoom = picSizeHeight / fibonacciNumbers[fibonacciNumbers.length - 1];

            if ((fibonacciNumbers.length - 1) % 4 == 3) { //3
                startPointX = (int) (((getWidth() / 2) + (picSizeWidth * 0.65)) / 2);
                startPointY = (int) (getHeight() - margin - (getHeight() * 0.65));
            } else { //1
                startPointX = (int) (((getWidth() / 2) + (picSizeWidth * 0.35)) / 2 + zoom / 2);
                startPointY = (int) (getHeight() - margin - (getHeight() * 0.35) + zoom / 2);
            }
        }

        Drawer draw = new Drawer(g, fibonacciNumbers, zoom, startPointX, startPointY);
        draw.drawSquares();
        draw.drawCircles();
    }
}
