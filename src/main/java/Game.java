import java.util.*;

public class Game {
    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException("Player " + playerName1 + " is not registered");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Player " + playerName2 + " is not registered");
        }

        if (player1.getStrength() > player2.getStrength())
            return 1;
        else if (player2.getStrength() > player1.getStrength())
            return 2;
        else
            return 0;
    }

    private Player findByName(String name) {
        for (Player p : players) {
            if (p.getName().equals(name)) return p;
        }
        return null;
    }
}
