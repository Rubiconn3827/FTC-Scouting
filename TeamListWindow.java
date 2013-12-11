import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TeamListWindow extends JFrame implements ActionListener {
    ArrayList<TeamFile> fileArray;

    public TeamListWindow() 
    {
        fileArray = new ArrayList<TeamFile>();
        loadFileToArray();
    }

    public void addTeam(String number)
    {
        fileArray.add(new TeamFile(number));
    }

    public ArrayList<TeamFile> getList()
    {
        return fileArray;
    }

    public void writeToFile(String info)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/teams/teams.txt"));
            System.out.println();
            writer.write(info);
            writer.newLine();
            writer.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Failed to write to file");
        }
    }

    public void saveArrayList()
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/teams/teams.txt"));
            for(TeamFile file : fileArray)
            {
                writer.write(file.getNumber());
                writer.newLine();
            }
            writer.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Failed to write to file: Save");
        }
    }

    public void loadFileToArray()
    {
        try
        {
            Scanner reader = new Scanner(new File(System.getProperty("user.dir") + "/teams/teams.txt"));
            while(reader.hasNext())
            {
                addTeam(reader.nextLine());
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
             System.out.println("Failed to read file: Read");
        }
    }

    public void actionPerformed(ActionEvent e) {
    }
}
