package tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game;
    
    @BeforeEach
    void init() {
        game = new Game();
    }
    
    // Fonction refactor des boucles
    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }
    
    @Test
    void test_gouttiere() {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }
    
    @Test
    void test_que_des_un() {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }
}