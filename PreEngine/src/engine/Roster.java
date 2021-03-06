package engine;

import java.util.ArrayList;
import java.io.Serializable;

// Custom container for the teams

public class Roster implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Team> teams = new ArrayList<Team>();
	
	
	/**
	 * Constructor for the Roster objects
	 */
	public Roster()
	{
		
	}
	
	
	/**
	 * Adds a Team to the Roster
	 * 
	 * @param team to add
	 */
	public void add(Team team)
	{
		teams.add(team);
	}
	
	
	/**
	 * Getter for the ArrayList of which the Teams are stored
	 * 
	 * @return ArrayList of Teams
	 */
	public ArrayList<Team> getTeams()
	{
		return teams;
	}
	
	
	/**
	 * Creates a copy of the roster of all of the teams but one
	 * 
	 * @param team1 that isn't to be copied
	 * @return Roster of every team but the one
	 */
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
	
	public void deleteTeam(Team team)
	{
		int id = team.getId();
		for(int i = 0; i < teams.size(); i++)
		{
			if(teams.get(i).getId() == id)
			{
				teams.remove(i);
				break;
			}
		}
			
	}
	
	
	/**
	 * String representation of the Roster Object
	 * 
	 * @return String of the team number, name, and ID
	 */
	public String toString()
	{
		String teamNames = "[Team Number : Team Name : ID] ";
		int number = 1;
		
		
		for(Team team : teams)
		{
 			teamNames += "[" + number + " : " + team.getName() +  " : " + team.getId() + "] ";
			number++;
		}
		
		return teamNames;
	}
	
	
	
}
