import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class AddTeamWindow extends JFrame implements ActionListener {
    
    protected JFrame window;
    protected JTextField nameText, numberText;
    protected JButton save, cancel;
    
    @SuppressWarnings("Unchecked")
    
    public AddTeamWindow() {
        window = new JFrame("Add Team");
        window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        window.getContentPane().setLayout(new BorderLayout());
        window.setUndecorated(true);
        
        JPanel titlePanel = new JPanel(new FlowLayout());
        titlePanel.add(new JLabel("Add a team."));
        
        save = new JButton("Save");
        save.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(save);
        buttonPanel.add(cancel);
        
        JPanel namePanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        JPanel textAreaPanel = new JPanel(new FlowLayout());
        nameText = new JTextField("Team Name");
        nameText.setSize(nameText.getPreferredSize());
        numberText = new JTextField("Team Number");
        
        c.gridx = 0;
        c.gridy = 0;
        namePanel.add(new JLabel("Team Name"), c);
        c.gridy = 1;
        namePanel.add(nameText, c);
        
        c.gridx = 1;
        c.gridy = 0;
        namePanel.add(new JLabel("Team Number"), c);
        c.gridy = 1;
        namePanel.add(numberText, c);
        
        textAreaPanel.add(namePanel);
        //textAreaPanel.add(numberPanel);
        
        window.add(buttonPanel, BorderLayout.SOUTH);
        window.add(textAreaPanel, BorderLayout.CENTER);
        window.add(titlePanel, BorderLayout.NORTH);
        
        MouseyMousey m = new MouseyMousey(window);
        window.addMouseListener(m);
        window.addMouseMotionListener(m);
		
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == save) {
            GUI.tlw.addTeam(numberText.getText(), nameText.getText());
            GUI.mainframe.setVisible(true);
            window.dispose();
        }
        else if(e.getSource() == cancel) {
            GUI.mainframe.setVisible(true);
            window.dispose();
        }
    }
    
}