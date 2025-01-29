package entities;

public class Snake extends Obstacle {
    Snake(int start, int end) {
        super(start, end);
    }

    @Override
    void encounterMessage() {
        System.out.println("Snake encountered. Move backwards to " + this.getEnd());
    }
    @Override
    public String toString() {
        return " S[" + this.getStart() + "->" + this.getEnd() + "]";
    }
}
