import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ConfigureWindow extends JFrame implements ActionListener {

    protected JFrame window;
    protected JComboBox irAuto;

    protected String[] irArray = new String[2];

    public ConfigureWindow() {
        window = new JFrame("Configuration");
        window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.getContentPane().setLayout(new BorderLayout());

        irArray[0] = "Yes";
        irArray[1] = "No";
        irAuto = new JComboBox(irArray);
        irAuto.setSelectedIndex(2);
        irAuto.addActionListener(this);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(irAuto);
        
        window.add(buttonPanel, BorderLayout.SOUTH);

        window.pack();
        window.show();
        
    }

    public void actionPerformed(ActionEvent e) {

    }

}