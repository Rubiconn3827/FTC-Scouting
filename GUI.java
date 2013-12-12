import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class GUI extends JFrame implements ActionListener {

    public JFrame mainframe;
    public JButton addTeam, search, viewTeams, configure, quit;
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
        mainframe.setUndecorated(true);

        JPanel titlePanel = new JPanel(new FlowLayout());
        titlePanel.add(new JLabel("FTC Scouting"));

        teamNumber = new JTextField("Team Number");
        mainframe.add(teamNumber, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        addTeam = new JButton(" Add Team ");
        addTeam.addActionListener(this);
        search = new JButton("   Search   ");
        search.addActionListener(this);
        viewTeams = new JButton("View Teams");
        viewTeams.addActionListener(this);
        configure = new JButton("Configure");
        configure.addActionListener(this);
        c.gridx = 0;
        c.gridy = 0;
        buttonPanel.add(addTeam, c);
        c.gridx = 0;
        c.gridy = 1;
        buttonPanel.add(viewTeams, c);
        c.gridx = 2;
        c.gridy = 0;
        buttonPanel.add(search, c);
        c.gridx = 2;
        c.gridy = 1;
        buttonPanel.add(configure, c);
        quit = new JButton("Quit");
        quit.addActionListener(this);
        c.gridx = 1;
        c.gridy = 2;
        buttonPanel.add(quit, c);
        
        JButton calc = new JButton("Calculate");
        calc.addActionListener(this);
        c.gridx = 1;
        c.gridy = 0;
        buttonPanel.add(calc, c);

        JButton update = new JButton("Update");
        update.addActionListener(this);
        c.gridx = 1;
        c.gridy = 1;
        buttonPanel.add(update, c);
        
        JPanel imagePanel = new JPanel(new FlowLayout());
        String first = "first";
        String arg = System.getProperty("user.dir") + "/images/" + first + ".PNG";
        ImageIcon icon = new ImageIcon(arg); 
        JLabel label = new JLabel(); 
        label.setIcon(icon); 
        imagePanel.add(label);

        mainframe.add(buttonPanel, BorderLayout.SOUTH);
        mainframe.add(imagePanel, BorderLayout.NORTH);

        tlw = new TeamListWindow();
        tlw.setVisible(false);

        mainframe.pack();
        mainframe.setLocationRelativeTo(null);
        mainframe.show();
    }
    
    public void search(String input) {
        
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addTeam) {
            AddTeamWindow aw = new AddTeamWindow();
        }
        else if(e.getSource() == search) { 
            search(teamNumber.getText());
            ViewTeamWindow vtw = new ViewTeamWindow();
        }
        else if(e.getSource() == viewTeams) {
            //tlw.load();
            tlw.setVisible(true);
            tlw.repaint();
        }
        else if(e.getSource() == configure) {
            ConfigureWindow cw = new ConfigureWindow();
        }
        else if(e.getSource() == quit) {
            System.exit(0);
        }
    }

}