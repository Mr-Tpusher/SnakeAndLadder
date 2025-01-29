package entities;

public class Snake extends Obstacle {
    @Override
    void encounterMessage() {
        System.out.println("Snake encountered. Move backwards to " + this.getEnd());
    }
}
