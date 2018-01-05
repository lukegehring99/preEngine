package userInterface;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GameEdit {

	static String name;
	static Label label;
	static TextField enter;
	static Stage window;
	
	public static void display(String selection)
	{
		window = new Stage();
		
		label = new Label("The team name must be unique.");
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(selection);
		
		enter = new TextField();
		enter.setPromptText("Enter a team name");
		
		
		Button enterButton = new Button("Enter");
		//enterButton.setOnAction(e -> enterPressed());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(enter, enterButton, label);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(10,10, 10, 10));
		
		Scene scene = new Scene(layout, 300, 150);
		window.setScene(scene);
		window.showAndWait();
		
	}
	
}
