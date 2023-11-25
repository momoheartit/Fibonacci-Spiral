package com.fun.fibonacci;

import java.awt.BasicStroke;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
                
        int zoom;  
        double startPointX = (getWidth()/4)*3;
        double startPointY = getHeight()/2;
        double picSizeWidth = 0;
        double picSizeHeight = 0;
        
        if ((fibonacciNumbers.length-1) % 4 == 1 || (fibonacciNumbers.length-1) % 4 == 2) {
            zoom = (getWidth() - 30) / fibonacciNumbers[fibonacciNumbers.length-1];
            picSizeWidth = fibonacciNumbers[fibonacciNumbers.length-1] * zoom + fibonacciNumbers[fibonacciNumbers.length-2] * zoom;
            picSizeHeight = fibonacciNumbers[fibonacciNumbers.length-1] * zoom;
        } else {
            zoom = (getHeight()- 30) / fibonacciNumbers[fibonacciNumbers.length-1];
            picSizeWidth = fibonacciNumbers[fibonacciNumbers.length-1] * zoom;
            picSizeHeight = fibonacciNumbers[fibonacciNumbers.length-1] * zoom + fibonacciNumbers[fibonacciNumbers.length-2] * zoom;
            if ((fibonacciNumbers.length-1) % 4 == 3) {
                startPointX = (getWidth()/ 2) + (picSizeWidth/4);
                startPointY = (getHeight()/ 2) - (picSizeHeight/4 * 3);
            }
            
            
        }
        System.out.println("length: " + fibonacciNumbers.length);
        System.out.println("coordinates: " + picSizeWidth + ";" + picSizeHeight);
        System.out.println("zoom: " + zoom);
        
        
        // DRAWING THE SQUARES
        int squareX = (int) startPointX;
        int squareY = (int) startPointY;
        int newSquareX = squareX;
        int newSquareY = squareY;
        
        for (int j = 1; j <fibonacciNumbers.length; j++){
            g.setColor(new Color(36, 37, 38));
            
            Graphics2D g2d = (Graphics2D) g;
            float circleThickness = 0.8f;
            g2d.setStroke(new BasicStroke(circleThickness));
            
            int diameter = fibonacciNumbers[j]*zoom;
            int radius = diameter/2;
            int lastDiameter = fibonacciNumbers[j-1]*zoom;
            int lastRadius = lastDiameter/2;
            
            int fibonacciValue = fibonacciNumbers[j];
            int fontSize = radius / 4;
            Font font = new Font("Elephant", Font.PLAIN, fontSize);
            g.setFont(font);
            FontMetrics fontMetrics = g.getFontMetrics();
            int textX = (radius - fontMetrics.stringWidth(Integer.toString(fibonacciValue)) )/ 2;
            int textY = ((radius - fontMetrics.getAscent() )/ 2 ) + g.getFontMetrics().getAscent();
            

            if( (j % 4) == 0) {
                newSquareX = (squareX + lastRadius) - radius;
                newSquareY = (squareY + lastDiameter) - diameter;
                
                g.drawRect(newSquareX + radius, newSquareY + radius, radius, radius);
                g.drawString(Integer.toString(fibonacciValue), newSquareX + radius + textX, newSquareY + radius + textY);
            }
            
            if( (j % 4) == 3) {
                newSquareX = squareX;
                newSquareY = (squareY + lastRadius) - radius;
                
                g.drawRect(newSquareX, newSquareY + radius, radius, radius);
                g.drawString(Integer.toString(fibonacciValue), newSquareX + textX, newSquareY + radius + textY);
            }
            
            if( (j % 4) == 2) {
                newSquareX = (squareX + lastRadius) - radius;
                newSquareY = squareY;
                
                g.drawRect(newSquareX, newSquareY, radius, radius);
                g.drawString(Integer.toString(fibonacciValue), newSquareX + textX, newSquareY + textY);
            }
            
            if( (j % 4) == 1) {
                newSquareX = (squareX + lastDiameter) - diameter;
                newSquareY = (squareY + lastRadius) - radius;
                
                g.drawRect(newSquareX + radius, newSquareY, radius, radius);
                g.drawString(Integer.toString(fibonacciValue), newSquareX + + radius + textX, newSquareY + textY);
            }
            squareX = newSquareX;
            squareY = newSquareY;
        }
        
        // DRAWING THE CIRCLES
        int circleX = (int) startPointX;
        int circleY = (int) startPointY;
        int newCircleX = circleX;
        int newCircleY = circleY;
        
        for (int i = 1; i <fibonacciNumbers.length; i++){
            g.setColor(new Color(255, 215, 0));
            
            Graphics2D g2d = (Graphics2D) g;
            float circleThickness = 2.0f;
            g2d.setStroke(new BasicStroke(circleThickness));
            
            int diameter = fibonacciNumbers[i]*zoom;
            int radius = diameter/2;
            int lastDiameter = fibonacciNumbers[i-1]*zoom;
            int lastRadius = lastDiameter/2;
            
            if( (i % 4) == 0) {
                newCircleX = (circleX + lastRadius) - radius;
                newCircleY = (circleY + lastDiameter) - diameter;
                
                g.drawArc(newCircleX,newCircleY, diameter, diameter,270, 90);
            }
            
            if( (i % 4) == 3) {
                newCircleX = circleX;
                newCircleY = (circleY + lastRadius) - radius;
                
                g.drawArc(newCircleX,newCircleY, diameter, diameter,180, 90);
            }
            
            if( (i % 4) == 2) {
                newCircleX = (circleX + lastRadius) - radius;
                newCircleY = circleY;
                
                g.drawArc(newCircleX,newCircleY, diameter, diameter,90, 90);
            }
            
            if( (i % 4) == 1) {
                newCircleX = (circleX + lastDiameter) - diameter;
                newCircleY = (circleY + lastRadius) - radius;
                
                g.drawArc(newCircleX, newCircleY, diameter, diameter, 0, 90);
            }
            circleX = newCircleX;
            circleY = newCircleY;
        }
    }
}
