import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
@SuppressWarnings("unchecked")
public class ConfigureWindow extends JFrame implements ActionListener {

    protected JFrame window;
    protected JComboBox irAuto;
    protected JButton save;

    protected String[] irArray = new String[2];

    
    public ConfigureWindow() {
        window = new JFrame("Configuration");
        window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        window.getContentPane().setLayout(new BorderLayout());
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        irArray[0] = "Yes";
        irArray[1] = "No";
        //irAuto = new JComboBox(irArray);
        //irAuto.setSelectedIndex(2);
        //irAuto.addActionListener(this);
        //JPanel buttonPanel = new JPanel(new FlowLayout());
        //buttonPanel.add(irAuto);

        save = new JButton("Save");
        save.addActionListener(this);
        JPanel savePanel = new JPanel(new FlowLayout());
        savePanel.add(save);
        
        JPanel titlePanel = new JPanel(new FlowLayout());
        titlePanel.add(new JLabel("Configure"));

        window.add(titlePanel, BorderLayout.NORTH);
        //window.add(buttonPanel, BorderLayout.CENTER);
        window.add(savePanel, BorderLayout.SOUTH);

        window.pack();
        window.show();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == save) {
            window.dispose();
        }
    }

}