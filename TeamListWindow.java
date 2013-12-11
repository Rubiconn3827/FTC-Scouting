import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class TeamListWindow extends JFrame implements ActionListener {

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
        }
    }

    public void actionPerformed(ActionEvent e) {
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

}
