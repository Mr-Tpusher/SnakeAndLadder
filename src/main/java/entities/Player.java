package entities;
import lombok.Data;

@Data
public class Player {
    String name;
    int position;

    public Player(String name) {
        this.name = name;
    }
}
