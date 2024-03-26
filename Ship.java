import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Ship
 */
public class Ship extends JComponent{

    private int x;
    private int y;
    private String shipName;

    private Rectangle ship;
    private static final int SHIP_WIDTH = 50;
    private static final int SHIP_HEIGHT = 25;

    @Override
    protected void paintComponent(Graphics g) 
    {
        ship = new Rectangle(x, y, SHIP_WIDTH, SHIP_HEIGHT);
        draw(g);

    }



    public Ship(String name)
    {
        shipName = name;
        Dimension dim = new Dimension(500,500);
        setPreferredSize(dim);
    }

    public void setLoc(int newX, int newY)
    {
        this.x = newX;
        this.y = newY;
        ship.setLocation(newX, newY);
        repaint();
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.YELLOW);
        g.fillRect((int)ship.getX(), (int)ship.getY(), SHIP_WIDTH, SHIP_HEIGHT);
        g.setColor(Color.BLACK);
        g.drawString(shipName, ((int)ship.getX() + SHIP_WIDTH / 4), ((int)ship.getY() + SHIP_HEIGHT * 3 / 4)); 

    }

    public void setShipName(String name)
    {
        shipName = name;
    }

    public Rectangle getShip()
    {
        return ship;
    } 
}
