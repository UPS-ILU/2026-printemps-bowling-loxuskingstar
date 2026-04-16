package tdd;

public class Game {
	
	private int score = 0;
	
	void roll (int nbQuilles) {
		score += nbQuilles;
	}
	
	int score() {
		return score;
	}
}
