package entities;

import java.util.ArrayDeque;
import java.util.Queue;

public class Game {
    private int size;
    private int numberOfDice;
    Board board;
    Queue<Player> players;

    public Game(int size, int numberOfDice) {
        this.size = size;
        this.numberOfDice = numberOfDice;

        board = new Board(size);
        players = new ArrayDeque<>();
    }

    public void addPlayer(Player player) {
        players.offer(player);
    }

    public void launch() {
        System.out.println("Let the game begin.");
    }
}
