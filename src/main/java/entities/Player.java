package entities;
import lombok.Data;

@Data
public class Player {
    private String name;
    private int position;

    public Player(String name) {
        this.name = name;
    }
}
