import java.io.*;
import java.util.*;

public class MatchFile {
    private String filePath;
    private String regional;
    private String date;
    private String matchNumber;
    private String redPoints;
    private String bluePoints;
    private String redPenalties;
    private String bluePenalties;
    private String redAllianceOne;
    private String redAllianceTwo;
    private String blueAllianceOne;
    private String blueAllianceTwo;

    public MatchFile(String regional, String number)
    {
        filePath = number;
        this.regional = regional;
        date = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        matchNumber = number;
        load();
    }

    Properties properties = new Properties();
    public void save(String key, String value) 
    {
        String path = System.getProperty("user.dir") + "/matches/" + regional + "/" + matchNumber + ".xml";
        try {
            File file = new File(path);
            boolean exist = file.exists();
            if(!exist) {
                file.createNewFile();
            }
            OutputStream write = new FileOutputStream(path);
            properties.setProperty(key, value);
            properties.storeToXML(write, regional + ": " + matchNumber);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to save the team's file.");
        }
    }

    public void load() 
    {
        try 
        {
            InputStream read = new FileInputStream(System.getProperty("user.dir") + "/matches/" + regional + "/" + matchNumber + ".xml");
            properties.loadFromXML(read);
            redPoints = properties.getProperty("Red Points");
            bluePoints = properties.getProperty("Blue Points");
            redPenalties = properties.getProperty("Red Penalties");
            bluePenalties = properties.getProperty("Blue Penalties");
            redAllianceOne = properties.getProperty("Red Alliance One");
            blueAllianceOne = properties.getProperty("Blue Alliance One");
            redAllianceTwo = properties.getProperty("Red Alliance Two");
            blueAllianceTwo = properties.getProperty("Blue Alliance Two");
            read.close();
        } 
        catch (FileNotFoundException e) 
        {
            //System.out.println("File not Found: Load");
            save("Regional", regional);
            save("Date", date);
            save("Match Number", matchNumber);
            save("Red Points", "0");
            save("Blue Points", "0");
            save("Red Penalties", "0");
            save("Blue Penalties", "0");
            save("Red Total", "0");
            save("Blue Total", "0");
            save("Red Alliance One", "0");
            save("Blue Alliance One", "0");
            save("Red Alliance Two", "0");
            save("Blue Alliance Two", "0");
            load();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failure to read file: Load");
        }
    }

    public String getRegional()
    {
        return regional;
    }

    public String getDate()
    {
        return date;
    }

    public String getMatchNumber()
    {
        return matchNumber;
    }

    public String getRedPoints()
    {
        return redPoints;
    }

    public String getBluePoints()
    {
        return bluePoints;
    }

    public String getRedPenalties()
    {
        return redPenalties;
    }

    public String getBluePenalties()
    {
        return bluePenalties;
    }

    public String getRedAllianceOne()
    {
        return redAllianceOne;
    }

    public String getRedAllainceTwo()
    {
        return redAllianceTwo;
    }

    public String getBlueAllianceOne()
    {
        return blueAllianceOne;
    }

    public String getBlueAllainceTwo()
    {
        return blueAllianceTwo;
    }

    public void updateDate()
    {
        date = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        save("Date", date);
    }

    public void setMatchNumber(String number)
    {
        matchNumber = number;
        save("Match Number", matchNumber);
    }

    public void setRedPoints(String temp)
    {
        redPoints = temp;
        save("Red Points", redPoints);
    }

    public void setBluePoints(String temp)
    {
        bluePoints = temp;
        save("Blue Points", bluePoints);
    }

    public void setRedPenalties(String temp)
    {
        redPenalties = temp;
        save("Red Penalties", redPenalties);
    }

    public void setBluePenalties(String temp)
    {
        bluePenalties = temp;
        save("Blue Penalties", bluePenalties);
    }

    public void setRedAllianceOne(String temp)
    {
        redAllianceOne = temp;
        save("Red Alliance One", redAllianceOne);
    }

    public void setBlueAllianceOne(String temp)
    {
        blueAllianceOne = temp;
        save("Blue Alliance One", blueAllianceOne);
    }

    public void setRedAllianceTwo(String temp)
    {
        redAllianceTwo = temp;
        save("Red Alliance Two", redAllianceTwo);
    }

    public void setBlueAllianceTwo(String temp)
    {
        blueAllianceTwo = temp;
        save("Blue Alliance Two", blueAllianceTwo);
    }
}