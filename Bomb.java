import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JComponent; 


public class Bomb extends JComponent implements InteractableDrawing {

    private static final int BOMB_SIZE = 15;
    private static final int DIMENSION_WIDTH = 500;
    private static final int DIMENSION_HEIGHT = 500;


    private int x;
    private int y;
    private Rectangle bomb;


    public Bomb()
    {
        Random randomInt = new Random();
        int xCoord = randomInt.nextInt(DIMENSION_WIDTH*3/4, DIMENSION_WIDTH);
        int yCoord = randomInt.nextInt(DIMENSION_HEIGHT);
        x = xCoord - BOMB_SIZE;
        y = yCoord - BOMB_SIZE;
        bomb = new Rectangle(xCoord, yCoord, BOMB_SIZE, BOMB_SIZE);
        Dimension dim = new Dimension(DIMENSION_WIDTH,DIMENSION_HEIGHT);
        setPreferredSize(dim);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int)bomb.getX(),(int)bomb.getY(),BOMB_SIZE,BOMB_SIZE);
        g.setColor(Color.BLACK);
        g.fillOval((int)bomb.getX(),(int)bomb.getY(),BOMB_SIZE,BOMB_SIZE); 
    }

    public boolean intersects(Ship s)
    {
        return bomb.intersects(s.getShipShape());
    }

    public void interact(Ship s)
    {
        s.loseHealth();
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
            bomb.setLocation(x,y);
            repaint();
            return false;

        }
    }


    public void draw(Graphics g)
    {
        bomb = new Rectangle(x,y,BOMB_SIZE,BOMB_SIZE);
        paintComponent(g);
    }
    
}

