package entities;

public class Ladder extends Obstacle {
    @Override
    void encounterMessage() {
        System.out.println("Ladder encountered. Move forward to " + this.getEnd());
    }
}
