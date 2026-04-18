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
    
    @Test
	void test_vide() {
		assertEquals(0, game.score());
	}
    
    @Test
    void test_zero() {
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assertEquals(0, game.score());
    }
    
    @Test
    void test_que_un() {
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        assertEquals(20, game.score());
    }
}