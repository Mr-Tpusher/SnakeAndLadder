package entities;

import util.Dice;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    private int size;
    private int numberOfDice;
    Board board;
    Queue<Player> players;
    Queue<Player> winners;

    public Game(int size, int numberOfDice) {
        this.size = size;
        this.numberOfDice = numberOfDice;

        this.board = new Board(size);
        this.players = new ArrayDeque<>();
        this.winners = new ArrayDeque<>();
        System.out.println("game constructor done");
    }

    public void addPlayer(Player player) {
        players.offer(player);
    }

    public void launch() {
        System.out.println("Let the game begin.");
        board.printBoard();
        Scanner scanner = new Scanner(System.in);
        // we are playing till just 1 person remains
        while (players.size() > 1) {
            Player player = players.poll();
            String namePosition = player.getName() + "[" + player.getPosition() + "]";

            int number;
            do {
                System.out.println( namePosition + " it's your turn, press any character:");
                scanner.nextLine();
                number = Dice.roll(numberOfDice);
                System.out.println(namePosition + " got : " + number);
            } while (number == numberOfDice * 6);

            makeMove(player, number);
            System.out.println(namePosition + " moved to -> [" + player.getPosition() + "]");

            if (isWinner(player)) {
                winners.offer(player);
                System.out.println("Woohooo, " + player.getName() + " you won!!!");
            } else {
                players.offer(player);
            }
        }
        scanner.close();
    }

    private boolean isWinner(Player player) {
        return player.getPosition() == size * size;
    }


    void makeMove(Player player, int number) {
        int newPosition = player.getPosition() + number;
        if (newPosition > board.getTotalCells()) {
            System.out.println("Can't move to " + newPosition);
        } else if (board.isObstacleEncountered(newPosition)) {
            Obstacle obstacle = board.getObstacles().get(newPosition);
            obstacle.encounterMessage();
            player.setPosition(obstacle.getEnd());
        } else {
            player.setPosition(newPosition);
        }
        //System.out.println(player.getName() + " moved to [" + player.getPosition() + "]");
    }
}
