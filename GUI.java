import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUI extends JFrame implements ActionListener {

    public JFrame mainframe;
    public JButton addTeam, search;
    public static JTextField teamNumber;
    TeamFile teamFile = new TeamFile();

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("Unchecked")
    
    public GUI() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Broken.");
        }
        mainframe = new JFrame("FTC Scouting");
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.getContentPane().setLayout(new BorderLayout());
        mainframe.setLocationRelativeTo(null);

        JPanel titlePanel = new JPanel(new FlowLayout());
        titlePanel.add(new JLabel("FTC Block Party Scouting"));

        teamNumber = new JTextField("Team Number");
        mainframe.add(teamNumber);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        addTeam = new JButton("Add Team");
        addTeam.addActionListener(this);
        search = new JButton("Search");
        search.addActionListener(this);
        buttonPanel.add(addTeam);
        buttonPanel.add(search);

        mainframe.add(buttonPanel, BorderLayout.SOUTH);
        mainframe.add(titlePanel, BorderLayout.NORTH);

        mainframe.pack();
        mainframe.show();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addTeam) {
            this.setVisible(false);
            this.dispose();
            AddTeamWindow aw = new AddTeamWindow();
        }
        else if(e.getSource().equals("Search")) { 

        }
    }

}