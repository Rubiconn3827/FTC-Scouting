import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MatchHistoryWindow extends JFrame implements ActionListener {

    GridBagConstraints c = new GridBagConstraints();
    int yCount = 0;
    JScrollPane matchListPane;

    public ArrayList<MatchFile> matchFiles;
    
    public void addMatch(String regional, String matchNumber)
    {
        matchFiles.add(new MatchFile(regional, matchNumber));
    }

    public void load(String regional)
    {
        try
        {
            for(int i = 0; i < 50; i++)
            {
                File file = new File(System.getProperty("user.dir") + "/matches/" + regional + "/" + i + ".xml");
                if(file.exists())
                    matchFiles.add(new MatchFile(regional, String.valueOf(i)));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Failure to read file: Match History Load");
        }
    }
    
    public MatchHistoryWindow() {
        matchFiles = new ArrayList<MatchFile>();
        load();
        getContentPane().setLayout(new GridBagLayout());
        setUndecorated(true);
        c.gridy = 0;
        
        matchListPane = new JScrollPane();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void makeNewEntry(MatchFile m) {
        c.gridx = 0;
        c.gridy = yCount;
        matchEntry newEntry = new matchEntry(m);
        matchListPane.getViewport().add(newEntry, c);
        yCount++;
    }

    public void addAllEntries() {
        for(MatchFile m : matchFiles) {
            makeNewEntry(m);
        }
    }

    public void actionPerformed(ActionEvent e) {

    }

    private class matchEntry extends JPanel implements ActionListener {

        public matchEntry(MatchFile m) {

        }

        public void actionPerformed(ActionEvent e) {

        }

    }

}