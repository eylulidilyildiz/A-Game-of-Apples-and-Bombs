import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame{

    private String name;
    private double speed;

    private int lives;
    private int score;

    GameFrame(String nameInput, double speedInput)
    {
        name = nameInput;
        speed = speedInput;
        lives = 3;
        score = 0;
        setTitle("Life: " + lives + " Score: " + score);
        JPanel game = new GamePanel(this);
        add(game);

    }

    class GamePanel extends JPanel
    {
        public GamePanel(GameFrame frame)
        {

        }
    }
    
}
