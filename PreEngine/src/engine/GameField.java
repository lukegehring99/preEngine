package engine;

import java.util.ArrayList;

// This is a custom container class
// Contains all the games for a season


public class GameField {

	private ArrayList<Game> games = new ArrayList<Game>();
	
	
	/**
	 * Constructor for the GameField
	 */
	public GameField()
	{
		
	}
	
	
	/**
	 * Adds a game to the GameField
	 * 
	 * @param game to be added
	 */
	public void add(Game game)
	{
		games.add(game);
	}
	
	
	
	
	/*
	public void mergeRepeatGames()
	{
		int[] indexes = new int[0]; //values to remove at end of the array
		
		ArrayList<Game> addedGames = new ArrayList<Game>();
		
		for(int i = 0; i < games.size() - 1; i++)
		{
			
			double scoreA = games.get(i).getTeam1Score();
			double scoreB = games.get(i).getTeam2Score();
			int[] temp = new int[1];
			
			temp[0] = i;
			
			for(int k = i + 1; k < games.size(); k++) // For every game following the previous game
			{
				if(games.get(i).hasTeam(games.get(k).getTeam1()) && games.get(i).hasTeam(games.get(k).getTeam2())) //If the games are the same
				{
						temp = append(temp, k);
						
						if(games.get(i).getTeam1().equals(games.get(k).getTeam1()))
						{
							scoreA += games.get(k).getTeam1Score();
							scoreB += games.get(k).getTeam2Score();
						}
						else
						{
							scoreA += games.get(k).getTeam2Score();
							scoreB += games.get(k).getTeam1Score();
						}	
				}
			}
			
			boolean shouldBeAdded = true;
			
			for(Game game : addedGames)
			{
				if(game.hasTeam(games.get(i).getTeam1()) && game.hasTeam(games.get(i).getTeam2()))
				{
					shouldBeAdded = false;
				}
			}
			
			if(shouldBeAdded && temp.length > 1)
			{
				int numberOfGames = temp.length;
				addedGames.add(new Game(games.get(i).getTeam1(), scoreA/numberOfGames, games.get(i).getTeam2(), scoreB/numberOfGames));
				
				for(int q = 0; q < temp.length; q++)
				{
					indexes = append(indexes, temp[q]);
					hello this is a test
				}
				
			}
		}
		
		
		for(int i = indexes.length; i > 0; i--)
		{
			games.remove(indexes[i - 1]);
		}
		
		for(Game add : addedGames)
		{
			games.add(add);
		}
		
	}
	*/
	
	/**
	 * Checks for more than one games between the same teams
	 * If there is more than one game between the same teams, each team score is averaged
	 */
	public void mergeRepeatGames()
	{
		@SuppressWarnings("unchecked")
		ArrayList<Game> cloneGame = (ArrayList<Game>) games.clone();
		ArrayList<Game> newGames = new ArrayList<Game>();
		
		
		while (cloneGame.size() > 0)
		{
			int[] indexes = new int[0];
			indexes = append(indexes, 0);
			
			for(int i = 1; i < cloneGame.size(); i++)
			{
				if(cloneGame.get(i).hasTeam(cloneGame.get(0).getTeam1()) && cloneGame.get(i).hasTeam(cloneGame.get(0).getTeam2()))
				{
					indexes = append(indexes, i);
				}
			}
			
			double scoreA = 0;
			double scoreB = 0;
		
			Team teamA = cloneGame.get(0).getTeam1();
			Team teamB = cloneGame.get(0).getTeam2();
			
			for(int i = indexes.length - 1; i >= 0; i--)
			{
				if (cloneGame.get(indexes[i]).getTeam1().equals(cloneGame.get(0).getTeam1()))
				{
					scoreA += cloneGame.get(indexes[i]).getTeam1Score();
					scoreB += cloneGame.get(indexes[i]).getTeam2Score();
				}
				else
				{
					scoreA += cloneGame.get(indexes[i]).getTeam2Score();
					scoreB += cloneGame.get(indexes[i]).getTeam1Score();
				}
				cloneGame.remove(indexes[i]);
			}
			
			int numberOfGames = indexes.length;
			newGames.add(new Game(teamA, scoreA/numberOfGames, teamB, scoreB/numberOfGames));
			
		}
		
		games = newGames;
	}
	
	
	
	
	/**
	 * Private method to get all games played by a team
	 * 
	 * @param team to find games played
	 * @return games that team played in
	 */
	private ArrayList<Game> getAllGamesPlayed(Team team)
	{
		
		ArrayList<Game> temp = new ArrayList<Game>();
		
		for(Game game : games)
		{
			if (game.hasTeam(team))
			{
				temp.add(game);
			}
		}
		
		return temp;
	}
	
	
	/**
	 * Boolean method to determing is there is a game between two teams
	 * 
	 * @param team1 
	 * @param team2
	 * @return true or false depending on if there is a game between the two teams
	 */
	public boolean hasGame(Team team1, Team team2)
	{
		boolean result = false;
		
		ArrayList<Game> possible = getAllGamesPlayed(team1);
		
		for(Game game : possible)
		{
			if(game.hasTeam(team2))
			{
				result = true;
			}
		}
		
		
		return result;
	}
	
	
	/**
	 * The score difference between the two teams 
	 * 
	 * @param team1 starting team
	 * @param team2 ending team
	 * @return the score difference between the teams
	 */
	public double getGameDifference(Team team1, Team team2)
	{
		double result = 0;
		
		ArrayList<Game> possible = getAllGamesPlayed(team1);
		
		for(Game game : possible)
		{
			if(game.hasTeam(team2))
			{
				result = game.getDifference(team2);
			}
		}
		
		return result;
	}
	
	
	
	public void generateAverages(Roster roster)
	{
		ArrayList<Team> teams = roster.getTeams();
		
		for(int i = 0; i < teams.size(); i++)
		{
			ArrayList<Game> games = getAllGamesPlayed(teams.get(i));
			
			double score = 0;
			
			for(int k = 0; k < games.size(); k++)
			{
				  if(games.get(k).getTeam1().equals(teams.get(i)))
				  {
					  score += games.get(k).getTeam1Score();
				  }
				  else
				  {
					  score += games.get(k).getTeam2Score();
				  }
			}
			
			score = score / games.size();
			
			teams.get(i).setAverage(score);
		}
	}
	
	
	
	
	/**
	 * String representation of the GameField Class
	 */
	public String toString()
	{
		String gamesPlayed = "";
		
		for(Game game : games)
		{
			gamesPlayed += "[" + game.toString() + "] ";
		}
		
		
		return gamesPlayed;
	}
	
	
	/**
	 * Private helper method to append a value to an array
	 * 
	 * @param old Array to append a value onto
	 * @param addedValue value to append onto old Array
	 * @return old Array with the addedValue appended to it
	 */
	private int[] append(int[] old, int addedValue)
	{
		int length = old.length;
		int[] newArray = new int[length + 1];
		
		for(int i = 0; i < length; i++)
		{
			newArray[i] = old[i];
		}
		
		newArray[length] = addedValue;
		return newArray;
	}
}
