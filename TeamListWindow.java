import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class TeamListWindow extends JFrame implements ActionListener {
<<<<<<< HEAD
    ArrayList<TeamFile> fileArray;

    public TeamListWindow() 
    {
        fileArray = new ArrayList<TeamFile>();
        loadFileToArray();
    }

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
            System.out.println();
            writer.write(info);
            writer.newLine();
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
=======

    ArrayList<TeamFile> teamList;

    protected JFrame window = new JFrame("Team List");
    GridBagConstraints c = new GridBagConstraints();
    protected JButton back;
    int y = 0;

    public TeamListWindow(ArrayList<TeamFile> a) {
        teamList = new ArrayList<TeamFile>();
        window.getContentPane().setLayout(new GridBagLayout());
        window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        window.setLocationRelativeTo(null);

        back = new JButton("Back");
        JPanel buttonPanel = new JPanel(new FlowLayout());
        back.addActionListener(this);
        buttonPanel.add(back);
        makeEntries();
        c.gridx = 0;
        c.gridy = y;
        window.add(buttonPanel, c);

        window.pack();
        window.show();
    }

    private void addEntry(TeamFile tf) {
        entry e = new entry(tf);
        c.gridy = y;
        c.gridx = 0;
        window.add(e, c);
    }

    private void makeEntries() {
        for(TeamFile a : teamList) {
            addEntry(a);
            y++;
>>>>>>> f90d967ecc22b991b4ef64e578b353c27064be55
        }
    }

    public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
    }
=======
        if(e.getSource() == back) {
            window.dispose();
        }
    }

    public void delete(TeamFile tf) {

    }

    class entry extends JPanel implements ActionListener {

        JButton view, delete;
        TeamFile teamFile;

        public entry(TeamFile tf) {
            teamFile = tf;
            JPanel entryPanel = new JPanel(new FlowLayout());
            JLabel teamName = new JLabel(tf.getName());
            JLabel teamNumber = new JLabel(tf.getNumber());
            view = new JButton("View");
            delete = new JButton("Delete");
            entryPanel.add(teamName);
            entryPanel.add(teamNumber);
            entryPanel.add(view);
            entryPanel.add(delete);
            entryPanel.show();
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

>>>>>>> f90d967ecc22b991b4ef64e578b353c27064be55
}
