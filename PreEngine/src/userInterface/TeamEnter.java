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

public class TeamEnter {

	static String name;
	static Label label;
	static TextField enter;
	static Stage window;
	
	public static String display()
	{
		window = new Stage();
		
		label = new Label("The team name must be unique.");
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Enter a Team");
		
		enter = new TextField();
		enter.setPromptText("Enter a team name");
		
		
		Button enterButton = new Button("Enter");
		enterButton.setOnAction(e -> enterPressed());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(enter, enterButton, label);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(10,10, 10, 10));
		
		Scene scene = new Scene(layout, 200, 150);
		window.setScene(scene);
		window.showAndWait();
		
		if(Window.isUnique(name))
		{
			return name;
		}
		else
		{
			return null;
		}
		
	}
	
	private static void enterPressed()
	{
		String temp = enter.getText();
		if(!temp.equals("") && !temp.equals(" "))
		{
			if(Window.isUnique(temp))
			{
				name = temp;
				window.close();
			}
			else
			{
				label.setText("The name entered isn't unique!");
			}
			
		}
		else
		{
			// Do nothing
		}
	}
	
	
}
