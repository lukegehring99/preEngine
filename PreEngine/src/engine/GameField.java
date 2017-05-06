package engine;

import java.util.ArrayList;

// This is a custom container class
// Contains all the games for a season


public class GameField {

	private ArrayList<Game> games = new ArrayList<Game>();
	
	public GameField()
	{
		
	}
	
	
	public void add(Game game)
	{
		games.add(game);
	}
	
	
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
	
	public String toString()
	{
		String gamesPlayed = "";
		
		for(Game game : games)
		{
			gamesPlayed += "[" + game.toString() + "] ";
		}
		
		
		return gamesPlayed;
	}
	
	
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
