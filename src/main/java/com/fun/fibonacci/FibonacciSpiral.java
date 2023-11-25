package com.fun.fibonacci;

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
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight()); // Fekete háttér
        /*
        g.setColor(Color.LIGHT_GRAY);
        int column = 50;
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < column; j++) {
                if ((i + j) % 2 == 0) {
                    g.setColor(Color.lightGray);
                } else {
                    g.setColor(Color.lightGray);
                }

                g.drawRect(i * column, j * column, column, column);
            }
        }*/
        
        /*
        Graphics2D g2d = (Graphics2D) g;
                float circleThickness = 3.0f;
                g2d.setStroke(new BasicStroke(circleThickness));
        */
        
        int circleX = (getWidth()/4)*3;
        int circleY = getHeight()/2;
        int newCircleX = circleX;
        int newCircleY = circleY;
        
        
        for (int i = 1; i <fibonacciNumbers.length; i++){
            
            int zoom = 2;
            int diameter = fibonacciNumbers[i]*zoom;
            int radius = diameter/2;
            int lastDiameter = fibonacciNumbers[i-1]*zoom;
            int lastRadius = lastDiameter/2;
            
            if( (i % 4) == 0) {
                newCircleX = (circleX + lastRadius) - radius;
                newCircleY = (circleY + lastDiameter) - diameter;
                
                g.setColor(new Color(36, 37, 38));
                g.drawRect(newCircleX + radius, newCircleY + radius, radius, radius);
                
                g.setColor(new Color(255, 215, 0));
                g.drawArc(newCircleX,newCircleY, diameter, diameter,270, 90);
            }
            
            if( (i % 4) == 3) {
                newCircleX = circleX;
                newCircleY = (circleY + lastRadius) - radius;
                
                g.setColor(new Color(36, 37, 38));
                g.drawRect(newCircleX, newCircleY + radius, radius, radius);
                
                g.setColor(new Color(255, 215, 0));
                g.drawArc(newCircleX,newCircleY, diameter, diameter,180, 90);
            }
            
            if( (i % 4) == 2) {
                newCircleX = (circleX + lastRadius) - radius;
                newCircleY = circleY;
                
                g.setColor(new Color(36, 37, 38));
                g.drawRect(newCircleX, newCircleY, radius, radius);
                
                g.setColor(new Color(255, 215, 0));
                g.drawArc(newCircleX,newCircleY, diameter, diameter,90, 90);
            }
            
            if( (i % 4) == 1) {
                newCircleX = (circleX + lastDiameter) - diameter;
                newCircleY = (circleY + lastRadius) - radius;
                
                g.setColor(new Color(36, 37, 38));
                g.drawRect(newCircleX + radius, newCircleY, radius, radius);
                
                g.setColor(new Color(255, 215, 0));
                g.drawArc(newCircleX, newCircleY, diameter, diameter, 0, 90);
            }
            circleX = newCircleX;
            circleY = newCircleY;
        }
    }
}
