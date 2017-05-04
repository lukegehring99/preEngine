package engine;



public class Sport {

	private GameField games;     // Container for the GameField
	private Roster teams;        // Container for the Roster
	
	@SuppressWarnings("unused")
	private int id;                                 // Unique Id representing the sport
	private String name;                            // Official name of the sport
	
	private static int nextID = 0;
	
	/**
	 * Class constructor.
	 * Creates a sport object that contains the GameField and Roster.
	 * Initializes the id and name variables and adds the respective id to indexes array.
	 * 
	 * @param id This is a unique id representing the sport used
	 * @param name The official name of the sport
	 */
	public Sport(String name)
	{
		this.id = nextID;
		nextID++;
		this.name = name;	
		
		games = new GameField();
		teams = new Roster();
	}
	
	
	/**
	 * Adds a Game to the GameField for the sport defined by id.
	 * 
	 * @param game The Game being added to the GameField
	 */
	public void addGame(Game game)
	{
		games.add(game);
	}
	
	
	/**
	 * Adds a Team to the Roster for the sport defined by id.
	 * 
	 * @param team The Team being added to the Roster
	 */
	public void addTeam(Team team)
	{
		teams.add(team);
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
	
	
	public Roster getRoster()
	{
		return teams;
	}
	
	
	public GameField getGameField()
	{
		return games;
	}
}

