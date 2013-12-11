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

    public void save(String key, String value) 
    {
        String path = System.getProperty("user.dir") + "/teams/" + filePath + ".xml";
        try {
            File file = new File(path);
            boolean exist = file.exists();
            if(!exist) {
                file.createNewFile();
            }
            OutputStream write = new FileOutputStream(path);
            properties.setProperty(key, value);
            properties.storeToXML(write, filePath);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to save the team's file.");
        }
    }
    
    public void save()
    {
        try
        {
            File temp = new File(System.getProperty("user.dir") + "/teams/teams.txt");
            temp.delete();
            temp.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter((System.getProperty("user.dir") + "/teams/teams.txt")));
            for(TeamFile file: fileArray)
            {
                writer.write(file.getNumber());
                writer.newLine();
            }
            System.out.println(fileArray.size());
            writer.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Failed to write to file: Save");
        }
    }
    
    public void load() 
    {
        try 
        {
            System.getProperty("user.dir") + "/teams/" + number + ".xml");
            InputStream read = new FileInputStream(System.getProperty("user.dir") + "/teams/teams.xml");
            properties.loadFromXML(read);
            for(int i = 0; i < 10000; i++)
            {
                if(new File(System.getProperty("user.dir") + "/teams/" + i + ".xml")) {
                    
                }
            }
            String teamName = properties.getProperty(number);
            setTeamDetails(teamName, teamNumber);
            read.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("File not Found: Load");
            save("Team Name", "New Team");
            save("Team Number", filePath);
            load(path);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failure to read file: Load");
        }
    }

    public void load()
    {
        try
        {
            Scanner reader = new Scanner(new File(System.getProperty("user.dir") + "/teams/teams.txt"));
            while(reader.hasNext())
            {
                addTeam(reader.nextLine());
            }
            reader.close();
        }
        catch(Exception e)
        {
            System.out.println("Third: Failed to read file: Load");
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
