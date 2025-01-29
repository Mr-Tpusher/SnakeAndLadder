import entities.Game;
import entities.Player;

public class Client {
    public static void main(String[] args) {
        Game g = new Game(10, 2);
        g.addPlayer(new Player("A"));
        g.addPlayer(new Player("B"));
        g.launch();
    }
}
