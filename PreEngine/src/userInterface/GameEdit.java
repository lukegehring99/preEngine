package userInterface;

import engine.Game;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GameEdit {

	static String name;
	static Label label;
	static Stage window;
	static HBox fields;
	
	static Label team1Name;
	static Label team2Name;
	
	static TextField team1ScoreInput;
	static TextField team2ScoreInput;
	
	static Button deleteButton;
	
	static Game selected;
	
	static String team1;
	static String team2;
	
	public static void display(HBox game)
	{
		
		team1 = ((Label) game.getChildren().get(0)).getText();
		int team1Score = Integer.parseInt(((Label) game.getChildren().get(1)).getText());
		
		int team2Score = Integer.parseInt(((Label) game.getChildren().get(3)).getText());
		team2 = ((Label) game.getChildren().get(4)).getText();
		
		selected = Window.getGame(team1, team1Score, team2, team2Score);
		System.out.println(selected);
		
		window = new Stage();
		
		deleteButton = new Button("Delete");
		deleteButton.setOnAction(e -> deleteGame());
		
		Button enterButton = new Button("Enter");
		enterButton.setOnAction(e -> enterPressed());
		
		label = new Label("Edit the game");
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Edit the game");
		
		team1Name = new Label(team1);
		team2Name = new Label(team2);
		
		team1ScoreInput = new TextField();
		team1ScoreInput.setText(Integer.toString(team1Score));
		team1ScoreInput.setMaxWidth(100);
		
		team2ScoreInput = new TextField();
		team2ScoreInput.setText(Integer.toString(team2Score));
		team2ScoreInput.setMaxWidth(100);
		
		fields = new HBox();
		fields.setSpacing(10);
		fields.getChildren().addAll(team1Name, team1ScoreInput, team2ScoreInput, team2Name);
		fields.setAlignment(Pos.CENTER);
		
		
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(10, 10, 10, 10));
		layout.getChildren().addAll(label, fields, enterButton, deleteButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, 500, 150);
		window.setScene(scene);
		window.showAndWait();
		
	}
	
	
	public static void deleteGame()
	{
		Window.deleteGame(selected);
		window.close();
	}
	
	public static void enterPressed()
	{
		if(team1.equals(selected.getTeam1().getName()))
		{
			selected.setTeam1Score(Double.parseDouble(team1ScoreInput.getText()));
			selected.setTeam2Score(Double.parseDouble(team2ScoreInput.getText()));
		}
		else
		{
			selected.setTeam1Score(Double.parseDouble(team2ScoreInput.getText()));
			selected.setTeam2Score(Double.parseDouble(team1ScoreInput.getText()));
		}
		window.close();
	}
}
