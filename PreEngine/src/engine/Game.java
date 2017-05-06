package engine;


/**
 * Game Class 
 * 
 * This is a game between two different teams
 * <p>
 * (This is known data) 
 * </p>
 * 
 * @author Luke Gehring
 */
public class Game {
	
	private Team team1;              // Team 1 in the Game
	private double team1Score;       // Points team 1 scored
	
	private Team team2;              // Team 2 in the Game
	private double team2Score;       // Points team 2 scored
	
	
	/**
	 * Game Constructor
	 * Sets both teams and respective scores.
	 * 
	 * @param team1 The first team
	 * @param score1 The first team's score
	 * @param team2 The second team
	 * @param score2 The second team's score
	 */
	public Game(Team team1, double score1, Team team2, double score2)
	{
		this.team1 = team1;
		this.team2 = team2;
		team1Score = score1;
		team2Score = score2;
	}
	
	
	/**
	 * Gets the score difference between the two teams for the game. 
	 * 
	 * @param comparingTeam The team that is being compared to 
	 * @return score difference between the teams (number needed to be added on to comparingTeam score to reach the other team score) 
	 */
	@SuppressWarnings("null")
	public double getDifference(Team comparingTeam){
		if (team2 == comparingTeam)
		{
			return team2Score - team1Score;
		}
		else if(team1 == comparingTeam)
		{
			return team1Score - team2Score;
		}
		else
		{
			return (Double)null;
		}
		
	}
	
	
	/**
	 * Getter for Team1Score
	 * 
	 * @return team1Score
	 */
	public double getTeam1Score() 
	{
		return team1Score;
	}

	
	/**
	 * Setter for Team1Score
	 * 
	 * @param team1Score replacement
	 */
	public void setTeam1Score(double team1Score) 
	{
		this.team1Score = team1Score;
	}


	/**
	 * Getter for Team2Score
	 * 
	 * @return team2Score
	 */
	public double getTeam2Score() 
	{
		return team2Score;
	}


	/**
	 * Setter for Team2Score
	 * 
	 * @param team2Score replacement
	 */
	public void setTeam2Score(double team2Score) 
	{
		this.team2Score = team2Score;
	}
	
	
	public boolean hasTeam(Team other)
	{
		boolean value = false;
		
		if(team1.equals(other) || team2.equals(other))
		{
			value = true;
		}
		
		return value;
	}
	
	public String toString()
	{
		String game = team1.getName() + " - " + team2.getName() + " : " + team1Score + " - " + team2Score;
		
		return game;
	}
	
	public Team getTeam1()
	{
		return team1;
	}
	
	public Team getTeam2()
	{
		return team2;	
	}
	
}
