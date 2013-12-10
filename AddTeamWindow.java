import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class AddTeamWindow extends JFrame implements ActionListener {
    
    protected JFrame window;
    protected JTextArea nameText, numberText;
    protected JButton save, cancel;
    
    TeamFile teamFile = new TeamFile();
    
    @SuppressWarnings("Unchecked")
    
    public AddTeamWindow() {
        window = new JFrame("Add Team");
        window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        window.getContentPane().setLayout(new BorderLayout());
        window.setLocationRelativeTo(null);
        
        JPanel titlePanel = new JPanel(new FlowLayout());
        titlePanel.add(new JLabel("Add a team."));
        
        save = new JButton("Save");
        save.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(save);
        buttonPanel.add(cancel);
        
        JPanel textAreaPanel = new JPanel(new FlowLayout());
        nameText = new JTextArea("Team Name");
        nameText.setSize(nameText.getPreferredSize());
        numberText = new JTextArea("Team Number");
        textAreaPanel.add(nameText);
        textAreaPanel.add(numberText);
        
        window.add(buttonPanel, BorderLayout.SOUTH);
        window.add(textAreaPanel, BorderLayout.CENTER);
        window.add(titlePanel, BorderLayout.NORTH);
        
		
        window.pack();
        window.show();
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == save) {
            writeXML();
            window.dispose();
        }
        else if(e.getSource() == cancel) {
            window.setVisible(false);
            window.dispose();
        }
    }
    
    public void writeXML() {
        teamFile.load("teams/" + GUI.teamNumber.getText() + ".xml");
        dispose();
    }
}