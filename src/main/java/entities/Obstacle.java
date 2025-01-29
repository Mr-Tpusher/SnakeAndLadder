package entities;

import lombok.Data;

@Data
public abstract class Obstacle {
    int start;
    int end;

    abstract void encounterMessage();
}
