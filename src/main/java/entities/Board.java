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
        System.out.println("Board constructor start");
        obstacles = new HashMap<>();
        this.size = size;
        this.totalCells = size * size;
        generateObstacle();
        System.out.println("Board constructor end");
    }

    void printBoard() {
        // to-do:

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
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
        System.out.println("Generating obstacles:");
        Set<Integer> occupied = new HashSet<>();
        occupied.add(0);
        Random random = new Random();

        // generate ladders from 2 to 99
        for (int ladderCount = 0; ladderCount < size; ladderCount++) {
            int start = 0;
            while (occupied.contains(start)) {
                start = random.nextInt(98) + 2;
            }
            int end = 0;
            while (occupied.contains(end) || end <= start) {
                end = random.nextInt(98) + 2;
            }
            Obstacle ladder = new Ladder(start, end);
            ladder.toString();
            obstacles.put(start, ladder);
        }

        // generate snakes from 2 to 99
        for (int snakeCount = 0; snakeCount < size; snakeCount++) {
            int start = 0;
            while (occupied.contains(start)) {
                start = random.nextInt(98) + 2;
            }
            int end = 0;
            while (occupied.contains(end) || end >= start) {
                end = random.nextInt(98) + 2;
            }
            Obstacle snake = new Snake(start, end);
            snake.toString();
            obstacles.put(start, snake);
        }

        System.out.println(this.size * 2 + " obstacles generated.");

    }

    public boolean isObstacleEncountered(int number) {
        return obstacles.containsKey(number);
    }
}
