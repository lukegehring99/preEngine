package engine;

import java.util.ArrayList;

public class Comparison {

	private static int maxDegree = 6;
	
	private ArrayList<double[]> results = new ArrayList<double[]>();
	private Team team1;
	private Team team2;
	private Sport sport;
	
	
	public Comparison(Team team1, Team team2, Sport sport)
	{
		this.team1 = team1;
		this.team2 = team2;
		this.sport = sport;
	}
	
	public void generateResults()
	{
		for(int i = 0; i < maxDegree; i++)
		{
			Pathway x = new Pathway(team1, team2, i, sport);
			results.add(x.generatePathway());
		}
	}
	
	public ArrayList<double[]> getResults()
	{
		return results;
	}
	
	public static void setMaxdegree(int newDegree)
	{
		maxDegree = newDegree;
	}
	
	public static int getMaxdegree()
	{
		return maxDegree;
	}
}
