package entities;

import java.util.Map;

public class Board {
    int size;
    Map<Integer, Obstacle> obstacles;

    Board(int size) {
        // to-do: generate obstacles
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
}
