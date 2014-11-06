package Windowing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class OverUnder extends JFrame {

    int round = 1;
    int rand1, rand2, rand3, rand4;
    JLabel label1, label2, label3, label4, or, winOrLose;
    JButton higher, lower;
    JMenuBar menubar;
    JMenu file;
    JMenuItem rule, reset, exit;
    
    public OverUnder() {
        rand1 = (int)(Math.random() * 20 + 1);
        
        Font font = new Font("Serif", Font.BOLD, 16);
        
        setLayout(new GridLayout(3, 1));
        
        menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        file = new JMenu("Menu");
        menubar.add(file);
        
        rule = new JMenuItem("Rules");
        file.add(rule);
        
        reset = new JMenuItem("Restart");
        file.add(reset);
        
        exit = new JMenuItem("Quit");
        file.add(exit);
        
        ruleBook rb = new ruleBook();
        rule.addActionListener(rb);
        
        systemClose s = new systemClose();
        exit.addActionListener(s);
        
        restartGame r = new restartGame();
        reset.addActionListener(r);
        
        Container pane = this.getContentPane();
        
        //top panel setup
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(1, 4));
        
        label1 = new JLabel("" + rand1, SwingConstants.CENTER);
        label1.setFont(font);
        top.add(label1);
        
        label2 = new JLabel("", SwingConstants.CENTER);
        label2.setFont(font);
        top.add(label2);
        
        label3 = new JLabel("", SwingConstants.CENTER);
        label3.setFont(font);
        top.add(label3);
        
        label4 = new JLabel("", SwingConstants.CENTER);
        label4.setFont(font);
        top.add(label4);
        pane.add(top);
        
        //middle panel setup
        JPanel middle = new JPanel();
        middle.setLayout(new GridLayout(1,3));
        
        higher = new JButton("HIGHER");
        middle.add(higher);
        
        or = new JLabel("OR", SwingConstants.CENTER);
        middle.add(or);
        
        lower = new JButton("LOWER");
        middle.add(lower);
        pane.add(middle);
        
        event e = new event();
        higher.addActionListener(e);
        lower.addActionListener(e);
        
        //bottom panel setup
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(1,1));
        
        winOrLose = new JLabel("", SwingConstants.CENTER);
        winOrLose.setFont(font);
        bottom.add(winOrLose);
        pane.add(bottom);   
    }
    
    public class event implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String option = e.getActionCommand();
            
            if(round == 1) {
                rand2 = (int)(Math.random()* 20 + 1);
                label2.setText("" + rand2);
                
                if(rand2 > rand1 && option.equals("HIGHER")) {
                    winOrLose.setText("Right, 2 more!");
                } else if (rand2 < rand1 && option.equals("HIGHER")) {
                    winOrLose.setText("You lost");
                    lower.setEnabled(false);
                    higher.setEnabled(false);
                } else if (rand2 > rand1 && option.equals("LOWER")) {
                    winOrLose.setText("You lose!");
                    lower.setEnabled(false);
                    higher.setEnabled(false);
                } else if (rand2 < rand1 && option.equals("LOWER")) {
                    winOrLose.setText("Right, 2 more!");
                }
                round = 2;
            } else if (round == 2) {
                rand3 = (int)(Math.random()* 20 + 1);
                label3.setText("" + rand3);
                
                if(rand3 > rand2 && option.equals("HIGHER")) {
                    winOrLose.setText("Right, 1 more!");
                } else if (rand3 < rand2 && option.equals("HIGHER")) {
                    winOrLose.setText("You lost");
                    lower.setEnabled(false);
                    higher.setEnabled(false);
                } else if (rand3 > rand2 && option.equals("LOWER")) {
                    winOrLose.setText("You lose!");
                    lower.setEnabled(false);
                    higher.setEnabled(false);
                } else if (rand3 < rand2 && option.equals("LOWER")) {
                    winOrLose.setText("Right, 1 more!");
                }
                round = 3;
            } else if (round == 3) {
                rand4 = (int)(Math.random()* 20 + 1);
                label4.setText("" + rand4);
                
                if(rand4 > rand3 && option.equals("HIGHER")) {
                    winOrLose.setText("You won the game!");
                    lower.setEnabled(false);
                    higher.setEnabled(false);
                } else if (rand4 < rand3 && option.equals("HIGHER")) {
                    winOrLose.setText("You lost");
                    lower.setEnabled(false);
                    higher.setEnabled(false);
                } else if (rand4 > rand3 && option.equals("LOWER")) {
                    winOrLose.setText("You lose!");
                    lower.setEnabled(false);
                    higher.setEnabled(false);
                } else if (rand4 < rand3 && option.equals("LOWER")) {
                    winOrLose.setText("You won the game!");
                    lower.setEnabled(false);
                    higher.setEnabled(false);
                }
            }
        }
    }
    
    public class ruleBook implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ruleWindow ruleWindowFrame = new ruleWindow();
            ruleWindowFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            ruleWindowFrame.setSize(400,120);
            ruleWindowFrame.setVisible(true);
            ruleWindowFrame.setTitle("Rules");
        }
    }
    
    public class systemClose implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    
    public class restartGame implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            rand1 = (int)(Math.random()* 20 + 1);
            round = 1;
            higher.setEnabled(true);
            lower.setEnabled(true);
            label1.setText("" + rand1);
            label2.setText("");
            label3.setText("");
            label4.setText("");
            winOrLose.setText("");     
        }
    }
    
    
    public static void main(String[] args) {
        
        OverUnder frame = new OverUnder();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Higher or Lower Game");
        frame.setSize(300,150);
        frame.setResizable(false);
        
    }
}
