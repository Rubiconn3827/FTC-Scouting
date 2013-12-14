import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class NewMatchWindow extends JFrame implements ActionListener {

    MatchFile file;
    ArrayList<TeamFile> list;
    TeamFile redOne, redTwo, blueOne, blueTwo;
    JTextField matchNumText, red1Text, red2Text, blue1Text, blue2Text,
    blueScoreText, redScoreText, bluePenText, redPenText;

    JButton back, save;
    JPanel redmatchInfoPanel, bluematchInfoPanel;
    Choice infoRedIR1, infoRedIR2, infoBlueIR1, infoBlueIR2;
    Choice infoRedRamp1, infoRedRamp2, infoBlueRamp1, infoBlueRamp2;
    Choice pScoreRed1, pScoreRed2, pScoreBlue1, pScoreBlue2;
    Choice fScoreRed1, fScoreRed2, fScoreBlue1, fScoreBlue2;
    Choice spinRed1, spinRed2, spinBlue1, spinBlue2;
    Choice hangRed1, hangRed2, hangBlue1, hangBlue2;
    Choice red1Dead, red2Dead, blue1Dead, blue2Dead;

    @SuppressWarnings("Unchecked")

    public NewMatchWindow() {
        list = GUI.tlw.getList();
        setTitle("New Match");
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        JPanel titlePanel = new JPanel(new FlowLayout());
        titlePanel.add(new JLabel("New Match Entry"));
        add(titlePanel, BorderLayout.NORTH);

        JPanel newMatchPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JLabel matchNumLabel = new JLabel("Match Number");
        c.gridx = 2;
        c.gridy = 0;
        newMatchPanel.add(matchNumLabel, c);
        matchNumText = new JTextField();
        matchNumText.setPreferredSize(new Dimension(50, 20));
        c.gridx = 3;
        c.gridy = 0;
        newMatchPanel.add(matchNumText, c);

        JLabel red1Label = new JLabel("Red 1");
        c.gridx = 1;
        c.gridy = 1;
        newMatchPanel.add(red1Label, c);
        red1Text = new JTextField();
        red1Text.setPreferredSize(new Dimension(50,20));
        c.gridx = 2;
        c.gridy = 1;
        newMatchPanel.add(red1Text, c);

        JLabel red2Label = new JLabel("Red 2");
        c.gridx = 1;
        c.gridy = 2;
        newMatchPanel.add(red2Label, c);
        red2Text = new JTextField();
        red2Text.setPreferredSize(new Dimension(50,20));
        c.gridx = 2;
        c.gridy = 2;
        newMatchPanel.add(red2Text, c);

        JLabel blue1Label = new JLabel("Blue 1");
        c.gridx = 3;
        c.gridy = 1;
        newMatchPanel.add(blue1Label, c);
        blue1Text = new JTextField();
        blue1Text.setPreferredSize(new Dimension(50,20));
        c.gridx = 4;
        c.gridy = 1;
        newMatchPanel.add(blue1Text, c);

        JLabel blue2Label = new JLabel("Blue 2");
        c.gridx = 3;
        c.gridy = 2;
        newMatchPanel.add(blue2Label, c);
        blue2Text = new JTextField();
        blue2Text.setPreferredSize(new Dimension(50,20));
        c.gridx = 4;
        c.gridy = 2;
        newMatchPanel.add(blue2Text, c);

        JLabel blueScoreLabel = new JLabel("Blue Score");
        c.gridx = 3;
        c.gridy = 3;
        newMatchPanel.add(blueScoreLabel, c);
        blueScoreText = new JTextField();
        blueScoreText.setPreferredSize(new Dimension(50, 20));
        c.gridx = 4;
        c.gridy = 3;
        newMatchPanel.add(blueScoreText, c);

        JLabel redScoreLabel = new JLabel("Red Score");
        c.gridx = 1;
        c.gridy = 3;
        newMatchPanel.add(redScoreLabel, c);
        redScoreText = new JTextField();
        redScoreText.setPreferredSize(new Dimension(50, 20));
        c.gridx = 2;
        c.gridy = 3;
        newMatchPanel.add(redScoreText, c);

        JLabel bluePenLabel = new JLabel("Blue Penalties");
        c.gridx = 3;
        c.gridy = 4;
        newMatchPanel.add(bluePenLabel, c);
        bluePenText = new JTextField();
        bluePenText.setPreferredSize(new Dimension(50, 20));
        c.gridx = 4;
        c.gridy = 4;
        newMatchPanel.add(bluePenText, c);

        JLabel redPenLabel = new JLabel("Red Penalties");
        c.gridx = 1;
        c.gridy = 4;
        newMatchPanel.add(redPenLabel, c);
        redPenText = new JTextField();
        redPenText.setPreferredSize(new Dimension(50, 20));
        c.gridx = 2;
        c.gridy = 4;
        newMatchPanel.add(redPenText, c);

        JLabel red1Fat = new JLabel("Red 1 Fatality");
        c.gridx = 1;
        c.gridy = 5;
        newMatchPanel.add(red1Fat, c);
        red1Dead = new Choice();
        red1Dead.add("No");
        red1Dead.add("Yes");
        c.gridx = 2;
        c.gridy = 5;
        newMatchPanel.add(red1Dead, c);

        JLabel red2Fat = new JLabel("Red 2 Fatality");
        c.gridx = 1;
        c.gridy = 6;
        newMatchPanel.add(red2Fat, c);
        red2Dead = new Choice();
        red2Dead.add("No");
        red2Dead.add("Yes");
        c.gridx = 2;
        c.gridy = 6;
        newMatchPanel.add(red2Dead, c);

        JLabel blue1Fat = new JLabel("Blue 1 Fatality");
        c.gridx = 3;
        c.gridy = 5;
        newMatchPanel.add(blue1Fat, c);
        blue1Dead = new Choice();
        blue1Dead.add("No");
        blue1Dead.add("Yes");
        c.gridx = 4;
        c.gridy = 5;
        newMatchPanel.add(blue1Dead, c);

        JLabel blue2Fat = new JLabel("Blue 2 Fatality");
        c.gridx = 3;
        c.gridy = 6;
        newMatchPanel.add(blue2Fat, c);
        blue2Dead = new Choice();
        blue2Dead.add("No");
        blue2Dead.add("Yes");
        c.gridx = 4;
        c.gridy = 6;
        newMatchPanel.add(blue2Dead, c);

        back = new JButton("Back");
        back.addActionListener(this);
        save = new JButton("Save");
        save.addActionListener(this);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(back);
        buttonPanel.add(save);

        JPanel redInfoChoices = makeRedMatchInfoChoices();
        redInfoChoices.setBackground(Color.GRAY);
        JPanel blueInfoChoices = makeBlueMatchInfoChoices();
        blueInfoChoices.setBackground(Color.GRAY);

        add(redInfoChoices, BorderLayout.WEST);
        add(blueInfoChoices, BorderLayout.EAST);
        add(newMatchPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel makeRedMatchInfoChoices() {
        redmatchInfoPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //IR autonomous choices for red 1 and 2
        //Make the choice box and label for Red IR 1
        infoRedIR1 = new Choice();
        infoRedIR1.add("No");
        infoRedIR1.add("Yes");
        JLabel labelRed1IR = new JLabel("Red 1 IR");
        labelRed1IR.setForeground(Color.RED);
        //Make the choice box and label for the Red IR 2
        infoRedIR2 = new Choice();
        infoRedIR2.add("No");
        infoRedIR2.add("Yes");
        JLabel labelRed2IR = new JLabel("Red 2 IR");
        labelRed2IR.setForeground(Color.RED);
        //Set coordinates for label and choice for Red IR 1
        c.gridx = 0;
        c.gridy = 0;
        redmatchInfoPanel.add(labelRed1IR, c);
        c.gridy = 1;
        redmatchInfoPanel.add(infoRedIR1, c);
        //Set coordinates for label and choice for Red IR 2
        c.gridx = 1;
        c.gridy = 0;
        redmatchInfoPanel.add(labelRed2IR, c);
        c.gridy = 1;
        redmatchInfoPanel.add(infoRedIR2, c);

        //Ramp autonomous choices for red 1 and 2
        //Make the choice box and label for Red Ramp 1
        infoRedRamp1 = new Choice();
        infoRedRamp1.add("No");
        infoRedRamp1.add("Yes");
        JLabel labelRedRamp1 = new JLabel("Red 1 Ramp");
        labelRedRamp1.setForeground(Color.RED);
        //Make choice box and label for Red Ramp 2
        infoRedRamp2 = new Choice();
        infoRedRamp2.add("No");
        infoRedRamp2.add("Yes");
        JLabel labelRedRamp2 = new JLabel("Red 2 Ramp");
        labelRedRamp2.setForeground(Color.RED);
        //Set coordinates for label and choice for Red Ramp 1
        c.gridx = 0;
        c.gridy = 2;
        redmatchInfoPanel.add(labelRedRamp1, c);
        c.gridy = 3;
        redmatchInfoPanel.add(infoRedRamp1, c);
        //Set coordinates for label and choice for Red Ramp 2
        c.gridx = 1;
        c.gridy = 2;
        redmatchInfoPanel.add(labelRedRamp2, c);
        c.gridy = 3;
        redmatchInfoPanel.add(infoRedRamp2, c);

        //Pendulum score for Red
        pScoreRed1 = new Choice();
        pScoreRed1.add("No");
        pScoreRed1.add("Yes");
        JLabel pLabelRed1 = new JLabel(" Red 1 Pendulum Score ");
        pLabelRed1.setForeground(Color.RED);
        //Set coordinates for label and choice for PScore Red 1
        c.gridx = 0;
        c.gridy = 4;
        redmatchInfoPanel.add(pLabelRed1, c);
        c.gridy = 5;
        redmatchInfoPanel.add(pScoreRed1, c);

        pScoreRed2 = new Choice();
        pScoreRed2.add("No");
        pScoreRed2.add("Yes");
        JLabel pLabelRed2 = new JLabel(" Red 2 Pendulum Score ");
        pLabelRed2.setForeground(Color.RED);
        //Set coords
        c.gridx = 1;
        c.gridy = 4;
        redmatchInfoPanel.add(pLabelRed2, c);
        c.gridy = 5;
        redmatchInfoPanel.add(pScoreRed2, c);

        //Floor score for Red
        fScoreRed1 = new Choice();
        fScoreRed1.add("No");
        fScoreRed1.add("Yes");
        JLabel fLabelRed1 = new JLabel( " Red 1 Floor Score ");
        fLabelRed1.setForeground(Color.RED);
        //Set coords
        c.gridx = 0;
        c.gridy = 6;
        redmatchInfoPanel.add(fLabelRed1, c);
        c.gridy = 7;
        redmatchInfoPanel.add(fScoreRed1, c);

        fScoreRed2 = new Choice();
        fScoreRed2.add("No");
        fScoreRed2.add("Yes");
        JLabel fLabelRed2 = new JLabel(" Red 2 Floor Score ");
        fLabelRed2.setForeground(Color.RED);
        //Set coords
        c.gridx = 1;
        c.gridy = 6;
        redmatchInfoPanel.add(fLabelRed2, c);
        c.gridy = 7;
        redmatchInfoPanel.add(fScoreRed2, c);

        //Flag spin for Red
        spinRed1 = new Choice();
        spinRed1.add("No");
        spinRed1.add("Yes");
        JLabel sLabelRed1 = new JLabel("Red 1 Flag Spin");
        sLabelRed1.setForeground(Color.RED);
        //Set coords
        c.gridx = 0;
        c.gridy = 8;
        redmatchInfoPanel.add(sLabelRed1, c);
        c.gridy = 9;
        redmatchInfoPanel.add(spinRed1, c);

        spinRed2 = new Choice();
        spinRed2.add("No");
        spinRed2.add("Yes");
        JLabel sLabelRed2 = new JLabel("Red 2 Flag Spin");
        sLabelRed2.setForeground(Color.RED);
        //Set coords
        c.gridx = 1;
        c.gridy = 8;
        redmatchInfoPanel.add(sLabelRed2, c);
        c.gridy = 9;
        redmatchInfoPanel.add(spinRed2, c);

        //Hang for Red
        hangRed1 = new Choice();
        hangRed1.add("No");
        hangRed1.add("Yes");
        JLabel hLabelRed1 = new JLabel("Red 1 Bar Hang");
        hLabelRed1.setForeground(Color.RED);
        //Set coords
        c.gridx = 0;
        c.gridy = 10;
        redmatchInfoPanel.add(hLabelRed1, c);
        c.gridy = 11;
        redmatchInfoPanel.add(hangRed1, c);

        hangRed2 = new Choice();
        hangRed2.add("No");
        hangRed2.add("Yes");
        JLabel hLabelRed2 = new JLabel("Red 2 Bar Hang");
        hLabelRed2.setForeground(Color.RED);
        //Set coords
        c.gridx = 1;
        c.gridy = 10;
        redmatchInfoPanel.add(hLabelRed2, c);
        c.gridy = 11;
        redmatchInfoPanel.add(hangRed2, c);

        return redmatchInfoPanel;
    }

    public JPanel makeBlueMatchInfoChoices() {
        bluematchInfoPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        infoBlueIR1 = new Choice();
        infoBlueIR1.add("No");
        infoBlueIR1.add("Yes");
        JLabel labelBlue1IR = new JLabel("Blue 1 IR");
        labelBlue1IR.setForeground(Color.BLUE);

        infoBlueIR2 = new Choice();
        infoBlueIR2.add("No");
        infoBlueIR2.add("Yes");
        JLabel labelBlue2IR = new JLabel("Blue 2 IR");
        labelBlue2IR.setForeground(Color.BLUE);

        c.gridx = 0;
        c.gridy = 0;
        bluematchInfoPanel.add(labelBlue1IR, c);
        c.gridy = 1;
        bluematchInfoPanel.add(infoBlueIR1, c);
        c.gridx = 1;
        c.gridy = 0;
        bluematchInfoPanel.add(labelBlue2IR, c);
        c.gridy = 1;
        bluematchInfoPanel.add(infoBlueIR2, c);

        //Ramp autonomous choices for blue 1 and 2
        //Make the choice box and label for blue Ramp 1
        infoBlueRamp1 = new Choice();
        infoBlueRamp1.add("No");
        infoBlueRamp1.add("Yes");
        JLabel labelBlueRamp1 = new JLabel("Blue 1 Ramp");
        labelBlueRamp1.setForeground(Color.BLUE);
        //Make choice box and label for Red Ramp 2
        infoBlueRamp2 = new Choice();
        infoBlueRamp2.add("No");
        infoBlueRamp2.add("Yes");
        JLabel labelBlueRamp2 = new JLabel("Blue 2 Ramp");
        labelBlueRamp2.setForeground(Color.BLUE);
        //Set coordinates for label and choice for Red Ramp 1
        c.gridx = 0;
        c.gridy = 2;
        bluematchInfoPanel.add(labelBlueRamp1, c);
        c.gridy = 3;
        bluematchInfoPanel.add(infoBlueRamp1, c);
        //Set coordinates for label and choice for Red Ramp 2
        c.gridx = 1;
        c.gridy = 2;
        bluematchInfoPanel.add(labelBlueRamp2, c);
        c.gridy = 3;
        bluematchInfoPanel.add(infoBlueRamp2, c);

        //Pendulum score for Blue
        pScoreBlue1 = new Choice();
        pScoreBlue1.add("No");
        pScoreBlue1.add("Yes");
        JLabel pLabelBlue1 = new JLabel(" Blue 1 Pendulum Score ");
        pLabelBlue1.setForeground(Color.BLUE);
        //Set coordinates for label and choice for PScore Red 1
        c.gridx = 0;
        c.gridy = 4;
        bluematchInfoPanel.add(pLabelBlue1, c);
        c.gridy = 5;
        bluematchInfoPanel.add(pScoreBlue1, c);

        pScoreBlue2 = new Choice();
        pScoreBlue2.add("No");
        pScoreBlue2.add("Yes");
        JLabel pLabelBlue2 = new JLabel(" Blue 2 Pendulum Score ");
        pLabelBlue2.setForeground(Color.BLUE);
        //Set coords
        c.gridx = 1;
        c.gridy = 4;
        bluematchInfoPanel.add(pLabelBlue2, c);
        c.gridy = 5;
        bluematchInfoPanel.add(pScoreBlue2, c);

        //Floor score for Red
        fScoreBlue1 = new Choice();
        fScoreBlue1.add("No");
        fScoreBlue1.add("Yes");
        JLabel fLabelBlue1 = new JLabel( " Blue 1 Floor Score ");
        fLabelBlue1.setForeground(Color.BLUE);
        //Set coords
        c.gridx = 0;
        c.gridy = 6;
        bluematchInfoPanel.add(fLabelBlue1, c);
        c.gridy = 7;
        bluematchInfoPanel.add(fScoreBlue1, c);

        fScoreBlue2 = new Choice();
        fScoreBlue2.add("No");
        fScoreBlue2.add("Yes");
        JLabel fLabelBlue2 = new JLabel(" Blue 2 Floor Score ");
        fLabelBlue2.setForeground(Color.BLUE);
        //Set coords
        c.gridx = 1;
        c.gridy = 6;
        bluematchInfoPanel.add(fLabelBlue2, c);
        c.gridy = 7;
        bluematchInfoPanel.add(fScoreBlue2, c);

        //Flag spin for Red
        spinBlue1 = new Choice();
        spinBlue1.add("No");
        spinBlue1.add("Yes");
        JLabel sLabelBlue1 = new JLabel("Blue 1 Flag Spin");
        sLabelBlue1.setForeground(Color.BLUE);
        //Set coords
        c.gridx = 0;
        c.gridy = 8;
        bluematchInfoPanel.add(sLabelBlue1, c);
        c.gridy = 9;
        bluematchInfoPanel.add(spinBlue1, c);

        spinBlue2 = new Choice();
        spinBlue2.add("No");
        spinBlue2.add("Yes");
        JLabel sLabelBlue2 = new JLabel("Blue 2 Flag Spin");
        sLabelBlue2.setForeground(Color.BLUE);
        //Set coords
        c.gridx = 1;
        c.gridy = 8;
        bluematchInfoPanel.add(sLabelBlue2, c);
        c.gridy = 9;
        bluematchInfoPanel.add(spinBlue2, c);

        //Hang for Red
        hangBlue1 = new Choice();
        hangBlue1.add("No");
        hangBlue1.add("Yes");
        JLabel hLabelBlue1 = new JLabel("Blue 1 Bar Hang");
        hLabelBlue1.setForeground(Color.BLUE);
        //Set coords
        c.gridx = 0;
        c.gridy = 10;
        bluematchInfoPanel.add(hLabelBlue1, c);
        c.gridy = 11;
        bluematchInfoPanel.add(hangBlue1, c);

        hangBlue2 = new Choice();
        hangBlue2.add("No");
        hangBlue2.add("Yes");
        JLabel hLabelBlue2 = new JLabel("Blue 2 Bar Hang");
        hLabelBlue2.setForeground(Color.BLUE);
        //Set coords
        c.gridx = 1;
        c.gridy = 10;
        bluematchInfoPanel.add(hLabelBlue2, c);
        c.gridy = 11;
        bluematchInfoPanel.add(hangBlue2, c);

        return bluematchInfoPanel;
    }

    public String getChoiceVal(Choice co) {
        return co.getSelectedItem();
    }

    public void saveMatchInfo()
    {
        file = new MatchFile("CMSA", matchNumText.getText());
        file.setRedPoints(redScoreText.getText());
        file.setBluePoints(blueScoreText.getText());
        file.setRedPenalties(redPenText.getText());
        file.setBluePenalties(bluePenText.getText());
        file.setRedAllianceOne(red1Text.getText());
        file.setBlueAllianceOne(blue1Text.getText());
        file.setRedAllianceTwo(red2Text.getText());
        file.setBlueAllianceTwo(blue2Text.getText());
        GUI.mw.mhw.addMatch("CMSA", matchNumText.getText());
    }

    public void fatalities()
    {
        for(TeamFile file: list)
        {
            if(file.getNumber().equals(blue1Text.getText()))
                blueOne = file;
            else if(file.getNumber().equals(blue2Text.getText()))
                blueTwo = file;
            else if(file.getNumber().equals(red1Text.getText()))
                redOne = file;
            else if(file.getNumber().equals(red2Text.getText()))
                redTwo = file;
        }

        if(red1Dead.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(redOne.getFatalities());
            temp++;
            redOne.setFatalities(String.valueOf(temp));
        }
        if(red2Dead.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(redTwo.getFatalities());
            temp++;
            redTwo.setFatalities(String.valueOf(temp));
        }
        if(blue1Dead.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(blueOne.getFatalities());
            temp++;
            blueOne.setFatalities(String.valueOf(temp));
        }
        if(blue2Dead.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(blueTwo.getFatalities());
            temp++;
            blueTwo.setFatalities(String.valueOf(temp));
        }
    }
    
    public void update()
    {
        int red = Integer.parseInt(redScoreText.getText());
        int blue = Integer.parseInt(blueScoreText.getText());
        int redOneScore = Integer.parseInt(redOne.getScore()) + red;
        int redTwoScore = Integer.parseInt(blueOne.getScore()) + red;
        int blueOneScore = Integer.parseInt(redTwo.getScore()) + blue;
        int blueTwoScore = Integer.parseInt(blueTwo.getScore()) + blue;
        redOne.setScore(String.valueOf(redOneScore));
        redTwo.setScore(String.valueOf(redTwoScore));
        blueOne.setScore(String.valueOf(blueOneScore));
        blueTwo.setScore(String.valueOf(blueTwoScore));
        if(red > blue)
        {
            int temp = Integer.parseInt(redOne.getWins());
            temp++;
            redOne.setWins(String.valueOf(temp));
            
            temp = Integer.parseInt(redTwo.getWins());
            temp++;
            redTwo.setWins(String.valueOf(temp));
            
            temp = Integer.parseInt(blueOne.getLosses());
            temp++;
            blueOne.setLosses(String.valueOf(temp));
            
            temp = Integer.parseInt(blueTwo.getLosses());
            temp++;
            blueTwo.setLosses(String.valueOf(temp));
        }
        else if(blue > red)
        {
            int temp = Integer.parseInt(redOne.getLosses());
            temp++;
            redOne.setLosses(String.valueOf(temp));
            
            temp = Integer.parseInt(redTwo.getLosses());
            temp++;
            redTwo.setLosses(String.valueOf(temp));
            
            temp = Integer.parseInt(blueOne.getWins());
            temp++;
            blueOne.setWins(String.valueOf(temp));
            
            temp = Integer.parseInt(blueTwo.getWins());
            temp++;
            blueTwo.setWins(String.valueOf(temp));
        }
        else
        {
            int temp = Integer.parseInt(redOne.getTies());
            temp++;
            redOne.setTies(String.valueOf(temp));
            
            temp = Integer.parseInt(redTwo.getTies());
            temp++;
            redTwo.setTies(String.valueOf(temp));
            
            temp = Integer.parseInt(blueOne.getTies());
            temp++;
            blueOne.setTies(String.valueOf(temp));
            
            temp = Integer.parseInt(blueTwo.getTies());
            temp++;
            blueTwo.setTies(String.valueOf(temp));
        }
        
        int red1Pen = Integer.parseInt(redOne.getPenalties()) + Integer.parseInt(redPenText.getText());
        int red2Pen = Integer.parseInt(redTwo.getPenalties()) + Integer.parseInt(redPenText.getText());
        int blue1Pen = Integer.parseInt(blueOne.getPenalties()) + Integer.parseInt(bluePenText.getText());
        int blue2Pen = Integer.parseInt(blueTwo.getPenalties()) + Integer.parseInt(bluePenText.getText());
        redOne.setPenalties(String.valueOf(red1Pen));
        redTwo.setPenalties(String.valueOf(red2Pen));
        blueOne.setPenalties(String.valueOf(blue1Pen));
        blueTwo.setPenalties(String.valueOf(blue2Pen));
        
        //Red One Info
        if(infoRedIR1.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(redOne.getIRAutonomous());
            temp++;
            redOne.setIRAutonomous(String.valueOf(temp));
        }
        if(infoRedRamp1.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(redOne.getRamp());
            temp++;
            redOne.setRamp(String.valueOf(temp));
        }
        if(pScoreRed1.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(redOne.getPendulumScore());
            temp++;
            redOne.setPendulumScore(String.valueOf(temp));
        }
        if(fScoreRed1.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(redOne.getFloorGoalScore());
            temp++;
            redOne.setFloorGoalScore(String.valueOf(temp));
        }
        if(spinRed1.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(redOne.getFlagSpin());
            temp++;
            redOne.setFlagSpin(String.valueOf(temp));
        }
        if(hangRed1.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(redOne.getHang());
            temp++;
            redOne.setHang(String.valueOf(temp));
        }
        
        //Red Two Info
        if(infoRedIR2.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(redTwo.getIRAutonomous());
            temp++;
            redTwo.setIRAutonomous(String.valueOf(temp));
        }
        if(infoRedRamp2.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(redTwo.getRamp());
            temp++;
            redTwo.setRamp(String.valueOf(temp));
        }
        if(pScoreRed2.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(redTwo.getPendulumScore());
            temp++;
            redTwo.setPendulumScore(String.valueOf(temp));
        }
        if(fScoreRed2.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(redTwo.getFloorGoalScore());
            temp++;
            redTwo.setFloorGoalScore(String.valueOf(temp));
        }
        if(spinRed2.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(redTwo.getFlagSpin());
            temp++;
            redTwo.setFlagSpin(String.valueOf(temp));
        }
        if(hangRed2.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(redTwo.getHang());
            temp++;
            redTwo.setHang(String.valueOf(temp));
        }
        
        //Blue One Info
        if(infoBlueIR1.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(blueOne.getIRAutonomous());
            temp++;
            blueOne.setIRAutonomous(String.valueOf(temp));
        }
        if(infoBlueRamp1.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(blueOne.getRamp());
            temp++;
            blueOne.setRamp(String.valueOf(temp));
        }
        if(pScoreBlue1.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(blueOne.getPendulumScore());
            temp++;
            blueOne.setPendulumScore(String.valueOf(temp));
        }
        if(fScoreBlue1.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(blueOne.getFloorGoalScore());
            temp++;
            blueOne.setFloorGoalScore(String.valueOf(temp));
        }
        if(spinBlue1.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(blueOne.getFlagSpin());
            temp++;
            blueOne.setFlagSpin(String.valueOf(temp));
        }
        if(hangBlue1.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(blueOne.getHang());
            temp++;
            blueOne.setHang(String.valueOf(temp));
        }
        
        //Blue Two Info
        if(infoBlueIR2.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(blueTwo.getIRAutonomous());
            temp++;
            blueTwo.setIRAutonomous(String.valueOf(temp));
        }
        if(infoBlueRamp2.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(blueTwo.getRamp());
            temp++;
            blueTwo.setRamp(String.valueOf(temp));
        }
        if(pScoreBlue2.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(blueTwo.getPendulumScore());
            temp++;
            blueTwo.setPendulumScore(String.valueOf(temp));
        }
        if(fScoreBlue2.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(blueTwo.getFloorGoalScore());
            temp++;
            blueTwo.setFloorGoalScore(String.valueOf(temp));
        }
        if(spinBlue2.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(blueTwo.getFlagSpin());
            temp++;
            blueTwo.setFlagSpin(String.valueOf(temp));
        }
        if(hangBlue2.getSelectedIndex() == 1)
        {
            int temp = Integer.parseInt(blueTwo.getHang());
            temp++;
            blueTwo.setHang(String.valueOf(temp));
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back) {
            dispose();
            GUI.mw.setVisible(true);
        }
        else if(e.getSource() == save)
        {
            saveMatchInfo();
            fatalities();
            update();
            dispose();
            GUI.mw.setVisible(true);
        }
    }

}