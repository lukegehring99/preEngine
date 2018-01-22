package userInterface;

import engine.Comparison;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DegreeEdit {

	
	static String teamName;
	static Label label;
	static TextField enter;
	static Stage window;
	static int newDegree;
	
	public static void display()
	{
		window = new Stage();
		
		label = new Label("Must be an integer");
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Edit the degree");
		
		enter = new TextField();
		enter.setText(Integer.toString(Comparison.getMaxdegree()));
		
		
		Button enterButton = new Button("Enter");
		enterButton.setOnAction(e -> enterPressed());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(enter, enterButton, label);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(10,10, 10, 10));
		
		Scene scene = new Scene(layout, 300, 150);
		window.setScene(scene);
		window.showAndWait();
		
		
		
		
	}
	
	public static void enterPressed()
	{
		
		try
		{
			newDegree = Integer.parseInt(enter.getText());
			Comparison.setMaxdegree(newDegree);
			window.close();
		}
		catch(Exception e)
		{
			label.setText("The number must be an integer!");
		}
		
		
	}
}
