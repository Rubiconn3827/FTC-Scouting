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
        nameText = new JTextField("Team Name");
        nameText.setSize(nameText.getPreferredSize());
        numberText = new JTextField("Team Number");
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
            GUI.tlw.addTeam(numberText.getText());
            GUI.tlw.save();
            window.dispose();
        }
        else if(e.getSource() == cancel) {
            window.dispose();
        }
    }
    
}