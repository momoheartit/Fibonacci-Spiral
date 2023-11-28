package com.fun.fibonacci.GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Drawer {

    private Graphics g;
    private int[] fibonacciNumbers;
    private double zoom;
    private int startPointX;
    private int startPointY;
        
    public Drawer(Graphics g, int[] fibonacciNumbers, double zoom, int startPointX, int startPointY) {
        this.g = g;
        this.fibonacciNumbers = fibonacciNumbers;
        this.zoom = zoom;
        this.startPointX = startPointX;
        this.startPointY = startPointY;
        
    }

    public void drawSquares() {
        int squareX = (int) startPointX;
        int squareY = (int) startPointY;
        int newSquareX = squareX;
        int newSquareY = squareY;

        for (int j = 1; j < fibonacciNumbers.length; j++) {
            g.setColor(new Color(36, 37, 38));

            Graphics2D g2d = (Graphics2D) g;
            float circleThickness = 0.8f;
            g2d.setStroke(new BasicStroke(circleThickness));

            int diameter = (int) ((fibonacciNumbers[j] * zoom) * 2);
            int radius = diameter / 2;
            int lastDiameter = (int) ((fibonacciNumbers[j - 1] * zoom) * 2);
            int lastRadius = lastDiameter / 2;

            int fibonacciValue = fibonacciNumbers[j];
            int fontSize = radius / 4;
            Font font = new Font("Elephant", Font.PLAIN, fontSize);
            g.setFont(font);
            FontMetrics fontMetrics = g.getFontMetrics();
            int textX = (radius - fontMetrics.stringWidth(Integer.toString(fibonacciValue))) / 2;
            int textY = ((radius - fontMetrics.getAscent()) / 2) + g.getFontMetrics().getAscent();

            if ((j % 4) == 0) {
                newSquareX = (squareX + lastRadius) - radius;
                newSquareY = (squareY + lastDiameter) - diameter;

                g.drawRect(newSquareX + radius, newSquareY + radius, radius, radius);
                g.drawString(Integer.toString(fibonacciValue), newSquareX + radius + textX, newSquareY + radius + textY);
            }

            if ((j % 4) == 3) {
                newSquareX = squareX;
                newSquareY = (squareY + lastRadius) - radius;

                g.drawRect(newSquareX, newSquareY + radius, radius, radius);
                g.drawString(Integer.toString(fibonacciValue), newSquareX + textX, newSquareY + radius + textY);
            }

            if ((j % 4) == 2) {
                newSquareX = (squareX + lastRadius) - radius;
                newSquareY = squareY;

                g.drawRect(newSquareX, newSquareY, radius, radius);
                g.drawString(Integer.toString(fibonacciValue), newSquareX + textX, newSquareY + textY);
            }

            if ((j % 4) == 1) {
                newSquareX = (squareX + lastDiameter) - diameter;
                newSquareY = (squareY + lastRadius) - radius;

                g.drawRect(newSquareX + radius, newSquareY, radius, radius);
                g.drawString(Integer.toString(fibonacciValue), newSquareX + radius + textX, newSquareY + textY);
            }
            squareX = newSquareX;
            squareY = newSquareY;
        }
    }

    public void drawCircles() {
        int circleX = (int) startPointX;
        int circleY = (int) startPointY;
        int newCircleX = circleX;
        int newCircleY = circleY;

        for (int i = 1; i < fibonacciNumbers.length; i++) {
            g.setColor(new Color(255, 215, 0));

            Graphics2D g2d = (Graphics2D) g;
            float circleThickness = 2.0f;
            g2d.setStroke(new BasicStroke(circleThickness));

            int diameter = (int) ((fibonacciNumbers[i] * zoom) * 2) ;
            int radius = diameter / 2;
            int lastDiameter = (int) ((fibonacciNumbers[i - 1] * zoom) * 2);
            int lastRadius = lastDiameter / 2;

            if ((i % 4) == 0) {
                newCircleX = (circleX + lastRadius) - radius;
                newCircleY = (circleY + lastDiameter) - diameter;
                
                g.drawArc(newCircleX, newCircleY, diameter, diameter, 270, 90);
            }

            if ((i % 4) == 3) {
                newCircleX = circleX;
                newCircleY = (circleY + lastRadius) - radius;
                
                g.drawArc(newCircleX, newCircleY, diameter, diameter, 180, 90);
            }

            if ((i % 4) == 2) {
                newCircleX = (circleX + lastRadius) - radius;
                newCircleY = circleY;
                
                g.drawArc(newCircleX, newCircleY, diameter, diameter, 90, 90);
            }

            if ((i % 4) == 1) {
                newCircleX = (circleX + lastDiameter) - diameter;
                newCircleY = (circleY + lastRadius) - radius;
                
                g.drawArc(newCircleX, newCircleY, diameter, diameter, 0, 90);
            }
            circleX = newCircleX;
            circleY = newCircleY;
        }
    }
}
