package engine;

import java.util.ArrayList;


public class Sport {

	private ArrayList<GameField> gameFields = new ArrayList<GameField>();     // Container for the GameFields 
	private ArrayList<Roster> rosters = new ArrayList<Roster>();              // Container for the Rosters
	
	private int id;                                 // Unique Id representing the sport
	private String name;                            // Official name of the sport
	private static int[] indexes = new int[0];      // Static list of the Ids to be used to get the index of sport being used for method calls 
	
	
	/**
	 * Class constructor.
	 * Creates a sport object that contains the GameField and Roster.
	 * Initializes the id and name variables and adds the respective id to indexes array.
	 * 
	 * @param id This is a unique id representing the sport used
	 * @param name The official name of the sport
	 */
	public Sport(int id, String name)
	{
		this.id = id;
		this.name = name;
		
		gameFields.add(new GameField());
		rosters.add(new Roster());
		
		addValue(indexes, this.id);
	}
	
	
	/**
	 * Adds a Game to the GameField for the sport defined by id.
	 * 
	 * @param game The Game being added to the GameField
	 * @param idSport The Sport the Game is being added to
	 */
	public void addGame(Game game, int idSport)
	{
		gameFields.get(getIndex(idSport)).add(game);
	}
	
	
	/**
	 * Adds a Team to the Roster for the sport defined by id.
	 * 
	 * @param team The Team being added to the Roster
	 * @param idSport The Sport the Team is being added to
	 */
	public void addTeam(Team team, int idSport)
	{
		rosters.get(getIndex(idSport)).add(team);
	}
	
	
	/**
	 * Private helper method
	 * Returns the index of the occurrence of id in the indexes array 
	 * Used to get the index for a Sport specific stored in the data structure from the id of the Sport
	 * 
	 * @param idSport Id of the Sport
	 * @return index of the occurrence of Id in indexes
	 */
	private int getIndex(int idSport)
	{
		int index = -1;
		for(int i = 0; i < indexes.length; i++)
		{
			if(indexes[i] == idSport)
			{
				index = i;
			}
		}
		return index;
	}
	
	
	/**
	 * Private helper method 
	 * Returns the old array with the new value appended to the end
	 * 
	 * @param old The old array 
	 * @param addedValue The value that is to be appended to the end of the old array
	 * @return The updated array
	 */
	private int[] addValue(int[] old, int addedValue)
	{
		int length = old.length;
		int[] newArray = new int[length + 1];
		
		for(int i = 0; i < length; i++)
		{
			newArray[i] = old[i];
		}
		
		newArray[length] = addedValue;
		return newArray;
	}
	
	
	/**
	 * Getter for name of the sport
	 * 
	 * @return name of Sport as a String
	 */
	public String getName()
	{
		return name;
	}
	
	
	/**
	 * Setter for the name of the sport
	 * 
	 * @param newName of the Sport
	 */
	public void setName(String newName)
	{
		name = newName;
	}
}
