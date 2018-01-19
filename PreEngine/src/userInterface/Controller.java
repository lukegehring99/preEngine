package userInterface;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import engine.*;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Controller implements Initializable{

	public Label sportLabel;
	public ToggleGroup teamSelect;
	public RadioButton team1;
	public RadioButton team2;
	public Label teamOneLabel;
	public Label teamTwoLabel;
	
	public ListView<String> teamList;

	
	private int state;
	private Team teamOne;
	private Team teamTwo;
	private String fileLocation;
	private String name;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		state = 0;
		sportLabel.setText(Window.sport.getName());
		name = Window.sport.getName();
		
	}
	
	public void addTeam()
    {
		String temp = TeamEnter.display();
		if(temp == null)
		{
			return;
		}
    	Window.addTeam((temp));
    	teamList.getItems().add(temp);
    }
	
	public void addGame()
	{
		Game game = GameEnter.display();
		
		if(game == null)
		{
			return;
		}
		
		Window.addGame(game);
		
	}
	
	
	public void teamOneSelected()
	{
		state = 1;
		teamList.getSelectionModel().clearSelection();
	}
	
	public void teamTwoSelected()
	{
		state = 2;
		teamList.getSelectionModel().clearSelection();
	}
	
	ArrayList<double[]> results;
	
	public void computeScore()
	{
		if(teamOne != null && teamTwo != null)
		{
			results = Window.generateResults(teamOne, teamTwo);
			printArray(results);
		}
		else
		{
			System.out.println("Team can't be null");
		}
		
	}
	
	private String selectedItem;
	
	public void teamSelected()
	{
		
		if(state == 3)
		{
			if(selectedItem.equals(teamList.getSelectionModel().getSelectedItem()))
			{
				TeamEdit.display(selectedItem);
				refreshTeams();
			}
			state = 0;
			return;
		}
		
		if(state == 0)
		{
			selectedItem = teamList.getSelectionModel().getSelectedItem();
			if(selectedItem == null)
			{
				return;
			}
			state = 3;
		}
		else if(state == 1)
		{
			String temp = teamList.getSelectionModel().getSelectedItem();
			if(temp != null && !teamTwoLabel.getText().equals(temp))
			{
				teamOne = Window.getTeam(temp);
				teamOneLabel.setText(temp);
				state = 0;
			}
			teamList.getSelectionModel().clearSelection();
			team1.setSelected(false);

		}
		else if(state == 2)
		{
			String temp = teamList.getSelectionModel().getSelectedItem();
			if(temp != null && !teamOneLabel.getText().equals(temp))
			{
				teamTwo = Window.getTeam(temp);
				teamTwoLabel.setText(temp);
				state = 0;
			}
			teamList.getSelectionModel().clearSelection();
			team2.setSelected(false);
		}
		
	}
	
	public void deleted(String name)
	{
		teamList.getItems().remove(name);
	}
	
	private void refreshTeams()
	{
		teamList.getItems().clear();
		teamList.getItems().addAll(Window.getTeams());
	}
	
	public void saveAs()
	{
		//System.out.println("Save as pressed");
		String path = getFolderPath();
		fileLocation = path;
		System.out.println(path);
		save();
	}
	
	
	public void save()
	{
		if(fileLocation == null)
		{
			getFolderPath();
			Window.save(fileLocation);
		}
		else
		{
			System.out.println("saving");
			Window.save(fileLocation);
		}
	}
	
	public void open()
	{
		String path = getFilePath();
		Window.load(path);
		initialize(null, null);
		refreshTeams();
	}
	
	public void newSport()
	{
		
	}
	
	public void close()
	{
		
	}
	
	public void degree()
	{
		
	}
	
	public void about()
	{
		
	}
	
	private String getFolderPath()
	{
		String path = System.getProperty("user.home") + "\\Documents";
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JFileChooser f = new JFileChooser(path);
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        f.showSaveDialog(null);

        //System.out.println(f.getSelectedFile());
		return f.getSelectedFile().getAbsolutePath();
	}
	
	
	private String getFilePath()
	{
		String path = System.getProperty("user.home") + "\\Documents";
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JFileChooser f = new JFileChooser(path);
        f.setFileSelectionMode(JFileChooser.FILES_ONLY); 
        f.showSaveDialog(null);

        //System.out.println(f.getSelectedFile());
		return f.getSelectedFile().getAbsolutePath();

	}
	
	
	
	
	private static void printArray(ArrayList<double[]> temp)
	{
		for(int j = 0; j < temp.size(); j++)
		{
			double[] array = temp.get(j);
			System.out.print("[");
			for(int i = 0; i < array.length; i++)
			{
				if(!(i == array.length-1))
				{
					System.out.print(array[i] + ", ");
				}
				else
				{
					System.out.print(array[i]);
				}
			}
			System.out.println("]");
		}
	}


}
