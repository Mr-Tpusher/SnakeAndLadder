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
        System.out.println("Board printed.");

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int cell = i * 10 + j;
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
    }

    void generateObstacle() {
        // to-do: generate n obstacles
        Set<Integer> occupied = new HashSet<>();
        Random random = new Random();
        // generate ladders from 2 to 99
        while (obstacles.size() < size) {
            int start = random.nextInt(100);
            if (!occupied.contains(start)) {
                occupied.add(start);
                int end = random.nextInt(100);
                if (!occupied.contains(end) && end > start) {
                    occupied.add(end);
                    Obstacle ladder = new Ladder(start, end);
                    obstacles.put(start, ladder);
                }
            }
        }
        // generate snakes from 2 to 99
        while (obstacles.size() < 2 * size) {
            int start = random.nextInt(100);
            if (!occupied.contains(start)) {
                occupied.add(start);
                int end = random.nextInt(100);
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
