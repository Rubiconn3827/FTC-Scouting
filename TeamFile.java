import java.io.*;
import java.util.*;

public class TeamFile 
{
    private String filePath;
    private String name;
    private String number;
    
    public TeamFile(String path)
    {
        filePath = path;
        load(path + ".xml");
    }
    
    Properties properties = new Properties();
    public void save(String key, String value) 
    {
        String path = "teams/" + filePath + ".xml";
        try {
            File file = new File(path);
            boolean exist = file.exists();
            if(!exist) {
                file.createNewFile();
            }
            OutputStream write = new FileOutputStream(path);
            properties.setProperty(key, value);
            properties.storeToXML(write, GUI.teamNumber.getText());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to save the team's file.");
        }
    }

    public void load(String path) 
    {
        try 
        {
            InputStream read = new FileInputStream(path);
            properties.loadFromXML(read);
            String teamName = properties.getProperty("Team Name");
            String teamNumber = properties.getProperty("Team Number");
            setTeamDetails(teamName, teamNumber);
            read.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("File not Found");
            save("Team Name", "New Team");
            save("Team Number", filePath);
            load(path);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failure to read file.");
        }
    }

    public void setTeamDetails(String name, String number) 
    {
         this.name = name;
         this.number = number;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getNumber()
    {
        return number;
    }
    
    public void changeName(String name)
    {
        this.name = name;
        save("Team Name", name);
    }
}