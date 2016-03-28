import java.awt.*;
import java.awt.geom.*;
import java.util.Random; // Import all necassary packages.

/**
 * This program creates random sixe color, and number of balls in this class.
 * The balls bouncde within the boundaries of a box.
 * @author (Edward Pisco) 
 * @version (March 27, 2016)
 */

// Variable declaations.

public class BoxBall
{
    // instance variables 
    private int diameter;
    private Color color;
    private int xPosition;
    private int yPosition;
    private int ySpeed;                 
    private int xSpeed;                
    private Canvas canvas;
    private int x_Max;
    private int y_Max;
    private int minValue; 
    /**
     * Constructor for objects of class BoxBall
     * Random structure is used to create the balls woth random size, color and speed. 
     */
    public BoxBall(int xMax, int yMax, Canvas drawingCanvas, int offset)
    {
        // initialise Random generator
        Random generator = new Random();
        // generate random diameter
        diameter = generator.nextInt(20)+5;
        // generate random speed in x and y directions
        xSpeed = generator.nextInt(7)+1;
        ySpeed = generator.nextInt(7)+1;
        // generate random color
        int r = generator.nextInt(250);
        int g = generator.nextInt(250);
        int b = generator.nextInt(250);
        color = new Color(r, g, b);
        
        canvas = drawingCanvas;
        
        x_Max = xMax;
        y_Max = yMax;
        minValue = offset;
        
        // generate random coordinates of BoxBall object
        
        xPosition = generator.nextInt(xMax);
        yPosition = generator.nextInt(yMax);
    }
     /**
     * Method to erase ball at its current position.
     */
     public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
        
    }  
     /**
     * Method to draw ball at its current position onto the canvas.
     **/
     public void draw()
     {
      canvas.setForegroundColor(color);
      canvas.fillCircle(xPosition, yPosition, diameter);
    }   
    /**
     * Method for moving the ball so its directional speed changes when it hits a boundary. 
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();

        // set the speed ball
        xPosition+=xSpeed;
        yPosition+=ySpeed; 

        // bouncig the ball within the wall of the Box
        if (xPosition < minValue) {
            xPosition = diameter + minValue;
            xSpeed = -xSpeed;
        }
        if (xPosition > x_Max - diameter) {
            xPosition = x_Max - diameter;
            xSpeed = -xSpeed;
        }
        if (yPosition < minValue) {
            yPosition = diameter + minValue;
            ySpeed = -ySpeed;
        }
        if (yPosition > y_Max - diameter) {
            yPosition = y_Max - diameter;
            ySpeed = -ySpeed;
        }
    
        // draw again at new position
        draw();
    }
     /**
     * Mthod that returns the horizontal position of the ball
     */
       public int getXPosition()
       {
        return xPosition;
       }
     /**
     * Method that returns the vertical position of the ball
     */
       public int getyPosition()
       {
           return yPosition;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    