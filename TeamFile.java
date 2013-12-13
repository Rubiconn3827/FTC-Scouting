import java.io.*;
import java.util.*;

public class TeamFile 
{
    private String filePath;
    private String name;
    private String number;
    private String wins;
    private String losses;
    private String penalties;
    private String irAutonomous;
    private String ramp;
    private String flagSpin;
    private String hang;
    private String pendulumScore;
    private String floorGoalScore;

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
            wins = properties.getProperty("Wins");
            losses = properties.getProperty("Losses");
            penalties = properties.getProperty("Penalties");
            irAutonomous = properties.getProperty("IR Autonomous");
            ramp = properties.getProperty("Ramp");
            flagSpin = properties.getProperty("Flag Spin");
            hang = properties.getProperty("Hang");
            pendulumScore = properties.getProperty("Pendulum Score");
            floorGoalScore = properties.getProperty("Floor Goal Score");
            read.close();
        } 
        catch (FileNotFoundException e) 
        {
            save("Team Number", filePath);
            save("Team Name", "New Team");
            save("Wins", "0");
            save("Losses", "0");
            save("Penalties", "0");
            save("IR Autonomous", "0");
            save("Ramp", "0");
            save("Flag Spin", "0");
            save("Hang", "0");
            save("Pendulum Score", "0");
            save("Floor Goal Score", "0");
            load(path);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failure to read file: Load");
        }
    }

    public String getName()
    {
        return name;
    }

    public String getNumber()
    {
        return number;
    }

    public String getWins()
    {
        return wins;
    }

    public String getLosses()
    {
        return losses;
    }

    public String getPenalties()
    {
        return penalties;
    }

    public String getIRAutonomous()
    {
        return irAutonomous;
    }

    public String getRamp()
    {
        return ramp;
    }

    public String getFlagSpin()
    {
        return flagSpin;
    }

    public String getHang()
    {
        return hang;
    }

    public String getPendulumScore()
    {
        return pendulumScore;
    }

    public String getFloorGoalScore()
    {
        return floorGoalScore;
    }

    public void changeName(String temp)
    {
        name = temp;
        save("Team Name", name);
    }

    public void changeNumber(String temp)
    {
        number = temp;
        save("Team Number", number);
    }

    public void changeWins(String temp)
    {
        wins = temp;
        save("Wins", wins);
    }

    public void changeLosses(String temp)
    {
        losses = temp;
        save("Losses", losses);
    }

    public void changePenalties(String temp)
    {
        penalties = temp;
        save("Penalties", penalties);
    }

    public void changeIRAutonomous(String temp)
    {
        irAutonomous = temp;
        save("IR Autonomous", irAutonomous);
    }

    public void changeRamp(String temp)
    {
        ramp = temp;
        save("Ramp", "0");
    }

    public void changeFlagSpin(String temp)
    {
        flagSpin = temp;
        save("Flag Spin", flagSpin);
    }

    public void changeHang(String temp)
    {
        hang = temp;
        save("Hang", "0");
    }

    public void changePendulumScore(String temp)
    {
        pendulumScore = temp;
        save("Pendulum Score", "0");
    }

    public void changeFloorGoalScore(String temp)
    {
        floorGoalScore = temp;
        save("Floor Goal Score", "0");
    }
}