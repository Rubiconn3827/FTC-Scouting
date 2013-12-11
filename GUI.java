import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class GUI extends JFrame implements ActionListener {

    public JFrame mainframe;
    public JButton addTeam, search, viewTeams, configure;
    public static JTextField teamNumber;
    public static TeamListWindow tlw;

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("Unchecked")
    
    public GUI() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();

        }
        mainframe = new JFrame("FTC Scouting");
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.getContentPane().setLayout(new BorderLayout());
        mainframe.setLocationRelativeTo(null);

        ImageIcon image = new ImageIcon("src/firstlogo.jpg");
        JLabel label = new JLabel("", image, JLabel.CENTER);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add( label, BorderLayout.CENTER );

        JPanel titlePanel = new JPanel(new FlowLayout());
        titlePanel.add(new JLabel("FTC Scouting"));

        teamNumber = new JTextField("Team Number");
        mainframe.add(teamNumber, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        addTeam = new JButton("Add Team");
        addTeam.addActionListener(this);
        search = new JButton("Search");
        search.addActionListener(this);
        viewTeams = new JButton("View Teams");
        viewTeams.addActionListener(this);
        configure = new JButton("Configure");
        configure.addActionListener(this);
        buttonPanel.add(addTeam);
        buttonPanel.add(viewTeams);
        buttonPanel.add(search);
        buttonPanel.add(configure);

        mainframe.add(buttonPanel, BorderLayout.SOUTH);
        mainframe.add(panel, BorderLayout.NORTH);

        tlw = new TeamListWindow();
        tlw.setVisible(false);
        
        mainframe.pack();
        mainframe.show();
    }

    public void windowClosing(WindowEvent e) {
        if(e.getSource() == JFrame.EXIT_ON_CLOSE) {
            tlw.saveArrayList();
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addTeam) {
            AddTeamWindow aw = new AddTeamWindow();
        }
        else if(e.getSource() == search) { 
            ViewTeamWindow vtw = new ViewTeamWindow();
        }
        else if(e.getSource() == viewTeams) {
            tlw.setVisible(true);
        }
        else if(e.getSource() == configure) {
            ConfigureWindow cw = new ConfigureWindow();
        }
    }

}