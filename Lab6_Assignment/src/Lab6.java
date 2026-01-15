//Name: Makiya Kirby
//Class Name and Section: CS 232 (Computer Programming II), Section 002
//Name of Program: Lab6.java
//Brief Description of Program: Uses JFrame, JPanel, GUI, ActionListener, actionPermored etc. to create a tic-tac-toe game
//Due Date: 10/17/22


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Create JFrame with title(Tic-Tac-Toe) and resultLabel & Create JPanel
public class Lab6 extends JFrame implements ActionListener {
    private JLabel resultLabel = new JLabel("ResultLabel");
    private JPanel p1 = new JPanel (new FlowLayout());
    public Lab6()
    {
        super("Tic-Tac-Toe");
        setLayout(new BorderLayout());
        p1.add(resultLabel);
        add(p1, BorderLayout.SOUTH);
   
        add(new BoardGame(), BorderLayout.CENTER);
    }
    //Create buttons and the layout of the buttons & disable a button after its clicked 
    class BoardGame extends JPanel implements ActionListener 
    {
        private final static int NBUTTONS = 9;
        private JButton squares[][];
        char playerSymbol = 'X';
        public BoardGame()
        {
            setLayout(new GridLayout(3,3));
           // JPanel squaresPanel;
           // squaresPanel = new JPanel(new GridLayout(3,3));
            squares = new JButton[NBUTTONS][NBUTTONS];
        
            for(int k = 0; k < squares.length; k++) 
            {
                squares[k][k] = new JButton();
                squares[k][k].addActionListener(this);
                squares[k][k].setName("Square " + k + k);
                squares[k][k].setPreferredSize(new Dimension(64,64));
                add(squares[k][k]);
                squares[k][k].setText("");
                squares[k][k].addActionListener(e -> {
                JButton clickOfButton = (JButton) e.getSource();
                clickOfButton.setText(String.valueOf(playerSymbol));
                clickOfButton.setEnabled(false);
                });
            }
            //add(squaresPanel);
        }
        //add "X" and "O" to each button when a player clicks a button & check for a winner after each click
        @Override
        public void actionPerformed(ActionEvent e)
        {
            boolean isGameOver = false;
            for (int k = 0; k < squares.length; k++) 
            {
            
                if (playerSymbol == 'X')
                {
                    playerSymbol = 'O';
                }
                else
                {
                    playerSymbol = 'X';
                }
                //Horizontal check for winner
                if ("X".equals(squares[0][0].getText()) && "X".equals(squares[1][1].getText()) && "X".equals(squares[2][2].getText()))
                {
                   resultLabel.setText("X wins");
                   p1.add(resultLabel);
                   isGameOver = true;
                }
                if ("O".equals(squares[0][0].getText()) && "O".equals(squares[1][1].getText()) && "O".equals(squares[2][2].getText()))
                {
                    resultLabel.setText("O wins");
                    p1.add(resultLabel);
                    isGameOver = true;
                }               
                if ("X".equals(squares[3][3].getText()) && "X".equals(squares[4][4].getText()) && "X".equals(squares[5][5].getText()))
                {
                   resultLabel.setText("X wins");
                   p1.add(resultLabel);
                   isGameOver = true;
                }
                if ("O".equals(squares[3][3].getText()) && "O".equals(squares[4][4].getText()) && "O".equals(squares[5][5].getText()))
                {
                   resultLabel.setText("O wins");
                   p1.add(resultLabel);
                   isGameOver = true;
                }
                if ("X".equals(squares[6][6].getText()) && "X".equals(squares[7][7].getText()) && "X".equals(squares[8][8].getText()))
                {
                   resultLabel.setText("X wins");
                   p1.add(resultLabel);
                   isGameOver = true;
                }
                if ("O".equals(squares[6][6].getText()) && "O".equals(squares[7][7].getText()) && "O".equals(squares[8][8].getText()))
                {
                   resultLabel.setText("O wins");
                   p1.add(resultLabel);
                   isGameOver = true;
                }
                //Vertical check for winner
                if ("X".equals(squares[0][0].getText()) && "X".equals(squares[3][3].getText()) && "X".equals(squares[6][6].getText()))
                {
                   resultLabel.setText("X wins");
                   p1.add(resultLabel);
                   isGameOver = true;
                }
                if ("O".equals(squares[0][0].getText()) && "O".equals(squares[3][3].getText()) && "O".equals(squares[6][6].getText()))
                {
                   resultLabel.setText("O wins");
                   p1.add(resultLabel);
                   isGameOver = true;
                }
                if ("X".equals(squares[1][1].getText()) && "X".equals(squares[4][4].getText()) && "X".equals(squares[7][7].getText()))
                {
                   resultLabel.setText("X wins");
                   p1.add(resultLabel);
                   isGameOver = true;
                }
                if ("O".equals(squares[1][1].getText()) && "O".equals(squares[4][4].getText()) && "O".equals(squares[7][7].getText()))
                {
                   resultLabel.setText("O wins");
                   p1.add(resultLabel);
                   isGameOver = true;
                }
                if ("X".equals(squares[2][2].getText()) && "X".equals(squares[5][5].getText()) && "X".equals(squares[8][8].getText()))
                {
                   resultLabel.setText("X wins");
                   p1.add(resultLabel);
                   isGameOver = true;
                }
                if ("O".equals(squares[2][2].getText()) && "O".equals(squares[5][5].getText()) && "O".equals(squares[8][8].getText()))
                {
                   resultLabel.setText("O wins");
                   p1.add(resultLabel);
                   isGameOver = true;
                }
                //Diagonal check for winner
                if ("X".equals(squares[0][0].getText()) && "X".equals(squares[4][4].getText()) && "X".equals(squares[8][8].getText()))
                {
                   resultLabel.setText("X wins");
                   p1.add(resultLabel);
                   isGameOver = true;
                }
                if ("O".equals(squares[0][0].getText()) && "O".equals(squares[4][4].getText()) && "O".equals(squares[8][8].getText()))
                {
                   resultLabel.setText("O wins");
                   p1.add(resultLabel);
                   isGameOver = true;
                }
                if ("X".equals(squares[2][2].getText()) && "X".equals(squares[4][4].getText()) && "X".equals(squares[6][6].getText()))
                {
                   resultLabel.setText("X wins");
                   p1.add(resultLabel);
                   isGameOver = true;
                }
                if ("O".equals(squares[2][2].getText()) && "O".equals(squares[4][4].getText()) && "O".equals(squares[6][6].getText()))
                {
                   resultLabel.setText("O wins");
                   p1.add(resultLabel);
                   isGameOver = true;
                }
                //Disable all buttons after winner is determined
                if (isGameOver == true)
                {
                    squares[k][k].setEnabled(false);
                }
            }    
        }
    }
    
    //Tie result attempt
    @Override
    public void actionPerformed(ActionEvent e)
    {
        /*
        if(isGameOver != true)
        {
            resultLabel.setText("Tie");
        p1.add(resultLabel);
        }
        */
    }

    //Display main JPanel & close option
    public static void main(String args[]) 
    {
        Lab6 win = new Lab6(); 
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      //win.add(); 
        win.pack();
        win.setSize(300, 300);
        win.setVisible(true);
    }
    
    /*
    int total = 0;
   public void sum_n(int n, int a_total)
   {
       if (n == 1)
   {
       return(total = total + 1)
   }
   }
   if (n == 1)
   {
       return(total = total + 1)
   }
   */
    
   
    
  }


