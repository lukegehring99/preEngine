package userInterface;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class About {

	static String teamName;
	static Stage window;
	
	public static void display()
	{
		window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Edit the degree");
		
		Text text = new Text(10, 10, "Test");
		text.setWrappingWidth(300);
		text.setText("A user interface for a algorithm developed to predict the score for two team sport games. I developed this algorithm because I enjoy watching and making brackets for March Madness but don't appreciate the amount of time I would have to spend to make my bracket competitive. Naturally I like being the best and here lies the motivation for developing this program.");
		
		Label label1 = new Label("Build by Luke Gehring");
		Label label2 = new Label("2018");
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(text, label1, label2);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(10,10, 10, 10));
		
		Scene scene = new Scene(layout, 350, 250);
		window.setScene(scene);
		window.showAndWait();
		
		
		
		
	}
	
}
