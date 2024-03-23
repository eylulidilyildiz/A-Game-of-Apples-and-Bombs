import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Ship
 */
public class Ship {

    private int x;
    private int y;
    private Rectangle ship;
    private static final int SHIP_WIDTH = 20;
    private static final int SHIP_HEIGHT = 10;

    public Ship()
    {
        ship = new Rectangle(x, y, SHIP_WIDTH, SHIP_WIDTH);
    }

    class ShipLocationListener implements MouseMotionListener
    {
        @Override
        public void mouseMoved(MouseEvent event) 
        {
            setLocation(event.getX(), event.getY());
        }

        public void mouseDragged(MouseEvent e) {}
    }

    public void setLocation(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
