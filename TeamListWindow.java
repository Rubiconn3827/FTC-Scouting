import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class TeamListWindow extends JFrame implements ActionListener{
    ArrayList<TeamFile> fileArray;
    Properties properties = new Properties();

    public void addTeam(String number)
    {
        fileArray.add(new TeamFile(number));
    }

    public ArrayList<TeamFile> getList()
    {
        return fileArray;
    }

    public void load() 
    {
        try 
        {
            for(int i = 0; i < 10000; i++)
            {
                File file = new File(System.getProperty("user.dir") + "/teams/" + i + ".xml");
                if(file.exists()) 
                {
                    TeamFile temp = new TeamFile(String.valueOf(i));
                    if(!fileArray.contains(temp))
                    {
                        fileArray.add(temp);
                        System.out.println(file.toString());
                    }
                }
            }
            System.out.println(fileArray.size());
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            System.out.println("Failure to read file: Load");
        }
    }

    protected JFrame window = new JFrame("Team List");
    GridBagConstraints c = new GridBagConstraints();
    protected JButton back;
    int y = 0;
    ArrayList<entry> entries = new ArrayList<entry>();
    protected JScrollPane scrollPane;
    protected JPanel listPanel;

    public TeamListWindow() {
        fileArray = new ArrayList<TeamFile>();
        load();
        //addTeam("0");
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        //setUndecorated(true);

        listPanel = new JPanel(new GridBagLayout());

        back = new JButton("Back");
        JPanel buttonPanel = new JPanel(new FlowLayout());
        back.addActionListener(this);
        buttonPanel.add(back, c);
        makeEntries();
        c.gridx = 0;
        c.gridy = y;
        listPanel.add(new JLabel(fileArray.get(0).getNumber()));
        add(buttonPanel, BorderLayout.SOUTH);
        add(listPanel, BorderLayout.CENTER);

        pack();
        show();
    }

    private void addEntry(TeamFile tf) {
        entry e = new entry(tf);
        entries.add(e);
        c.gridy = y;
        c.gridx = 0;
        listPanel.add(e, c);
    }

    private void makeEntries() {
        for(TeamFile a : fileArray) {
            addEntry(a);
            y++;
        }
    }

    private void addTestEntry() {
        c.gridy = 0;
        c.gridx = 0;
        listPanel.add(new JLabel("Test"), c);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == back) {
            setVisible(false);
        }
    }

    public void enableButtons() {
        for(entry a : entries) {
            a.enableButtons();
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

        public void enableButtons() {
            view.setEnabled(true);
            delete.setEnabled(true);
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
