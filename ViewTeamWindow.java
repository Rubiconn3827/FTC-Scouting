import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ViewTeamWindow extends JFrame implements ActionListener {

    private ArrayList<TeamFile> temp;
    private TeamFile file;
    protected JFrame window;
    protected JButton edit2, back;
    protected JLabel wins, losses, penalties, irauto, ramp, fspin, hang, pscore, fscore;
    protected JTextField winsf, lossesf, penaltiesf, irautof, rampf, fspinf, hangf, pscoref, fscoref;
    protected boolean isEditing = false;
    String teamNameS = " Empty ";
    String teamNumberS = " Empty ";

    public ViewTeamWindow(String input) {
        temp = GUI.tlw.getList();
        for(TeamFile hold: temp)
        {
            if(hold.getNumber().equals(input) || hold.getName().equalsIgnoreCase(input))
                file = hold;
        }
        
        teamNameS = file.getName() + ": ";
        teamNumberS = file.getNumber();
        
        window = new JFrame("Team");
        window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        window.getContentPane().setLayout(new BorderLayout());
        window.setUndecorated(true);

        JPanel titlePanel = new JPanel(new FlowLayout());
        JLabel teamName = new JLabel(teamNameS);
        JLabel teamNumber = new JLabel(teamNumberS);
        titlePanel.add(teamName);
        titlePanel.add(teamNumber);
        
        JPanel infoPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        wins = new JLabel(" Wins: ");
        winsf = new JTextField(" Empty ");
        infoPanel.add(wins, c);
        c.gridx = 1;
        c.gridy = 0;
        infoPanel.add(winsf, c);
        winsf.setEditable(false);
        winsf.setText(file.getWins());

        c.gridx = 0;
        c.gridy = 2;
        losses = new JLabel(" Losses: ");
        lossesf = new JTextField(" Empty ");
        infoPanel.add(losses, c);
        c.gridx = 1;
        c.gridy = 2;
        infoPanel.add(lossesf, c);
        lossesf.setEditable(false);
        lossesf.setText(file.getLosses());

        c.gridx = 0;
        c.gridy = 4;
        penalties = new JLabel(" Penalties: ");
        penaltiesf = new JTextField(" Empty ");
        infoPanel.add(penalties, c);
        c.gridx = 1;
        c.gridy = 4;
        infoPanel.add(penaltiesf, c);
        penaltiesf.setEditable(false);
        penaltiesf.setText(file.getPenalties());

        c.gridx = 2;
        c.gridy = 0;
        irauto = new JLabel(" IR Autonomous: ");
        irautof = new JTextField(" Empty ");
        infoPanel.add(irauto, c);
        c.gridx = 3;
        c.gridy = 0;
        infoPanel.add(irautof, c);
        irautof.setEditable(false);
        irautof.setText(file.getIRAutonomous());

        c.gridx = 2;
        c.gridy = 2;
        ramp = new JLabel(" Ramp: ");
        rampf = new JTextField(" Empty ");
        infoPanel.add(ramp, c);
        c.gridx = 3;
        c.gridy = 2;
        infoPanel.add(rampf, c);
        rampf.setEditable(false);
        rampf.setText(file.getRamp());

        c.gridx = 2;
        c.gridy = 4;
        fspin = new JLabel(" Flag Spin: ");
        fspinf = new JTextField(" Empty ");
        infoPanel.add(fspin, c);
        c.gridx = 3;
        c.gridy = 4;
        infoPanel.add(fspinf, c);
        fspinf.setEditable(false);
        fspinf.setText(file.getFlagSpin());

        c.gridx = 4;
        c.gridy = 0;
        hang = new JLabel(" Hang: ");
        hangf = new JTextField(" Empty ");
        infoPanel.add(hang, c);
        c.gridx = 5;
        c.gridy = 0;
        infoPanel.add(hangf, c);
        hangf.setEditable(false);
        hangf.setText(file.getHang());

        c.gridx = 4;
        c.gridy = 2;
        pscore = new JLabel(" Pendulum Score: ");
        pscoref = new JTextField(" Empty ");
        infoPanel.add(pscore, c);
        c.gridx = 5;
        c.gridy = 2;
        infoPanel.add(pscoref, c);
        pscoref.setEditable(false);
        pscoref.setText(file.getPendulumScore());

        c.gridx = 4;
        c.gridy = 4;
        fscore = new JLabel(" Floor Goal Score: ");
        fscoref = new JTextField(" Empty ");
        infoPanel.add(fscore, c);
        c.gridx = 5;
        c.gridy = 4;
        infoPanel.add(fscoref, c);
        fscoref.setEditable(false);
        fscoref.setText(file.getFloorGoalScore());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        edit2 = new JButton("Edit");
        edit2.addActionListener(this);
        back = new JButton("Back");
        back.addActionListener(this);
        buttonPanel.add(edit2);
        buttonPanel.add(back);
        
        MouseyMousey m = new MouseyMousey(window);
        window.addMouseListener(m);
        window.addMouseMotionListener(m);

        window.add(buttonPanel, BorderLayout.SOUTH);
        window.add(infoPanel, BorderLayout.CENTER);
        window.add(titlePanel, BorderLayout.NORTH);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    private void switchEdit() {
        isEditing = !isEditing;
        if(isEditing) {
            edit2.setText("Save");
            makeEditable();
        } else {
            edit2.setText("Edit");
            makeUneditable();
        }
    }

    private void makeEditable() {
        winsf.setEditable(true);
        lossesf.setEditable(true);
        penaltiesf.setEditable(true);
        irautof.setEditable(true);
        rampf.setEditable(true);
        fspinf.setEditable(true);
        hangf.setEditable(true);
        pscoref.setEditable(true);
        fscoref.setEditable(true);
    }

    private void makeUneditable() {
        winsf.setEditable(false);
        lossesf.setEditable(false);
        penaltiesf.setEditable(false);
        irautof.setEditable(false);
        rampf.setEditable(false);
        fspinf.setEditable(false);
        hangf.setEditable(false);
        pscoref.setEditable(false);
        fscoref.setEditable(false);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == edit2) {
            switchEdit();
        }
        else if(e.getSource() == back) {
            if(isEditing) {
                int response = JOptionPane.showConfirmDialog
                    (null, "Are you sure?", "Your changes will be lost!",
                        JOptionPane.YES_NO_OPTION);
                if(response == JOptionPane.YES_OPTION) {
                    window.dispose();
                    GUI.mainframe.setVisible(true);
                }
                else if(response == JOptionPane.NO_OPTION) {

                }
            } else {
                window.dispose();
                GUI.mainframe.setVisible(true);
            }
        }
    }

}