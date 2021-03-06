package engine;

// This is where pathways are constructed and analyzed

public class Pathway {

	private Team startTeam;
	private Team endTeam;
	private int level;
	private GameField games;
	private Roster allTeams;
	
	private double[] results;
	
	
	/**
	 * Constructor for the Pathway object
	 * 
	 * @param team1 starting team
	 * @param team2 ending team
	 * @param level total iterations
	 * @param sport	sport of the teams
	 */
	public Pathway(Team team1, Team team2, int level, Sport sport)
	{
		startTeam = team1;
		endTeam = team2;
		
		allTeams = sport.getRoster();
		games = sport.getGameField();
		this.level = level;
	}
	
	/**
	 * Driver method for generating pathways
	 * 
	 * @return the results of the pathways in an array
	 */
	public double[] generatePathway()
	{
		results = new double[0];
		
		allTeams = allTeams.copyBut(startTeam);
		allTeams = allTeams.copyBut(endTeam);
		
		
		nextLevel(startTeam, endTeam, games, allTeams, level, 0.0);
		
		return results;
	}
	
	
	/**
	 * Recursive method to generate and process the pathways for each level
	 * 
	 * @param team1 starting team
	 * @param team2 ending team
	 * @param games GameField of all available games
	 * @param avaibleTeams Roster of all teams left in the traversal
	 * @param level number of iterations left
	 * @param score each "step"
	 */
	private void nextLevel(Team team1, Team team2, GameField games, Roster avaibleTeams, int level, double score)
	{
		if(level == 0)
		{
			if(games.hasGame(team1, team2))
		    {
//				System.out.println("Game between: " + team1.getName() + " and " + team2.getName());
				results = append(results, score + games.getGameDifference(team1, team2));
		    }
			else
			{
//				System.out.println("No game between: " + team1.getName() + " and " + team2.getName());
			}
		}
		else
		{
	    	level--;
	    	for(Team team : avaibleTeams.getTeams())
	    	{
	    		
	    		if(games.hasGame(team1, team))
	    		{
	    			double newScore = score + games.getGameDifference(team1, team);
	    			Roster newRoster = avaibleTeams.copyBut(team);
	    			nextLevel(team, team2, games, newRoster, level, newScore);
	    		}
		    }
		}
	}
	
	
	/**
	 * Helper method to append a value to an array
	 * 
	 * @param old Array to append a value onto
	 * @param addedValue value to append to the old Array
	 * @return the old Array with the new value appended onto it
	 */
	private double[] append(double[] old, double addedValue)
	{
		int length = old.length;
		double[] newArray = new double[length + 1];
		
		for(int i = 0; i < length; i++)
		{
			newArray[i] = old[i];
		}
		
		newArray[length] = addedValue;
		return newArray;
	}
	
}
