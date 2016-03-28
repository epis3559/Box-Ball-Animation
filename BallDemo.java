import java.awt.Color;
import javax.swing.plaf.ColorUIResource;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 * boxBounce method was added to have balls bounce inside a box within Canvas.
 * BoxBall class was created to build the playing area.
 * @author Edward Pisco
 * @version 2015.24.16
 */
public class BallDemo   
{
    private Canvas myCanvas;
    private final int WIDTH = 600;
    private final int HEIGHT = 500;
    private final Color COLOR = Color.BLUE; // added color to background
    
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", WIDTH, HEIGHT, COLOR);
    }

    /**
     * Simulate bouncing balls
     */
    public void bounce()
    {
        
        int ground = 450;   // position of the ground line

        myCanvas.drawLine(50, ground, 550, ground); // draw the ground

        // create and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.YELLOW, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.YELLOW, ground, myCanvas);
        ball2.draw();

        boolean finished =  false;
        
        while(!finished) {
            myCanvas.wait(50); // small delay
            ball.move();
            ball2.move();
            
        // stop once ball has traveelled a certain distance on x axis.
          if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
     /**
     * Method boxBounce is creatd and responsible for drawing four boundaries within the canvas so that BoxBall objects 
     * can bounce only inside the boundaries.
     * Bouncing is controlled by a timer.
     * @param numberOfBalls to specify how many balls are in the box.
     * @param offset value to set the boundaries of the box
     */

    public void boxBounce(int numberOfBalls, int offset)
    {
        myCanvas.erase();   
        myCanvas.setVisible(true);
        final int OFFSET = offset; 
        final int X_MAX = WIDTH - OFFSET;
        final int Y_MAX = HEIGHT - OFFSET;

        //Create BoxBall objects array
        BoxBall[] balls = new BoxBall[numberOfBalls];

        // Array of balls
        for (int i=0; i<balls.length; i++) 
        {
            balls[i] = new BoxBall(X_MAX, Y_MAX, myCanvas, OFFSET);
        }

        //Bounce the balls
        int timer=0;       
        while (timer<250)
        {
            myCanvas.wait(70); // small delay
            
            myCanvas.drawLine(OFFSET, OFFSET, X_MAX, OFFSET);   //top boundary
            myCanvas.drawLine(X_MAX, OFFSET, X_MAX, Y_MAX);     //right boundary
            myCanvas.drawLine(OFFSET, Y_MAX, X_MAX, Y_MAX);     //bottom boundary
            myCanvas.drawLine(OFFSET, OFFSET, OFFSET, Y_MAX);   //left boundary

            for (int i=0; i<balls.length; i++)    //bounce balls Iterrations
            {
                balls[i].move();
            }
             
            timer++;
        }
    }
}
    
    
    
    
        