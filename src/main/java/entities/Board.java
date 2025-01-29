package entities;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Board {
    private int size;
    private Map<Integer, Obstacle> obstacles;

    Board(int size) {
        // to-do: generate obstacles
        obstacles = new HashMap<>();
        generateObstacle();
    }

    void printBoard() {
        // to-do:
        System.out.println("Board printed.");
    }

    void generateObstacle() {
        // to-do: generate n obstacles
        System.out.println(this.size + "obstacles generated.");
    }

    public boolean isObstacleEncountered(int number) {
        return obstacles.containsKey(number);
    }
}
