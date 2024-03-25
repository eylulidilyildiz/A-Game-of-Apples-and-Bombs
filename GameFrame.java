import java.awt.Color;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameFrame extends JFrame{

    private String name;
    private double speed;

    private int lives;
    private int score;

    private static final int INITIAL_LIVES = 3;
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    private Ship ship;


    GameFrame(String nameInput, double speedInput)
    {
        name = nameInput;
        speed = speedInput;
        lives = INITIAL_LIVES;
        score = 0;

        ship = new Ship(name);

        setTitle("Life: " + lives + " Score: " + score);
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
    public double getSpeed()
    {
        return speed;
    }  
}
