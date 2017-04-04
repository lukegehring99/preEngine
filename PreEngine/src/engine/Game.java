package engine;

// This is a game between two different teams
// This is known data

public class Game {
	
	private Team team1;
	private double team1Score;
	
	private Team team2;
	private double team2Score;
	
	public Game(Team team1, double score1, Team team2, double score2)
	{
		this.team1 = team1;
		this.team2 = team2;
		team1Score = score1;
		team2Score = score2;
	}
	
	public double getDifference(Team comparingTeam){
		if (team1 == comparingTeam)
		{
			return team1Score - team2Score;
		}
		else if(team2 == comparingTeam)
		{
			return team2Score - team1Score;
		}
		else
		{
			return (Double)null;
		}
		
	}

}
