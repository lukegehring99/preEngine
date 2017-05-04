package testEngine;
import engine.*;

public class Test {

	public static void main(String[] args) {
		System.out.println("Test module");
		
		
		Sport s = new Sport("ball");

		Team a = new Team("A");
		Team b = new Team("B");
		
		int scoreA = 63;
		int scoreB = 56;
		
		Game g = new Game(a, scoreA, b, scoreB);
		
//		System.out.println(s.getIndex(1));
		
		s.addGame(g);
		s.addTeam(a);
	}

}
