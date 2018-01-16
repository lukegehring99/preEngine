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
	
	public static void display(HBox game)
	{
		
		String team1 = ((Label) game.getChildren().get(0)).getText();
		int team1Score = Integer.parseInt(((Label) game.getChildren().get(1)).getText());
		
		int team2Score = Integer.parseInt(((Label) game.getChildren().get(3)).getText());
		String team2 = ((Label) game.getChildren().get(4)).getText();
		
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
		
		team2ScoreInput = new TextField();
		team2ScoreInput.setText(Integer.toString(team2Score));
		
		fields = new HBox();
		fields.getChildren().addAll(team1Name, team1ScoreInput, team2ScoreInput, team2Name);
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, fields, enterButton, deleteButton);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(10,10, 10, 10));
		
		Scene scene = new Scene(layout, 300, 150);
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
		
	}
}
