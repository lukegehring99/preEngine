package userInterface;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Rename {

	static String teamName;
	static TextField enter;
	static Stage window;
	static String newName;
	
	public static String display()
	{

		window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Edit the sport name");
		
		enter = new TextField();
		enter.setText(Window.sport.getName());
		
		
		Button enterButton = new Button("Enter");
		enterButton.setOnAction(e -> enterPressed());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(enter, enterButton);
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
		newName = name;
		window.close();
		
	}
}
