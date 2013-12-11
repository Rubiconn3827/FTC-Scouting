import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewTeamWindow extends JFrame implements ActionListener {

    protected JFrame window;
    protected JButton edit2, back;
    protected JLabel wins, losses, penalties, irauto, ramp, fspin, hang, pscore, fscore;
    protected JTextField winsf, lossesf, penaltiesf, irautof, rampf, fspinf, hangf, pscoref, fscoref;
    protected boolean isEditing = false;

    public ViewTeamWindow() {

        window = new JFrame("Team");
        window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.getContentPane().setLayout(new BorderLayout());

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

        c.gridx = 0;
        c.gridy = 2;
        losses = new JLabel(" Losses: ");
        lossesf = new JTextField(" Empty ");
        infoPanel.add(losses, c);
        c.gridx = 1;
        c.gridy = 2;
        infoPanel.add(lossesf, c);
        lossesf.setEditable(false);

        c.gridx = 0;
        c.gridy = 4;
        losses = new JLabel(" Penalties: ");
        lossesf = new JTextField(" Empty ");
        infoPanel.add(losses, c);
        c.gridx = 1;
        c.gridy = 4;
        infoPanel.add(lossesf, c);
        lossesf.setEditable(false);

        c.gridx = 2;
        c.gridy = 0;
        losses = new JLabel(" IR Autonomous: ");
        lossesf = new JTextField(" Empty ");
        infoPanel.add(losses, c);
        c.gridx = 3;
        c.gridy = 0;
        infoPanel.add(lossesf, c);
        lossesf.setEditable(false);

        c.gridx = 2;
        c.gridy = 2;
        losses = new JLabel(" Ramp: ");
        lossesf = new JTextField(" Empty ");
        infoPanel.add(losses, c);
        c.gridx = 3;
        c.gridy = 2;
        infoPanel.add(lossesf, c);
        lossesf.setEditable(false);

        c.gridx = 2;
        c.gridy = 4;
        losses = new JLabel(" Flag Spin: ");
        lossesf = new JTextField(" Empty ");
        infoPanel.add(losses, c);
        c.gridx = 3;
        c.gridy = 4;
        infoPanel.add(lossesf, c);
        lossesf.setEditable(false);

        c.gridx = 4;
        c.gridy = 0;
        losses = new JLabel(" Hang: ");
        lossesf = new JTextField(" Empty ");
        infoPanel.add(losses, c);
        c.gridx = 5;
        c.gridy = 0;
        infoPanel.add(lossesf, c);
        lossesf.setEditable(false);

        c.gridx = 4;
        c.gridy = 2;
        losses = new JLabel(" Pendulum Score: ");
        lossesf = new JTextField(" Empty ");
        infoPanel.add(losses, c);
        c.gridx = 5;
        c.gridy = 2;
        infoPanel.add(lossesf, c);
        lossesf.setEditable(false);

        c.gridx = 4;
        c.gridy = 4;
        losses = new JLabel(" Floor Goal Score: ");
        lossesf = new JTextField(" Empty ");
        infoPanel.add(losses, c);
        c.gridx = 5;
        c.gridy = 4;
        infoPanel.add(lossesf, c);
        lossesf.setEditable(false);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        edit2 = new JButton("Edit");
        edit2.addActionListener(this);
        back = new JButton("Back");
        back.addActionListener(this);
        buttonPanel.add(edit2);
        buttonPanel.add(back);

        window.add(buttonPanel, BorderLayout.SOUTH);
        window.add(infoPanel, BorderLayout.CENTER);
        window.pack();
        window.show();
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
                }
                else if(response == JOptionPane.NO_OPTION) {

                }
            } else {
                window.dispose();
            }
        }
    }

}