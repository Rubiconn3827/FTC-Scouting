import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TeamListWindow extends JFrame implements ActionListener {
    
    TeamFile[] fileArray;
    
    public TeamListWindow(TeamFile[] teamFileArray) {
        fileArray = new TeamFile[teamFileArray.length];
    }
    
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
