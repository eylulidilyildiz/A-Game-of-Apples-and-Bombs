import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;

public class GamePanel extends JPanel
{

    private Ship ship;
    private String shipName;
    private double componentSpeed;

    public GamePanel(GameFrame frame, Ship sh)
    {
        this.ship = sh;
        shipName=frame.getName();
        componentSpeed = frame.getSpeed();
        setPreferredSize(new Dimension(500,500));
        add(ship);
        MouseMotionListener listener = new ShipLocationListener();
        ship.addMouseMotionListener(listener);

        setBackground(Color.BLUE);

    }
    class ShipLocationListener implements MouseMotionListener
    {
        @Override
        public void mouseMoved(MouseEvent event) 
        {
            int newX = event.getX();
            int newY = event.getY();
            ship.setLoc(newX, newY);
        }
        public void mouseDragged(MouseEvent e) {}
    }


    public void createShip()
    {
        ship = new Ship(shipName);
    }
    

}

