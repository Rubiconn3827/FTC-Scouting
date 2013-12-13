import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MatchHistoryWindow extends JFrame implements ActionListener {

    GridBagConstraints c = new GridBagConstraints();
    int yCount = 0;
    JScrollPane matchListPane;

    public ArrayList<MatchFile> matchFiles = new ArrayList<MatchFile>();

    public MatchHistoryWindow() {
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