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

public class NameEdit {

	static String teamName;
	static Label label;
	static TextField enter;
	static Stage window;
	static String newName;
	
	public static String display(String name)
	{
		teamName = name;
		window = new Stage();
		
		label = new Label("Edit the team name");
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(name);
		
		enter = new TextField();
		enter.setText(name);
		
		
		Button enterButton = new Button("Enter");
		enterButton.setOnAction(e -> enterPressed());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(enter, enterButton, label);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(10,10, 10, 10));
		
		Scene scene = new Scene(layout, 300, 150);
		window.setScene(scene);
		window.showAndWait();
		
		return newName;
		
		
		
	}
	
	public static void enterPressed()
	{
		
		
		String name = enter.getText();
		if(Window.isUnique(name))
		{
			Window.getTeam(teamName).setName(enter.getText());
			newName = name;
			window.close();
		}
		else
		{
			label.setText("The team name must be unique");
		}
	}
}
