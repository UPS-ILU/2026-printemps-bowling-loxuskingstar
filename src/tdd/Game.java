package tdd;

public class Game {
    private int rolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(int nbQuilles) {
        rolls[currentRoll++] = nbQuilles;
    }

    public int score() {
        int score = 0;
        int rollIndex = 0;

        // Boucle des 10 tours (2 lancers par tours)
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rollIndex)) {
            	score += 10 + rolls[rollIndex +1] + rolls[rollIndex + 2];
            	rollIndex ++;
            } else if (isSpare(rollIndex)) { // Spare
                score += 10 + rolls[rollIndex + 2]; 
                rollIndex += 2;
            } else { // Pas spare
                score += rolls[rollIndex] + rolls[rollIndex + 1];
                rollIndex += 2;
            }
        }
        return score;
    }

    private boolean isSpare(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
    }
    
    private boolean isStrike(int rollIndex) {
    	return rolls[rollIndex] == 10;
    }
}