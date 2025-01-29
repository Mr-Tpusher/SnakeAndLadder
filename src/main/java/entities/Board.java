package entities;

import lombok.Data;
import java.util.*;

@Data
public class Board {
    private int size;
    private int totalCells;
    private Map<Integer, Obstacle> obstacles;
    private static final Random random = new Random();

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
        Set<Integer> occupied = new HashSet<>();
        occupied.add(0);

        generateLadders(occupied);
        generateSnakes(occupied);
    }


    private void generateLadders(Set<Integer> occupied) {
        System.out.println("generating ladders");
        for (int i = 0; i < size; i++) {
            Obstacle ladder = generateLadder(occupied);
            System.out.println(i+1 + ". " + ladder);
            obstacles.put(ladder.getStart(), ladder);
        }
    }


    private Obstacle generateLadder(Set<Integer> occupied) {
        int[] position = generateLadderStartAndEnd(occupied);
        return new Ladder(position[0], position[1]);
    }


    private int[] generateLadderStartAndEnd(Set<Integer> occupied) {
        int start = generateUniquePosition(occupied);
        int end = generateUniquePosition(occupied, start);
        occupied.add(start);
        occupied.add(end);
        return new int[] {start, end};
    }


    private void generateSnakes(Set<Integer> occupied) {
        System.out.println("generating snakes.");
        // Snakes should not be present at 2 consecutive cells
        Set<Integer> snakeHeads = new HashSet<>();
        for (int i = 0; i < size; i++) {
            Obstacle snake = generateSnake(occupied, snakeHeads);
            System.out.println(i + 1 + ". " + snake);
            obstacles.put(snake.getStart(), snake);
        }
    }


    private Obstacle generateSnake(Set<Integer> occupied, Set<Integer> snakeHeads) {
        int[] position = generateSnakeStartAndEnd(occupied, snakeHeads);
        return new Snake(position[0], position[1]);
    }


    private int[] generateSnakeStartAndEnd(Set<Integer> occupied, Set<Integer> snakeHeads) {
        int start;
        do {
            start = generateUniquePosition(occupied);
        } while (snakeHeads.contains(start));

        int end = generateUniquePosition(occupied, start);

        occupied.add(start);
        occupied.add(end);

        return new int[] {end, start};
    }


    private int generateUniquePosition (Set<Integer> occupied) {
        int position;
        do {
            position = random.nextInt(totalCells - 2) + 2;
        } while (occupied.contains(position));

        return position;
    }


    private int generateUniquePosition (Set<Integer> occupied, int start) {
        int end;
        do {
            end = generateUniquePosition(occupied);
        } while (end <= start);

        return end;
    }


    public boolean isObstacleEncountered(int position) {
        return obstacles.containsKey(position);
    }


}
