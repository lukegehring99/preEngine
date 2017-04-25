package testEngine;
import engine.*;

public class Test {

	public static void main(String[] args) {
		System.out.println("Test module");
		
		
		Sport s = new Sport(1, "ball");

		Team a = new Team(3, "A");
		Team b = new Team(4, "B");
		
		int scoreA = 63;
		int scoreB = 56;
		
		Game g = new Game(a, scoreA, b, scoreB);
		
//		System.out.println(s.getIndex(1));
		
		s.addGame(g, 1);
		s.addTeam(a, 1);
	}

}
