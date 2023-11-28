package com.fun.fibonacci.GUI;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;

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
                int x = 0;
                for (int i = 1; i < fibonacciNumbers.length; i++){
                    if ( i % 4 == 2)
                    x += fibonacciNumbers[i];
                }
                startPointX = (int) (margin + (x * zoom) + zoom);
                
                int y = 0;
                for (int i = 1; i < fibonacciNumbers.length; i++){
                    if ( i % 4 == 3)
                    y += fibonacciNumbers[i];
                }
                startPointY = (int) (getHeight() - margin - (y * zoom));
            } else { //2
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
                startPointY = (int) (getHeight() - margin - (y * zoom));
            }

        } else {
            picSizeWidth = fibonacciNumbers[fibonacciNumbers.length - 1] * zoom;
            picSizeHeight = getHeight() - border;
            zoom = picSizeHeight / (fibonacciNumbers[fibonacciNumbers.length - 1] + fibonacciNumbers[fibonacciNumbers.length - 2]);

            if ((fibonacciNumbers.length - 1) % 4 == 3) { //3
                int x = 0;
                for (int i = 1; i < fibonacciNumbers.length; i++){
                    if ( i % 4 == 2)
                    x += fibonacciNumbers[i];
                }
                startPointX = (int) (margin + ((getWidth() - picSizeWidth)/2) + (x * zoom) + zoom);
                
                int y = 0;
                for (int i = 1; i < fibonacciNumbers.length; i++){
                    if ( i % 4 == 3)
                    y += fibonacciNumbers[i];
                }
                startPointY = (int) (getHeight() - margin - (y * zoom));
            } else { //1
                int x = 0;
                for (int i = 1; i < fibonacciNumbers.length; i++){
                    if ( i % 4 == 3)
                    x += fibonacciNumbers[i];
                }
                startPointX = (int) (margin + ((getWidth() - picSizeWidth)/2) + (x * zoom) - zoom);
                
                int y = 0;
                for (int i = 1; i < fibonacciNumbers.length; i++){
                    if ( i % 4 == 3)
                    y += fibonacciNumbers[i];
                }
                startPointY = (int) (getHeight() - margin - (y * zoom));
            }
        }

        Drawer draw = new Drawer(g, fibonacciNumbers, zoom, startPointX, startPointY);
        draw.drawSquares();
        draw.drawCircles();
        
        screenShot();
        
    }
    
    void screenShot() {
        try {
            Thread.sleep(1000);
            
            Robot robot = new Robot();
            
            int windowWidth = getWidth();
            int windowHeight = getHeight();

            // Képernyő mérete
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int screenWidth = screenSize.width;
            int screenHeight = screenSize.height;
            int x = (screenWidth - windowWidth) / 2;
            int y = (screenHeight - windowHeight) / 2;

            Rectangle rectangle = new Rectangle(x, y, windowWidth, windowHeight);
            BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
            
            String desktopPath = System.getProperty("user.home") + "\\Desktop";
            File file = new File(desktopPath, "jframe_screenshot.png");
            
            ImageWriteParam writeParam = ImageIO.getImageWritersByFormatName("png").next().getDefaultWriteParam();
            writeParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            writeParam.setCompressionQuality(1.0f); 
            ImageIO.write(bufferedImage, "png", file);

            System.out.println("Your Fibonacci Spiral is saved Succesfully: " + file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}