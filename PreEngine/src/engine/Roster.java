package engine;

import java.util.ArrayList;

// Custom container for the teams

public class Roster 
{
	private ArrayList<Team> teams = new ArrayList<Team>();
	
	public Roster()
	{
		
	}
	
	public void add(Team team)
	{
		teams.add(team);
	}
	
	public ArrayList<Team> getTeams()
	{
		return teams;
	}
	
	
	public Roster copyBut(Team team1)
	{	
		Roster newRoster = new Roster();
		
		for(Team team : teams)
		{
			if(!(team.equals(team1)))
			{
				newRoster.add(team);
			}
		}
		
		return newRoster;
		
	}
	
	
	
}
