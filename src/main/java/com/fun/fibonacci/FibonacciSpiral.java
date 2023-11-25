package com.fun.fibonacci;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;

public class FibonacciSpiral extends JFrame {

    public FibonacciSpiral() {
        super("Fibonacci Spiral");
        initialize();
    }

    private void initialize() {
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        //getContentPane().setBackground(Color.BLACK);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight()); // Fekete háttér

        g.setColor(new Color(255, 215, 0));
        
        int atmero0 = 0;
        int sugar0 = 0;
        int x0 = getWidth()/2;
        int y0 = getWidth()/2;

        // 1.
        int atmero1 = 25;
        int sugar1 = atmero1/2;
        int x1 = (x0+sugar0)-atmero1;
        int y1 = (y0+sugar0)-atmero1;
        int rx1 = x1 + sugar1;
        int ry1 = y1;
        
        g.drawArc(x1, y1, atmero1, atmero1, 0, 90);
        g.drawRect(rx1, ry1, sugar1, sugar1);
        g.drawString("1", rx1 + sugar1/2, ry1 + sugar1/2);
        
        //2
        int atmero2 = atmero0 + atmero1;
        int sugar2 = atmero2/2;
        int x2 = (x1 + sugar1) - sugar2;
        int y2 = y1;
        int rx2 = x2;
        int ry2 = y2;
        
        g.drawArc(x2, y2, atmero2, atmero2, 90, 90);
        g.drawRect(rx2, ry2, sugar2, sugar2);
        g.drawString("2", rx2 + sugar2/2, ry2 + sugar2/2);
        
        //3
        int atmero3 = atmero1 + atmero2;
        int sugar3 = atmero3 /2;
        int x3 = (x2 + atmero2) - sugar3;
        int y3 = (y2 + sugar2) - sugar3;
        int rx3 = x3;
        int ry3 = y3 + sugar3;
        
        
        g.drawArc(x3, y3, atmero3, atmero3, 180, 90);
        g.drawRect(rx3, ry3, sugar3, sugar3);
        g.drawString("3", rx3 + sugar3/2 , ry3 + sugar3/2);

        //4
        int atmero4 = atmero2 + atmero3;
        int sugar4 = atmero4/2;
        int x4 = (x3 + sugar3) - sugar4;
        int y4 = (y3 + atmero3) - atmero4;
        int rx4 = x4 + sugar4;
        int ry4 = y4 + sugar4;
        
        g.drawArc(x4, y4, atmero4, atmero4, 270, 90);
        g.drawRect(rx4, ry4, sugar4, sugar4);
        g.drawString("4", rx4 + sugar4/2 , ry4 + sugar4/2);
        
        // ************ CASE 0 -> 90 ************
        //5
        int atmero5 = atmero3 + atmero4;
        int sugar5 = atmero5/2;
        int x5 = (x4 + atmero4) - atmero5;
        int y5 = (y4 + sugar4) - sugar5;
        
        int rx5 = x5 + sugar5;
        int ry5 = y5;
        
        g.drawArc(x5, y5, atmero5, atmero5, 0, 90);
        g.drawRect(rx5, ry5, sugar5, sugar5);
        g.drawString("5", rx5 + sugar5/2, ry5 + sugar5/2);
        
        // ************ CASE 90 -> 180 ************
        //6
        int atmero6 = atmero4 + atmero5;
        int sugar6 = atmero6/2;
        int x6 = (x5 + sugar5) - sugar6;
        int y6 = y5;
        int rx6 = x6;
        int ry6 = y6;
        
        g.drawArc(x6, y6, atmero6, atmero6, 90, 90);
        g.drawRect(rx6, ry6, sugar6, sugar6);
        g.drawString("6", rx6 + sugar6/2, ry6 + sugar6/2);
        
        // ************ CASE 180 -> 270 ************
        //7
        int atmero7 = atmero5 + atmero6;
        int sugar7 = atmero7/2;
        int x7 = x6;
        int y7 = (y6 + sugar6) - sugar7;
        int rx7 = x7;
        int ry7 = y7 + sugar7;
        
        g.drawArc(x7, y7, atmero7, atmero7, 180, 90);
        g.drawRect(rx7, ry7, sugar7, sugar7);
        g.drawString("7", rx7 + sugar7/2 , ry7 + sugar7/2);
        
        // ************ CASE 270 -> 0 ************
        //8
        int atmero8 = atmero6 + atmero7;
        int sugar8 = atmero8/2;
        int x8 = (x7 + sugar7) - sugar8;
        int y8 = (y7 + atmero7) - atmero8;
        
        int rx8 = x8 + sugar8;
        int ry8 = y8 + sugar8;
        
        g.drawArc(x8, y8, atmero8, atmero8, 270, 90);
        g.drawRect(rx8, ry8, sugar8, sugar8);
        g.drawString("8", rx8 + sugar8/2, ry8 + sugar8/2);
    }
}
