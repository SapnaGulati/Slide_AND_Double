/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide_And_double;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author ADMIN
 */
public class Instructions implements ActionListener
{
    JFrame frame;
    JButton button;
    JLabel l;
    JTextArea t;
    JScrollPane s;
    
    Instructions()
    {
        frame=new JFrame();
        button=new JButton("Tap to Continue");
        t=new JTextArea(460,380);
        s=new JScrollPane(t);
        l=new JLabel();
        frame.setLayout(null);
        frame.setTitle("How To Play");
        frame.setSize(500,500);
        frame.setLocation(700,300);
        button.setBounds(170,400,140,25);
        button.addActionListener(this);
        t.setRows(5);
        t.setColumns(25);
        t.setBounds(10,10,460,380);
        t.setLineWrap(true);
        t.setEditable(false);
        t.setVisible(true);
        t.setFont(new java.awt.Font("Times New Roman", 1, 13));
        t.setBackground(new java.awt.Color(51, 51, 0));
        t.setForeground(new java.awt.Color(153, 255, 255));
        t.setText(" \t Welcome to the game \"Slide Nand Double Just 12.\" \n \n        In this game you have to combine the number from 2 to 4096 by pressing the arrow keys only. It is online game and the users will assigned the scores and the score-list will provide the rank according to your marks. \n\nHow To Play:-\n-At starting you have to signup in the game and then log-in into the login page \n with the e-mail and the password. \n-Then the game will start and the frame appears with a random number either 2 \n or 4.\n-Then you have to combine the numbers using arrow keys. \n-If you will press the left key, then the numbers will move to the left and if two \n similar numbers will be there, they will combine and becomes the double of that \n number. \n-Similarly other arrow keys i.e. right,up and down will work and merge the \n similar numbers. \n-If all the boxes will be filled and there are no numbers that can be merged \n together, then the game will be finished and you will lose. \n-If the 4096 number you got by merging the numbers, then you will win the game and got the rank in the list. \n-You will also able to know your scores side by side. \n-You just have to concentrate on the moves and only combine the numbers and also the high scores.\n\nRules & Regulations:-\n-If you combine a number with the other, you will get 2 marks for each merging. \n-If all the boxes will be filled and no more move will be there, you will lose. \n\nMeaning of \'Slide Nand Double Just 12\'-\n-\'Slide Nand Double\' is the name of the game which indicates that you have to do \n slide the numbers by using some arrow keys only and you will get the double of \n that number. \n-The word \'Nand\' is there because either you will get the double of the numbers if there will be the similar numbers else you just slide and not any number will be \n merged. Similarly,\'Nand\' gate works. \n- As you know that the name of the game contains \'just 12\', so Just 12 is added \n here, because in this game, you have to combine the numbers until you get the \n 4096 number. And as we all knows that the 4096 is equal to the 10^12. So, \'just 12\' is the technical word used for the number \'4096\'.\n\n          I hope you understand all the process of the game. So, \"All The Best\" and \n Let's play the game.");
        s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        s.setBounds(10,10,460,380);
        l.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\445q.gif"));
        l.setBounds(0,0,500,500);
        frame.add(button);
        frame.add(s);
        frame.add(l);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] arg)
    {
        new Instructions();
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        String name=ae.getActionCommand();
        if(name.equals("Tap to Continue"))
        {
           new Welcome();
           frame.dispose();
        }
    }
}

