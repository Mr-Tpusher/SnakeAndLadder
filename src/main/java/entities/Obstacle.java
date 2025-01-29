package entities;

import lombok.Data;

@Data
public abstract class Obstacle {
    int start;
    int end;

    Obstacle(int start, int end) {
        this.start = start;
        this.end = end;
    }

    abstract void encounterMessage();

    @Override
    public abstract String toString();
}
