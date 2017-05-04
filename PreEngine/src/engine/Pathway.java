package engine;

// This is where pathways are constructed and analyzed

public class Pathway {

	private Team startTeam;
	private Team endTeam;
	private int level;
	private GameField games;
	private Roster allTeams;
	
	private double results[] = new double[0];
	
	public Pathway(Team team1, Team team2, int level, GameField games, Roster allTeams)
	{
		startTeam = team1;
		endTeam = team2;
		
		this.allTeams = allTeams;
		this.games = games;
		this.level = level;
	}
	
	
	public double[] generatePathway(GameField games, Roster availableTeams, int level)
	{
		return new double[0];
	}
	
	
	private void nextLevel(Team team1, Team team2, GameField games, Roster avaibleTeams, int level, double score)
	{
		
	}
	
	private double[] append(double[] old)
	{
		return new double[0];
	}
	
}
