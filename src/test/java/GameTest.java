import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void testFirstPlayerWins() {
        Game game = new Game();
        Player p1 = new Player(1, "Alice", 80);
        Player p2 = new Player(2, "Bob", 50);

        game.register(p1);
        game.register(p2);

        assertEquals(1, game.round("Alice", "Bob"));
    }

    @Test
    public void testSecondPlayerWins() {
        Game game = new Game();
        Player p1 = new Player(1, "Alice", 60);
        Player p2 = new Player(2, "Bob", 90);

        game.register(p1);
        game.register(p2);

        assertEquals(2, game.round("Alice", "Bob"));
    }

    @Test
    public void testDraw() {
        Game game = new Game();
        Player p1 = new Player(1, "Alice", 70);
        Player p2 = new Player(2, "Bob", 70);

        game.register(p1);
        game.register(p2);

        assertEquals(0, game.round("Alice", "Bob"));
    }

    @Test
    public void testFirstPlayerNotRegistered() {
        Game game = new Game();
        Player p2 = new Player(2, "Bob", 70);
        game.register(p2);

        NotRegisteredException ex = assertThrows(
                NotRegisteredException.class,
                () -> game.round("Alice", "Bob")
        );
        assertTrue(ex.getMessage().contains("Player Alice is not registered"));
    }

    @Test
    public void testSecondPlayerNotRegistered() {
        Game game = new Game();
        Player p1 = new Player(1, "Alice", 70);
        game.register(p1);

        NotRegisteredException ex = assertThrows(
                NotRegisteredException.class,
                () -> game.round("Alice", "Bob")
        );
        assertTrue(ex.getMessage().contains("Player Bob is not registered"));
    }
}
