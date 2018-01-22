package userInterface;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import engine.*;
import javafx.fxml.Initializable;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
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
	
	public ScatterChart<Number, Number> chart;
	
	public ListView<String> teamList;

	
	private int state;
	private Team teamOne;
	private Team teamTwo;
	private String fileLocation;
	
	
	private class Node 
	{
		private int frequency;
		private int value;

		private Node(int frequency, int value) {
			this.frequency = frequency;
			this.value = value;
		}
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		state = 0;
		sportLabel.setText(Window.sport.getName());
		chart.getXAxis().setLabel("Score Difference");
		chart.getYAxis().setLabel("Frequency");
		
		chart.getXAxis().setTickLength(1);
		chart.getYAxis().setTickLength(1);
		
		
		
		
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
	
	ArrayList<int[]> results;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void computeScore()
	{
		if(teamOne != null && teamTwo != null)
		{
			results = Window.generateResults(teamOne, teamTwo);
			printArray(results);
			chart.setTitle(teamOne.getName() + " vs " + teamTwo.getName());
			
			
			ArrayList<ArrayList<Node>> values = new ArrayList<ArrayList<Node>>();
			for(int[] list : results)
			{
				values.add(arrayToDistribution(list));
			}
			
			int maxFreq = 0;
			int maxValue = 0;
			int minValue = 0;
			
			for(ArrayList<Node> temp : values)
			{
				Node max = getMaxValue(temp);
				Node min = getMinValue(temp);
				
				if(maxFreq < max.frequency)
				{
					maxFreq = max.frequency;
				}
				
				if(maxValue < max.value)
				{
					maxValue = max.value;
				}
				
				if(minValue > min.value)
				{
					minValue = min.value;
				}
			}
			
			
			int counter = 0;
			
			for(ArrayList<Node> level : values)
			{
				XYChart.Series series = new XYChart.Series();
				series.setName("Level " + Integer.toString(counter));
				counter++;
				
				for(Node node : level)
				{
					series.getData().add(new XYChart.Data(node.value, node.frequency));
					chart.getData().add(series);
				}
			}
			
			
		}
		else
		{
			System.out.println("Team can't be null");
		}
		System.out.println("Finished");
		
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
		
		if(fileLocation != null)
		{
			Window.save(fileLocation);
		}
	}
	
	
	public void save()
	{
		if(fileLocation == null)
		{
			fileLocation = getFolderPath();
			if(fileLocation != null)
			{
				Window.save(fileLocation);
			}
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
		fileLocation = path;
		if(fileLocation != null)
		{
			Window.load(path);
			initialize(null, null);
			refreshTeams();
		}
	}
	
	public void newSport()
	{
		fileLocation = null;
		Window.reset();
		initialize(null, null);
		refreshTeams();
	}
	
	public void close()
	{
		Window.close();
	}
	
	public void degree()
	{
		DegreeEdit.display();
	}
	
	public void about()
	{
		About.display();
	}
	
	public void rename()
	{
		String name = Rename.display();
		if(name != null)
		{
			Window.sport.setName(name);
			initialize(null, null);
		}

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
        
        if(f.getSelectedFile() != null)
        {
        	return f.getSelectedFile().getAbsolutePath();
        }
        
		return null;
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
        if(f.getSelectedFile() != null)
        {
        	return f.getSelectedFile().getAbsolutePath();
        }
		return null;

	}
	
	
	
	
	private static void printArray(ArrayList<int[]> temp)
	{
		for(int j = 0; j < temp.size(); j++)
		{
			int[] array = temp.get(j);
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


	private ArrayList<Node> arrayToDistribution(int[] scores) {
		ArrayList<Node> distribution = new ArrayList<Node>();

		boolean isAdded = false;
		
		for (int i = 0; i < scores.length; i++) 
		{
			isAdded = false;
			for (int j = 0; j < distribution.size(); j++) 
			{
				if (scores[i] == distribution.get(j).value) 
				{
					distribution.get(j).frequency += 1;
					isAdded = true;
				}
			}
			if(!isAdded)
			{
				distribution.add(new Node(1, scores[i]));
			}
		}

		return distribution;
	}
	
	private Node getMaxValue(ArrayList<Node> values)
	{
		int maxFreq = 0;
		int maxValue = 0;
		
		for(Node node : values)
		{
			if(node.frequency > maxFreq)
			{
				maxFreq = node.frequency;
			}
			if(node.value > maxValue)
			{
				maxValue = node.value;
			}
		}
		
		return new Node(maxFreq, maxValue);
	}
	
	private Node getMinValue(ArrayList<Node> values)
	{
		int minFreq = 0;
		int minValue = 0;
		
		for(Node node : values)
		{
			if(node.frequency < minFreq)
			{
				minFreq = node.frequency;
			}
			if(node.value < minValue)
			{
				minValue = node.value;
			}
		}
		
		return new Node(minFreq, minValue);
	}
	
}
