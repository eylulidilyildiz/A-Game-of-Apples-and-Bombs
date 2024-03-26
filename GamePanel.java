import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GamePanel extends JPanel
{
    private final int NUMBER_OF_APPLES;
    private final int NUMBER_OF_BOMBS;
    private final int WIDTH_OF_PANEL;
    private final int HEIGHT_OF_PANEL;

    private Ship ship;
    private ArrayList <InteractableDrawing> applesAndBombs; 

    private String shipName;
    private int componentSpeed;

    public GamePanel(GameFrame frame, Ship sh)
    {
        Random randomInt = new Random();
        NUMBER_OF_APPLES = randomInt.nextInt(10,15);
        NUMBER_OF_BOMBS  = randomInt.nextInt(7,10);
        WIDTH_OF_PANEL = 500;
        HEIGHT_OF_PANEL = 500;

        applesAndBombs = new ArrayList<InteractableDrawing>();

        this.ship = sh;
        shipName=frame.getName();
        componentSpeed = frame.getSpeed();
        setPreferredSize(new Dimension(500,500));

        for (int i = 0; i < NUMBER_OF_APPLES; i++)
        {
            Apple apple = new Apple();
            applesAndBombs.add(apple);
        }


        add(ship);
        MouseMotionListener mListener = new ShipLocationListener();
        ship.addMouseMotionListener(mListener);

        setBackground(Color.BLUE);

        TimerListener tListener = new TimerListener();
        Timer t = new Timer(50, tListener);
        t.start();

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

    class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            for(InteractableDrawing component: applesAndBombs)
            {
                if(component.moveLeft(componentSpeed))
                {              
                    applesAndBombs.remove(component);
                    Apple newApple = new Apple();
                    applesAndBombs.add(newApple);
                    repaint();
                }
            }
            /*for(Bomb bomb: bombs)
            {
                if(bomb.moveLeft(componentSpeed))
                {
                    bombs.remove(bomb);
                }
            }*/

        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(InteractableDrawing component: applesAndBombs)
        {
            component.draw(g);
        }
        ship.draw(g);
    }
    

}

