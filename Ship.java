import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

/**
 * Ship
 */
public class Ship extends JComponent{

    private int x;
    private int y;
    private String shipName;

    private Rectangle ship;
    private static final int SHIP_WIDTH = 20;
    private static final int SHIP_HEIGHT = 10;

    public Ship()
    {
        ship = new Rectangle(x, y, SHIP_WIDTH, SHIP_HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        draw(g);
    }


    public void setLocation(int x, int y)
    {
        this.x = x;
        this.y = y;
        ship.setBounds(x, y, SHIP_WIDTH, SHIP_HEIGHT);
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, SHIP_WIDTH, SHIP_HEIGHT);
        g.drawString(shipName, x, y); 
    }

    public void setShipName(String name)
    {
        shipName = name;
    }
}
