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
		
		sport = new Sport("College Division 1 Basketball");

		
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

	
	
}
