package userInterface;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Controller implements Initializable{

	public Label sportLabel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		sportLabel.setText(Window.sport.getName());

		
	}
	

	
}
