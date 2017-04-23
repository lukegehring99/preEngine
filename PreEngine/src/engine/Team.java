package engine;

public class Team {
	
	private int id;        // Unique id representing the team
	private String name;   // Name of the team
	
	
	/**
	 * Team Constructor
	 * Sets the Team id and name.
	 * 
	 * @param id of the team
	 * @param name of the team
	 */
	public Team(int id, String name)
	{
		this.id = id;
		this.name = name;
	}

	
	/**
	 * Getter for the id of the team.
	 * 
	 * @return id of the team 
	 */
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	
	/**
	 * Setter for the name of the team.
	 * 
	 * @param newName New name of the team
	 */
	public void setName(String newName)
	{
		name = newName;
	}
	
	
}
