import java.awt.Color;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameFrame extends JFrame{

    private String name;
    private int speed;

    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    private Ship ship;


    GameFrame(String nameInput, int speedInput)
    {
        name = nameInput;
        speed = speedInput;

        ship = new Ship(name);

        setTitle("Life: " + ship.getRemainingLives() + " Score: " + ship.getScore());
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        GamePanel game = new GamePanel(this, ship);
        add(game);
        setVisible(true);
    }


      //Getters
    public String getName()
    {
        return name;
    }
    public int getSpeed()
    {
        return speed;
    }  
}
