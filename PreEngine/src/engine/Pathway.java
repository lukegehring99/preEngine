package engine;

// This is where pathways are constructed and analyzed

public class Pathway {

	private Team startTeam;
	private Team endTeam;
	private int level;
	private GameField games;
	private Roster allTeams;
	
	private double[] results;
	
	public Pathway(Team team1, Team team2, int level, Sport sport)
	{
		startTeam = team1;
		endTeam = team2;
		
		allTeams = sport.getRoster();
		games = sport.getGameField();
		this.level = level;
	}
	
	
	public double[] generatePathway()
	{
		results = new double[0];
		
		allTeams = allTeams.copyBut(startTeam);
		allTeams = allTeams.copyBut(endTeam);
		
		
		nextLevel(startTeam, endTeam, games, allTeams, level, 0.0);
		
		return results;
	}
	
	
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
