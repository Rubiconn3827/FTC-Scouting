import java.io.*;
import java.util.*;

public class TeamFile {

    Properties properties = new Properties();
    public void save(String key, String value) {

        String path = "teams/" + GUI.teamNumber.getText() + ".xml";
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

    public void load(String path) {
        try {
            InputStream read = new FileInputStream(path);
            properties.loadFromXML(read);
            String teamName = properties.getProperty("Team Name");
            String teamNumber = properties.getProperty("Team Number");
            String numberOfWins = properties.getProperty("Number of Wins");
            String numberOfLosses = properties.getProperty("Number of Losses");
            String averageScore = properties.getProperty("Average Score");
            String averageDifference = properties.getProperty("Average Difference");
            String allianceScore = properties.getProperty("Alliance Scores");
            String opponentsScore = properties.getProperty("Opponents Scores");
            setTeamDetails(teamName, teamNumber, Integer.parseInt(numberOfWins), Integer.parseInt(numberOfLosses), Integer.parseInt(averageScore), Integer.parseInt(averageDifference), allianceScore, opponentsScore);
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
            save("Team Name", "New Team");
            save("Team Number", GUI.teamNumber.getText());
            save("Number of Wins", "0");
            save("Number of Losses", "0");
            save("Average Score", "0");
            save("Average Difference", "0");
            save("Alliance Scores", "0 ");
            save("Opponents Scores", "0 ");
            load(path);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failure to read file.");
        }
    }

    public void setTeamDetails(String name, String number, int wins, int losses, int avgScore, int avgDiff, String allScores, String oppScores) {
        TeamWindow.teamName = name;
        TeamWindow.teamNumber = number;
        TeamWindow.numberOfWins = wins;
        TeamWindow.numberOfLosses = losses;
        TeamWindow.averageScore = avgScore;
        TeamWindow.averageDifference = avgDiff;
        TeamWindow.allianceScoreString = allScores;
        TeamWindow.opponentsScoreString = oppScores;
    }

}