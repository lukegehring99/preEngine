package userInterface;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import engine.*;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Controller implements Initializable{

	public Label sportLabel;
	public ToggleGroup teamSelect;
	public RadioButton team1;
	public RadioButton team2;
	public Label teamOneLabel;
	public Label teamTwoLabel;
	
	public ListView<String> teamList;

	
	private int state;
	private String teamOne;
	private String teamTwo;
	private String fileLocation;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		state = 0;
		sportLabel.setText(Window.sport.getName());
		
		
	}
	
	public void addTeam()
    {
		String temp = TeamEnter.display();
		if(temp == null)
		{
			return;
		}
    	Window.addTeam((temp));
    	teamList.getItems().add(temp);
    }
	
	public void addGame()
	{
		
	}
	
	
	public void teamOneSelected()
	{
		state = 1;
		teamList.getSelectionModel().clearSelection();
	}
	
	public void teamTwoSelected()
	{
		state = 2;
		teamList.getSelectionModel().clearSelection();
	}
	
	public void computeScore()
	{
		if(teamOne != null && teamTwo != null)
		{
			
		}
		else
		{
			System.out.println("Team can't be null");
		}
		
	}
	
	public void teamSelected()
	{
		System.out.println(state);
		if(state == 0)
		{
			// pull up the edit menu
		}
		else if(state == 1)
		{
			String temp = teamList.getSelectionModel().getSelectedItem();
			if(temp != null && !teamTwoLabel.getText().equals(temp))
			{
				teamOneLabel.setText(temp);
				state = 0;
			}
			teamList.getSelectionModel().clearSelection();

		}
		else if(state == 2)
		{
			String temp = teamList.getSelectionModel().getSelectedItem();
			if(temp != null && !teamOneLabel.getText().equals(temp))
			{
				teamTwoLabel.setText(temp);
				state = 0;
			}
			teamList.getSelectionModel().clearSelection();
		}
		
	}
	
	

	private Team getTeam(String name)
	{
		// This assumes the strings are unique
		return null;
	}
}
