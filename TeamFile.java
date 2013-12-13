import java.io.*;
import java.util.*;

public class TeamFile 
{
    private String filePath;
    private String name;
    private String number;

    public TeamFile(String path) {
        filePath = path;
        number = path;
        load(path);
    }

    Properties properties = new Properties();
    public void save(String key, String value) 
    {
        String path = System.getProperty("user.dir") + "/teams/" + filePath + ".xml";
        try {
            File file = new File(path);
            boolean exist = file.exists();
            if(!exist) {
                file.createNewFile();
            }
            OutputStream write = new FileOutputStream(path);
            properties.setProperty(key, value);
            properties.storeToXML(write, filePath);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to save the team's file.");
        }
    }

    public void load(String path) {
        try {
            InputStream read = new FileInputStream(System.getProperty("user.dir") + "/teams/" + path + ".xml");
            properties.loadFromXML(read);
            name = properties.getProperty("Team Name");
            number = properties.getProperty("Team Number");
            read.close();
        } 
        catch (FileNotFoundException e) {
            save("Team Number", filePath);
            save("Team Name", "New Team");
            load(path);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failure to read file: Load");
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