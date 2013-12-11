import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class TeamListWindow extends JFrame implements ActionListener {
    ArrayList<TeamFile> fileArray;

    public void addTeam(String number)
    {
        fileArray.add(new TeamFile(number));
    }

    public ArrayList<TeamFile> getList()
    {
        return fileArray;
    }

    public void writeToFile(String info)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/teams/teams.txt"));
            writer.write(info);
            writer.newLine();
            addTeam(info);
            writer.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Failed to write to file");
        }
    }

    public void saveArrayList()
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/teams/teams.txt"));
            for(TeamFile file : fileArray)
            {
                writer.write(file.getNumber());
                writer.newLine();
            }
            writer.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Failed to write to file: Save");
        }
    }

    public void loadFileToArray()
    {
        try
        {
            Scanner reader = new Scanner(new File(System.getProperty("user.dir") + "/teams/teams.txt"));
            while(reader.hasNext())
            {
                addTeam(reader.nextLine());
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Failed to read file: Read");
        }
    }

    protected JFrame window = new JFrame("Team List");
    GridBagConstraints c = new GridBagConstraints();
    protected JButton back;
    int y = 0;

    public TeamListWindow() {
        fileArray = new ArrayList<TeamFile>();
        loadFileToArray();
        getContentPane().setLayout(new GridBagLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        back = new JButton("Back");
        JPanel buttonPanel = new JPanel(new FlowLayout());
        back.addActionListener(this);
        buttonPanel.add(back, c);
        makeEntries();
        c.gridx = 0;
        c.gridy = y;
        add(buttonPanel);

        pack();
        show();
    }

    private void addEntry(TeamFile tf) {
        entry e = new entry(tf);
        c.gridy = y;
        c.gridx = 0;
        add(e, c);
    }

    private void makeEntries() {
        for(TeamFile a : fileArray) {
            addEntry(a);
            y++;
        }
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == back) {
            window.setVisible(false);
        }
    }

    public void delete(TeamFile tf) {

    }

    class entry extends JPanel implements ActionListener {

        JButton view, delete;
        TeamFile teamFile;

        public entry(TeamFile tf) {
            teamFile = tf;
            setLayout(new FlowLayout());
            JLabel teamName = new JLabel(tf.getName());
            JLabel teamNumber = new JLabel(tf.getNumber());
            view = new JButton("View");
            delete = new JButton("Delete");
            add(teamName);
            add(teamNumber);
            add(view);
            add(delete);
            show();
        }

        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == view) {
                ViewTeamWindow tvw = new ViewTeamWindow();
            }
            else if(e.getSource() == delete) {
                delete(teamFile);
            }
        }

    }
}
