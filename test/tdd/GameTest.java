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
    
    // Fonction de refactor des boucles
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
    
    @Test
    void test_un_seul_spare() {
        game.roll(5);
        game.roll(5); // 5+5 = 10 donc SPARE
        game.roll(3); // Lancer du bonus
        rollMany(17, 0); // Que des 0 
        
        // Score visé : 10 (le spare) + 3 (bonus) + 3 (lancer suivant) = 16
        assertEquals(16, game.score());
    }
    
    @Test
    void test_un_seul_strike() {
        game.roll(10); // Strike
        game.roll(3); // Lancers des bonus
        game.roll(4);
        rollMany(16, 0); // Que des 0
        
        // Score attendu : 10 (Strike) + 7 (3+4 du tour suivant) + 7 (3+4 en bonus du strike) = 24
        assertEquals(24, game.score());
    }
    
    @Test
    void test_cas_general() {
        int[] lancers = {1, 2, 10, 0, 10, 6, 2, 0, 0, 10, 10, 6, 4, 8, 2, 2, 7};
        for (int lancer : lancers) {
            game.roll(lancer);
        }
        assertEquals(132, game.score());
    }
}