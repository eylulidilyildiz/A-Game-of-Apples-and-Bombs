import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;


public class MenuFrame extends JFrame
{
    private static final int MENU_FRAME_WIDTH = 300;
    private static final int MENU_FRAME_HEIGHT = 300;

    private JLabel nameLabel;
    private JLabel speedLabel;
    private JTextField nameField;
    private JTextField speedField;
    private JButton startButton;

    private String nameOfUser;
    private int speedOfUser;


    public MenuFrame()
    {
        setTitle("Ship Game");
        setSize(MENU_FRAME_WIDTH, MENU_FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(3, 1));
        add(createNamePanel());
        add(createSpeedPanel());

        createStartButton();
        add(startButton);

        setVisible(true);
    }

    //CREATE PANELS

    /**
     * 
     * @return
     */
    public JPanel createNamePanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));
        nameLabel = new JLabel("Name: ");
        panel.add(nameLabel);
        createNameField();
        panel.add(nameField);
        return panel;
    }

    /**
     * 
     * @return
     */
    public JPanel createSpeedPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));
        speedLabel = new JLabel("Speed: ");
        panel.add(speedLabel);

        createSpeedField();
        panel.add(speedField);
        return panel;
    }


    //CREATE COMPONENTS FOR PANELS

    public void createNameField()
    {
        final int TEXT_FIELD_WIDTH = 20;
        nameField = new JTextField(TEXT_FIELD_WIDTH);
        nameField.setEditable(true);
    }


    public void createSpeedField()
    {
        final int TEXT_FIELD_WIDTH = 20;
        speedField = new JTextField(TEXT_FIELD_WIDTH);
        speedField.setEditable(true);
    }


    public void createStartButton()
    {
        startButton = new JButton("Start");
        ActionListener listener = new StartButtonListener();
        startButton.addActionListener(listener);
    }


    class StartButtonListener implements ActionListener
    {
        @Override
        /**Clicking on the start button should hide this frame 
         * and open a different one that displays the game. 
         * 
         * Gives appropriate warning messages if any of the inputs are empty 
         * or the speed input includes non-numeric characters. 
         */
        public void actionPerformed(ActionEvent e) 
        {
            if(!isNameFieldEmpty() && !isSpeedFieldEmpty() && isSpeedValid())
            {
                //GAME STARTS
                nameOfUser = nameField.getText();
                speedOfUser = Integer.parseInt(speedField.getText());
                JFrame game = new GameFrame(nameOfUser, speedOfUser);
                setVisible(false);
            }
            else{
                handleInvalidInput();
            }      
        }
    }

    public void handleInvalidInput()
    {
        String warningMessage = "";

        if(isNameFieldEmpty())
        {
            warningMessage += "Name cannot be empty!\n";
        }
        if(isSpeedFieldEmpty())
        {
            warningMessage += "Speed cannot be empty!\n";
        }
        else if(!isSpeedValid())
        {
            warningMessage += "Speed should be only numbers!";
        }
        JOptionPane.showMessageDialog(this, warningMessage);
    }


    //Checking TextField inputs
    public boolean isNameFieldEmpty()
    {
        return (nameField.getText().equals(""));
    }

    public boolean isSpeedFieldEmpty()
    {
        return (speedField.getText().equals(""));
    }

    public boolean isSpeedValid()
    {
        String speed = speedField.getText();
        boolean speedIsValid = true;
        for(int i = 0; i < speed.length(); i++)
        {
            if(!Character.isDigit(speed.charAt(i)))
            {
                speedIsValid = false;
                break;
            }
        }
        return speedIsValid;
    }
    
}
