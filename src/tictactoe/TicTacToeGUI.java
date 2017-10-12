
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;

public class TicTacToeGUI implements ActionListener 
{
    private JFrame game = new JFrame("Tic-Tac-Toe");
    JButton[] button = new JButton[9];
    private JButton button9 = new JButton("Play Again");
    private JTextField XScore;
    private JTextField OScore;
    private String letter = "";
    private int count = 0;
    public int XWins, OWins = 0;
    private boolean win = false;
    private boolean displayedMessage;
    
    public TicTacToeGUI() 
    {
        this.OScore = new JTextField("Player O's Score = " + OWins++);
        this.XScore = new JTextField("Player X's Score = " + XWins++);
        game.setSize(400, 300);
        game.setLayout(new GridLayout(4,3));
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
        game.add(button9);
        game.add(XScore);
        game.add(OScore);
        button9.addActionListener(this);
         TicTacToeGUI referenceToGui;

        JButton jbutton = new JButton("");
        Font font = jbutton.getFont();
        Font bigFont = font.deriveFont(font.getSize2D() * 5.0f);

        for (int i = 0; i < 9; i++) {
            button[i] = new JButton("");
            button[i].setFont(bigFont);
            button[i].addActionListener(this);
            game.add(button[i]);
        }

        game.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        count++;
        if (count == 1 || count == 3 || count == 5 || count == 7 || count == 9) 
        {
            letter = "X";
        } 
        else if (count == 2 || count == 4 || count == 6 || count == 8 || count == 10) 
        {
            letter = "O";
        }

        if (e.getSource() == button[0]) 
        {
            button[0].setText(letter);
            button[0].setEnabled(false);
        }
        else if (e.getSource() == button[1]) 
        {
            button[1].setText(letter);
            button[1].setEnabled(false);

        } else if (e.getSource() == button[2])
        {
            button[2].setText(letter);
            button[2].setEnabled(false);
        }
        else if (e.getSource() == button[3]) 
        {
            button[3].setText(letter);
            button[3].setEnabled(false);
        } 
        else if (e.getSource() == button[4])
        {
            button[4].setText(letter);
            button[4].setEnabled(false);
        }
        else if (e.getSource() == button[5])
        {
            button[5].setText(letter);
            button[5].setEnabled(false);
        }
        else if (e.getSource() == button[6])
        {
            button[6].setText(letter);
            button[6].setEnabled(false);
        }
        else if (e.getSource() == button[7]) 
        {
            button[7].setText(letter);
            button[7].setEnabled(false);
        }
        else if (e.getSource() == button[8])
        {
            button[8].setText(letter);
            button[8].setEnabled(false);
        }
        else if (e.getSource() == button9)
        {
            int answer = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Confirm", JOptionPane.YES_NO_OPTION);
            
            if (answer == JOptionPane.NO_OPTION)
            {
                System.exit(0);
            } 
            else 
            {
                reset();
                count = 0;
            }

        } 
        else if (e.getSource() == XScore) 
        {
            JOptionPane.showMessageDialog(null, "Player X's number of Wins" + " " + Scores());
        }
        else if (e.getSource() == OScore)
        {
            JOptionPane.showMessageDialog(null, "Player O's number of Wins" + " " + Scores());
        }

       //horizontal wins
        if (button[0].getText() == button[1].getText() && button[1].getText() == button[2].getText() && button[0].getText() != "") 
        {
            win = true;
        }
        else if (button[3].getText() == button[4].getText() && button[4].getText() == button[5].getText() && button[3].getText() != "")
        {
            win = true;
        } 
        else if (button[6].getText() == button[7].getText() && button[7].getText() == button[8].getText() && button[6].getText() != "")
        {
            win = true;
        }
        //virticle wins
        else if (button[0].getText() == button[3].getText() && button[3].getText() == button[6].getText() && button[0].getText() != "")
        {
            win = true;
        }
        else if (button[1].getText() == button[4].getText() && button[4].getText() == button[7].getText() && button[1].getText() != "") 
        {
            win = true;
        } 
        else if (button[2].getText() == button[5].getText() && button[5].getText() == button[8].getText() && button[2].getText() != "") 
        {
            win = true;
        }
        //diagonal wins
        else if (button[0].getText() == button[4].getText() && button[4].getText() == button[8].getText() && button[0].getText() != "")
        {
            win = true;
        } 
        else if (button[2].getText() == button[4].getText() && button[4].getText() == button[6].getText() && button[2].getText() != "")
        {
            win = true;
        }
        else 
        {
            win = false;
        }
       if (win == true)
        {
        	if(!displayedMessage)
                {
	            JOptionPane.showMessageDialog(null, letter +" " + "Wins!");
	            displayedMessage = true;
	            if(letter.equals("X"))
	            	XWins++;
	            else
	            	OWins++;
        	}

        }
        else if (count == 9 && win == false)
        {
        	if(!displayedMessage)
                {
	            JOptionPane.showMessageDialog(null, "Tie game!!");
	            displayedMessage = true;
        	}
        }
    }

    int Scores()
    {
        if (letter.equals("X"))
        {
            XWins++;
            return XWins; 
        }
        else
        {
            OWins++;
            return OWins;
        }
    }

    public void reset()
    {
        button[0].setText("");
        button[0].setEnabled(true);
        button[1].setText("");
        button[1].setEnabled(true);
        button[2].setText("");
        button[2].setEnabled(true);
        button[3].setText("");
        button[3].setEnabled(true);
        button[4].setText("");
        button[4].setEnabled(true);
        button[5].setText("");
        button[5].setEnabled(true);
        button[6].setText("");
        button[6].setEnabled(true);
        button[7].setText("");
        button[7].setEnabled(true);
        button[8].setText("");
        button[8].setEnabled(true);
        button9.setText("Play Again");
        button9.setEnabled(true);
        win = false;
        count = 0;
    }
 
    public static void main(String args[]) 
    {
        TicTacToeGUI tictactoeGUI = new TicTacToeGUI();
         Mp3Player mp3 = new Mp3Player("GameMusic.mp3");
         mp3.play();
         //http://www.hubberspot.com/2012/09/how-to-play-mp3-file-in-java.html
    }
}
