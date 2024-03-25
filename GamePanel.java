import java.awt.Color;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;

public class GamePanel extends JPanel
{

    private JComponent ship;
    private String shipName;
    private double componentSpeed;

    public GamePanel(GameFrame frame)
    {
        setBackground(Color.BLUE);

        shipName=frame.getName();
        componentSpeed = frame.getSpeed();
        createShip();
        MouseMotionListener listener = new ShipLocationListener();
        frame.addMouseMotionListener(listener);
        add(ship);



    }


    public void createShip()
    {
        ship = new Ship(shipName);
    }
    
    class ShipLocationListener implements MouseMotionListener
    {
        @Override
        public void mouseMoved(MouseEvent event) 
        {
            ship.setLocation(event.getX(), event.getY());
        }
        public void mouseDragged(MouseEvent e) {}
    }
}

