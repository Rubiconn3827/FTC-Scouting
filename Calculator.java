import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Calculator extends JFrame implements ActionListener {
    ArrayList<TeamFile> fileArray;
    Properties properties = new Properties();
    
    public JButton back;
    
    public Calculator() {
        setUndecorated(true);
        setTitle("Calculate");
        getContentPane().setLayout(new BorderLayout());
        
        JPanel titlePanel = new JPanel(new FlowLayout());
        titlePanel.add(new JLabel("Alliance Calculated"));
        add(titlePanel, BorderLayout.NORTH);
        
        back = new JButton("Back");
        back.addActionListener(this);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(back);
        
    }
    
    
    
    public void actionPerformed(ActionEvent e) {
        
    }
    
}