package userInterface;

import java.util.ArrayList;

import engine.Game;
import engine.Team;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TeamEdit 
{

	static String name;
	static Label label;
	static TextField enter;
	static Stage window;
	
	static int state;
	
	static Team team;
	
	static ListView<HBox> table;
	
	public static void display(String selection)
	{
		state = 0;
		name = selection;
		
		window = new Stage();
		

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(selection);
		
		team = Window.getTeam(selection);
		ArrayList<Game> games = Window.getGamesPlayedBy(team);
		
		table = new ListView<>();
		table.setOnMouseClicked(e -> teamSelected());
		table.setMaxWidth(470);
		
		label = new Label("Games played by " + selection);
		
		for(Game game: games)
		{
			Label teamOneName = new Label();
			teamOneName.setMinWidth(100);
			teamOneName.setMaxWidth(100);
			
			Label teamTwoName = new Label();
			teamTwoName.setMinWidth(100);
			teamTwoName.setMaxWidth(100);
			teamTwoName.setAlignment(Pos.CENTER_RIGHT);
			
			Label teamOneScore = new Label();
			teamOneScore.setMinWidth(100);
			teamOneScore.setMaxWidth(100);
			teamOneScore.setAlignment(Pos.CENTER_RIGHT);
			
			Label teamTwoScore = new Label();
			teamTwoScore.setMinWidth(100);
			teamTwoScore.setMaxWidth(100);
			
			Label dash = new Label("-");
			dash.setMinWidth(40);
			dash.setMaxWidth(40);
			dash.setAlignment(Pos.CENTER);
			
			if(game.getTeam1().getName().equals(selection))
			{
				teamOneName.setText(game.getTeam1().getName());
				teamOneScore.setText(Integer.toString((int) game.getTeam1Score()));
				teamTwoName.setText(game.getTeam2().getName());
				teamTwoScore.setText(Integer.toString((int) game.getTeam2Score()));
			}
			else
			{
				teamOneName.setText(game.getTeam2().getName());
				teamOneScore.setText(Integer.toString((int) game.getTeam2Score()));
				teamTwoName.setText(game.getTeam1().getName());
				teamTwoScore.setText(Integer.toString((int) game.getTeam1Score()));
			}
			
			
			HBox line = new HBox();
			line.getChildren().addAll(teamOneName, teamOneScore, dash, teamTwoScore, teamTwoName);
			table.getItems().add(line);
		}
		
		
		Button editButton = new Button("Edit");
		editButton.setOnAction(e -> editPressed(name));
		
		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction(e -> deletePressed());
		
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, table, editButton, deleteButton);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(10,10, 10, 10));
		
		Scene scene = new Scene(layout, 550, 350);
		window.setScene(scene);
		window.showAndWait();
		
	}
	
	public static void deletePressed()
	{
		Window.delete(team);
		window.close();
	}
	
	public static void editPressed(String nameOld)
	{
		String newTeam = NameEdit.display(nameOld);
		window.setTitle(newTeam);
		label.setText("Games played by " + newTeam);
		name = newTeam;
		
		// Refresh the game list
		ArrayList<Game> games = Window.getGamesPlayedBy(team);
		table.getItems().clear();
		
		for(Game game: games)
		{
			Label teamOneName = new Label();
			teamOneName.setMinWidth(100);
			teamOneName.setMaxWidth(100);
			
			Label teamTwoName = new Label();
			teamTwoName.setMinWidth(100);
			teamTwoName.setMaxWidth(100);
			teamTwoName.setAlignment(Pos.CENTER_RIGHT);
			
			Label teamOneScore = new Label();
			teamOneScore.setMinWidth(100);
			teamOneScore.setMaxWidth(100);
			teamOneScore.setAlignment(Pos.CENTER_RIGHT);
			
			Label teamTwoScore = new Label();
			teamTwoScore.setMinWidth(100);
			teamTwoScore.setMaxWidth(100);
			
			Label dash = new Label("-");
			dash.setMinWidth(40);
			dash.setMaxWidth(40);
			dash.setAlignment(Pos.CENTER);
			
			if(game.getTeam1().getName().equals(name))
			{
				teamOneName.setText(game.getTeam1().getName());
				teamOneScore.setText(Integer.toString((int) game.getTeam1Score()));
				teamTwoName.setText(game.getTeam2().getName());
				teamTwoScore.setText(Integer.toString((int) game.getTeam2Score()));
			}
			else
			{
				teamOneName.setText(game.getTeam2().getName());
				teamOneScore.setText(Integer.toString((int) game.getTeam2Score()));
				teamTwoName.setText(game.getTeam1().getName());
				teamTwoScore.setText(Integer.toString((int) game.getTeam1Score()));
			}
			
			
			HBox line = new HBox();
			line.getChildren().addAll(teamOneName, teamOneScore, dash, teamTwoScore, teamTwoName);
			table.getItems().add(line);
		}
	}
	
	static HBox selected;
	
	private static void teamSelected()
	{
		if(state == 0)
		{
			selected = table.getSelectionModel().getSelectedItem();
			state = 1;
		}
		else if(state == 1)
		{
			if(table.getSelectionModel().getSelectedItem() == selected)
			{
				
				GameEdit.display(selected);
				state = 0;
			}
			else
			{
				state = 0;
			}
		}
	}
}
