package userInterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import engine.*;

public class Window extends Application
{
	
	public static Sport sport;
	
	public static void main(String[] args) {
		
		sport = new Sport("College Division 1 Basketball");
		
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 950, 600));
        primaryStage.show();
    }

	
	
}
