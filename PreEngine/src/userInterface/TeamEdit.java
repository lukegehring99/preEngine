package userInterface;

import engine.Team;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TeamEdit 
{

	static String name;
	static Label label;
	static TextField enter;
	static Stage window;
	
	public static void display(String selection)
	{
		window = new Stage();
		

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(selection);
		
		Team team = Window.getTeam(selection);
		
		label = new Label("Games played by" + selection);
		
		
		
		Button editButton = new Button("Enter");
		//enterButton.setOnAction(e -> enterPressed());
		
		Button deleteButton = new Button("Delete");
		
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, editButton, deleteButton);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(10,10, 10, 10));
		
		Scene scene = new Scene(layout, 300, 150);
		window.setScene(scene);
		window.showAndWait();
		
	}
}
