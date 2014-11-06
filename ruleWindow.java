package Windowing;

import javax.swing.*;
import java.awt.*;

public class ruleWindow extends JFrame {
    JLabel rule1;
    JLabel rule2;
    JLabel rule3;
    
    public ruleWindow() {
        
        setLayout(new FlowLayout());
        
        rule1 = new JLabel("The first number will be given.");
        add(rule1);
        
        rule2 = new JLabel("Guess whether the next number is higher or lower.");
        add(rule2);
        
        rule3 = new JLabel("if guessed correctly 3 consecutive times, you win, or else you lose!");
        add(rule3);
             
    }
}
