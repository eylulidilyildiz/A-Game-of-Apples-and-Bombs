import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JComponent; 


public class Apple extends JComponent implements InteractableDrawing {

    private static final int APPLE_SIZE = 15;
    private static final int DIMENSION_WIDTH = 500;
    private static final int DIMENSION_HEIGHT = 500;


    private int x;
    private int y;
    private Rectangle apple;


    public Apple()
    {
        Random randomInt = new Random();
        int xCoord = randomInt.nextInt(DIMENSION_WIDTH);
        int yCoord = randomInt.nextInt(DIMENSION_HEIGHT);
        x = xCoord - APPLE_SIZE;
        y = yCoord - APPLE_SIZE;
        apple = new Rectangle(xCoord, yCoord, APPLE_SIZE, APPLE_SIZE);
        Dimension dim = new Dimension(DIMENSION_WIDTH,DIMENSION_HEIGHT);
        setPreferredSize(dim);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect((int)apple.getX(),(int)apple.getY(),APPLE_SIZE,APPLE_SIZE);
        g.setColor(Color.RED);
        g.fillOval((int)apple.getX(),(int)apple.getY(),APPLE_SIZE,APPLE_SIZE); 
    }

    public boolean intersects(Ship s)
    {
        return apple.intersects(s.getShipShape());
    }

    public void interact(Ship s)
    {
        s.incrementScore();
    }


    public boolean moveLeft(int speed)
    {
        this.x = x - speed;
        
        if(this.x < 0)
        {
            return true;
        }
        else
        {
            apple.setLocation(x,y);
            repaint();
            return false;

        }
    }


    public void draw(Graphics g)
    {
        apple = new Rectangle(x,y,APPLE_SIZE,APPLE_SIZE);
        paintComponent(g);
    }
    
}
