import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent; 


public class Apple extends JComponent implements InteractableDrawing {

    private static final int TOTAL_AMOUNT_OF_APPLES = 10;

    private static final int APPLE_SIZE = 15;
    private static final int INITIAL_X = 500 - APPLE_SIZE;

    private int x;
    private int y;
    private Rectangle apple;


    public Apple(int xCoord, int yCoord)
    {
        x = xCoord;
        y = yCoord;
        Dimension dim = new Dimension(500,500);
        setPreferredSize(dim);
    }

    @Override
    protected void paintComponent(Graphics g) {
        apple = new Rectangle(x,y,APPLE_SIZE,APPLE_SIZE);
        draw(g);
    }

    public boolean intersects(Ship s)
    {

    }

    public void interact(Ship s)
    {

    }


    public boolean moveLeft(int speed)
    {

    }


    public void draw(Graphics g)
    {
        g.setColor(Color.GRAY);
        g.fillRect((int)apple.getX(),(int)apple.getY(),APPLE_SIZE,APPLE_SIZE);
        g.setColor(Color.RED);
        g.fillOval((int)apple.getX(),(int)apple.getY(),APPLE_SIZE,APPLE_SIZE); 
    }
    
}
