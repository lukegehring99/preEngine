package userInterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.util.ArrayList;

import engine.*;

public class Window extends Application
{
	
	public static Sport sport;

	
	public static void main(String[] args) {
		
		sport = new Sport("Default");

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setTitle("Prediction Engine");
        primaryStage.setScene(new Scene(root, 950, 600));
        primaryStage.show();
    }
    
    public static void addTeam(String name)
    {
    	sport.addTeam(new Team(name));
    }
    
    public static void addGame(Game game)
    {
    	sport.addGame(game);
    }
    
    public static boolean isUnique(String name)
    {
    	Roster temp = sport.getRoster();
    	ArrayList<Team> all = temp.getTeams();
    	
    	for(Team team : all)
    	{
    		if(team.getName().equals(name))
    		{
    			return false;
    		}
    	}
    	return true;
    }
    
    public static ArrayList<String> getTeams()
    {
    	ArrayList<String> temp = new ArrayList<String>();
    	
    	for(Team team : sport.getRoster().getTeams())
    	{
    		temp.add(team.getName());
    	}
    	
    	return temp;
    	
    }
    
    
    
    public static Team getTeam(String name)
    {
    	for(Team team : sport.getRoster().getTeams())
    	{
    		if(name.equals(team.getName()))
    		{
    			return team;
    		}
    	}
    	return null;

    }
    
    public static ArrayList<Game> getGamesPlayedBy(Team team)
    {
    	return sport.getGameField().getAllGamesPlayedPointer(team);
    }
    
    public static void delete(Team team)
    {
    	sport.deleteTeam(team);
    	
    }
    
    public static Game getGame(String team1, int team1Score, String team2, int team2Score)
    {
    	ArrayList<Game> games = getGamesPlayedBy(getTeam(team1));
    	
    	for(Game game: games)
    	{
    		if(game.getTeam1().getName().equals(team1))
    		{
    			if(game.getTeam2().getName().equals(team2))
    			{
    				if(((int)game.getTeam1Score()) == team1Score && ((int)game.getTeam2Score()) == team2Score)
    				{
    					return game;
    				}
    			}
    		}
    		else
    		{
    			if(game.getTeam1().getName().equals(team2))
    			{
    				if(((int)game.getTeam1Score()) == team2Score && ((int)game.getTeam2Score()) == team1Score)
    				{
    					return game;
    				}
    			}
    		}
    	}
    	
    	
    	return null;
    }

	public static void deleteGame(Game game)
	{
		sport.deleteGame(game);
	}
	
	public static ArrayList<double[]> generateResults(Team team1, Team team2)
	{
		return sport.generatePathway(team1, team2);
	}
	
	public static void save(String path)
	{
		// clear the file at the location, if no file, continue
		// save the new file at the specified path with the specified name 
		DataExport export = new DataExport(path + "\\");
		export.serializeSport(sport);
	}
	
	public static void load(String path)
	{
		DataImport in = new DataImport(path);
		sport = in.deserialzeSport();
		
		// refresh the everything
	}
}
