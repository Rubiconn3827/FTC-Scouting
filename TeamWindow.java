import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TeamWindow extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JPanel window = new JPanel();

    protected static String teamName;
    protected static String teamNumber;
    protected static int numberOfWins;
    protected static int numberOfLosses;
    protected static int averageScore;
    protected static int averageDifference;
    protected static ArrayList<Integer> allianceScore;
    protected static ArrayList<Integer> opponentsScore;
    protected static String allianceScoreString;
    protected static String opponentsScoreString;

    protected JLabel teamNameLabel, teamNumberLabel, numberOfWinsLabel, numberOfLossesLabel, averageScoreLabel, averageDifferenceLabel, allianceScoreLabel, opponentsScoreLabel;
    protected JTextArea teamNameResult, teamNumberResult, numberOfWinsResult, numberOfLossesResult, averageScoreResult, averageDifferenceResult, allianceScoreResult, opponentsScoreResult;

    protected JTable scores;
    protected JScrollPane spTable = new JScrollPane(scores);

    protected JButton back, edit;

    public TeamWindow() {
        setWindow();
        this.setVisible(true);
    }
    
    public void setWindow() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to create GUI.");
        }
        setTitle(teamName);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(window);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        window.setLayout(new FlowLayout());
        
        back = new JButton("Back");
        back.addActionListener(this);
        edit = new JButton("Edit");
        edit.addActionListener(this);
        
        teamNameLabel = new JLabel("Team Name: ");
        window.add(teamNameLabel);
        teamNumberLabel = new JLabel("Team Number: ");
        window.add(teamNumberLabel);
        numberOfWinsLabel = new JLabel("Wins: ");
        window.add(numberOfWinsLabel);
        numberOfLossesLabel = new JLabel("Losses: ");
        window.add(numberOfLossesLabel);
        averageScoreLabel = new JLabel("Average Score: ");
        window.add(averageScoreLabel);
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals("Back")) {
            GUI gui = new GUI();
            this.dispose();
        }
        else if(e.getSource().equals("Edit")) {
            makeEditable();
        }
        
    }
    
    public void makeEditable() {
        
    }

}