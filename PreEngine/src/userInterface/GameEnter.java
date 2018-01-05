package userInterface;

import engine.Game;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GameEnter {


	static String name;
	static Label label;
	static Stage window;
	static TextField teamOneScore;
	static TextField teamTwoScore;
	static ComboBox<String> teamOneSelect;
	static ComboBox<String> teamTwoSelect;
	
	static Game newGame;
	
	public static Game display()
	{
		window = new Stage();
		
		label = new Label("The team name must be unique.");
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Enter a Game");

		Button enterButton = new Button("Enter");
		enterButton.setOnAction(e -> enterPressed());
		
		VBox layout = new VBox(10);
		HBox teamOneEnter = new HBox();
		HBox teamTwoEnter = new HBox();
		
		
		teamOneSelect = new ComboBox<>();
		teamOneSelect.getItems().addAll(Window.getTeams());
		teamOneSelect.setPromptText("Select Team One");
		teamOneScore = new TextField();
		teamOneScore.setPromptText("Score");
		Region top = new Region();
		HBox.setHgrow(top, Priority.ALWAYS);
		
		
		teamTwoSelect = new ComboBox<>();
		teamTwoSelect.getItems().addAll(Window.getTeams());
		teamTwoSelect.setPromptText("Select Team Two");
		teamTwoScore = new TextField();
		teamTwoScore.setPromptText("Score");
		Region bottom = new Region();
		HBox.setHgrow(bottom, Priority.ALWAYS);
		
		teamOneEnter.getChildren().addAll(teamOneSelect, top, teamOneScore);
		teamOneEnter.setPadding(new Insets(10, 10, 10, 10));
		teamTwoEnter.getChildren().addAll(teamTwoSelect, bottom, teamTwoScore);
		teamTwoEnter.setPadding(new Insets(10, 10, 10, 10));
		
		layout.getChildren().addAll(label, teamOneEnter, teamTwoEnter, enterButton);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(10,10, 10, 10));
		
		Scene scene = new Scene(layout, 350, 180);
		window.setScene(scene);
		window.showAndWait();
		
		return newGame;
		

		
	}
	
	private static void enterPressed()
	{
		String teamOne = teamOneSelect.getSelectionModel().getSelectedItem();
		String teamTwo = teamTwoSelect.getSelectionModel().getSelectedItem();
		boolean valid = true;
		
		int teamOnePoints = 0;
		int teamTwoPoints = 0;
		
		try
		{
			teamOnePoints = Integer.parseInt(teamOneScore.getText());
			teamTwoPoints = Integer.parseInt(teamTwoScore.getText());
		}
		catch (Exception e)
		{
			label.setText("The scores must be an integer");
			valid = false;
		}
		
		
		if(teamOne == null)
		{
			teamOneSelect.setPromptText("Team not selected!");
			valid = false;
		}
		if(teamTwo == null)
		{
			teamTwoSelect.setPromptText("Team not selected!");
			valid = false;
		}
		
		if(valid)
		{
			newGame = new Game(Window.getTeam(teamOne), teamOnePoints, Window.getTeam(teamTwo), teamTwoPoints);
			window.close();
		}
		else
		{
			return;
		}
		
		
	}
}
