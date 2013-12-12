import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
@SuppressWarnings("unchecked")
public class ConfigureWindow extends JFrame implements ActionListener {

    protected JFrame window;
    protected Choice irAuto, rAuto, pScore, fScore, barHang, flagSpin;
    protected JButton save;


    
    public ConfigureWindow() {
        window = new JFrame("Configuration");
        window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        window.getContentPane().setLayout(new BorderLayout());
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx = 0;
        c.gridy = 0;
        buttonPanel.add(new JLabel(" IR Autonomous "), c);
        irAuto = new Choice();
        irAuto.addItem("Yes");
        irAuto.addItem("No");
        c.gridx = 0;
        c.gridy = 1;
        buttonPanel.add(irAuto, c);
        
        c.gridx = 1;
        c.gridy = 0;
        buttonPanel.add(new JLabel(" Ramp Autonomous "), c);
        rAuto = new Choice();
        rAuto.addItem("Yes");
        rAuto.addItem("No");
        c.gridx = 1;
        c.gridy = 1;
        buttonPanel.add(rAuto, c);
        
        
        c.gridx = 2;
        c.gridy = 0;
        buttonPanel.add(new JLabel(" Pendulum Score "), c);
        pScore = new Choice();
        pScore.addItem("Yes");
        pScore.addItem("No");
        c.gridx = 2;
        c.gridy = 1;
        buttonPanel.add(pScore, c);
        
        c.gridx = 0;
        c.gridy = 2;
        buttonPanel.add(new JLabel(" Floor Goal Score "), c);
        fScore = new Choice();
        fScore.addItem("Yes");
        fScore.addItem("No");
        c.gridx = 0;
        c.gridy = 3;
        buttonPanel.add(fScore, c);
        
        c.gridx = 1;
        c.gridy = 2;
        buttonPanel.add(new JLabel(" Bar Hang "), c);
        barHang = new Choice();
        barHang.addItem("Yes");
        barHang.addItem("No");
        c.gridx = 1;
        c.gridy = 3;
        buttonPanel.add(barHang, c);
        
        c.gridx = 2;
        c.gridy = 2;
        buttonPanel.add(new JLabel(" Flag Raise "), c);
        flagSpin = new Choice();
        flagSpin.addItem("Yes");
        flagSpin.addItem("No");
        c.gridx = 2;
        c.gridy = 3;
        buttonPanel.add(flagSpin, c);

        save = new JButton("Save");
        save.addActionListener(this);
        JPanel savePanel = new JPanel(new FlowLayout());
        savePanel.add(save);
        
        JPanel titlePanel = new JPanel(new FlowLayout());
        titlePanel.add(new JLabel("Configure"));

        window.add(titlePanel, BorderLayout.NORTH);
        window.add(buttonPanel, BorderLayout.LINE_START);
        window.add(savePanel, BorderLayout.SOUTH);

        window.pack();
        window.show();
    }
    
    String[] getChoices() {
        String[] returnArray = new String[6];
        //returnArray[0] = irAuto.getChoice();
        return returnArray;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == save) {
            window.dispose();
        }
    }

}