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

        board = new Board(size);
        players = new ArrayDeque<>();
        winners = new ArrayDeque<>();
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
            int number;
            do {
                System.out.println(player.getName() + " it's your turn, press any character:");
                scanner.nextLine();
                number = Dice.roll(numberOfDice);
                System.out.println(player.getName() + " you got : " + number);
            } while (number > size * size - player.getPosition());

            makeMove(player, number);

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
        if (board.isObstacleEncountered(number)) {
            player.setPosition(board.getObstacles().get(number).getEnd());
        } else {
            player.setPosition(player.getPosition() + number);
        }
        System.out.println(player.getName() + " moved to " + player.getPosition());
    }
}
