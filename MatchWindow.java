import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MatchWindow extends JFrame implements ActionListener {

    JButton back, history, add;

    public MatchWindow() {
        setTitle("Matches");
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        back = new JButton("Back");
        history = new JButton("Match History");
        add = new JButton("Add Match");
        back.addActionListener(this);
        history.addActionListener(this);
        add.addActionListener(this);
        buttonPanel.add(add);
        buttonPanel.add(history);
        
        add(buttonPanel, BorderLayout.CENTER);
        add(back, BorderLayout.SOUTH);
        
        MouseyMousey m = new MouseyMousey(this);
        this.addMouseListener(m);
        this.addMouseMotionListener(m);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back) {
            dispose();
            GUI.mainframe.setVisible(true);
        }
        else if(e.getSource() == history) {
            
        }
        else if(e.getSource() == add) {
            setVisible(false);
            NewMatchWindow nmw = new NewMatchWindow();
        }
    }

}