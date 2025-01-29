package entities;

public class Ladder extends Obstacle {
    Ladder(int start, int end) {
        super(start, end);
    }

    @Override
    void encounterMessage() {
        System.out.println("Ladder encountered. Move forward to " + this.getEnd());
    }

    @Override
    public String toString() {
        return " L[" + this.getStart() + "->" + this.getEnd() + "]";
    }
}
