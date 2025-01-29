package util;

import java.util.Random;

public class Dice {
    private static Random random = new Random();
    private Dice(){
    }

    public static int roll(int n) {
        return random.nextInt(n * 6) + 1;
    }
}
