package entities;

import lombok.Data;
import java.util.*;

@Data
public class Board {
    private int size;
    private int totalCells;
    private Map<Integer, Obstacle> obstacles;

    Board(int size) {
        // to-do: generate obstacles
        obstacles = new HashMap<>();
        this.size = size;
        this.totalCells = size * size;
        generateObstacle();
    }

    void printBoard() {
        // to-do:

        for (int i = size - 1; i >= 0; i--) {
            for (int j = size - 1; j >= 0; j--) {
                int cell = (i * 10 + j) + 1;
                System.out.print(cell);
                if (obstacles.containsKey(cell)) {
                    System.out.print(obstacles.get(cell));
                    System.out.print("    ");
                } else {
                    System.out.print("       ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    void generateObstacle() {
        // to-do: generate n obstacles
        Set<Integer> occupied = new HashSet<>();
        Random random = new Random();
        // generate ladders from 2 to 99
        while (obstacles.size() < size) {
            int start = random.nextInt(98) + 2;
            if (!occupied.contains(start)) {
                occupied.add(start);
                int end = random.nextInt(98) + 2;
                if (!occupied.contains(end) && end > start) {
                    occupied.add(end);
                    Obstacle ladder = new Ladder(start, end);
                    obstacles.put(start, ladder);
                }
            }
        }
        // generate snakes from 2 to 99
        while (obstacles.size() < 2 * size) {
            int start = random.nextInt(98) + 2;
            if (!occupied.contains(start)) {
                occupied.add(start);
                int end = random.nextInt(98) + 2;
                if (!occupied.contains(end) && end < start) {
                    occupied.add(end);
                    Obstacle snake = new Snake(start, end);
                    obstacles.put(start, snake);
                }
            }
        }
        System.out.println(this.size * 2 + " obstacles generated.");

    }

    public boolean isObstacleEncountered(int number) {
        return obstacles.containsKey(number);
    }
}
