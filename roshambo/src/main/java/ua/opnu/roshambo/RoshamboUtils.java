package ua.opnu.roshambo;

import java.util.Random;

public class RoshamboUtils {
    public static GameShape getRandomShape() {
        int random = new Random().nextInt(3);
        switch (random) {
            case 0:
                return new Rock();
            case 1:
                return new Paper();
            default:
                return new Scissors();
        }
    }

    public static int checkWinner(GameShape player, GameShape computer) {
        if (player.getClass() == computer.getClass()) return 0;
        if (player instanceof Rock && computer instanceof Scissors
                || player instanceof Paper && computer instanceof Rock
                || player instanceof Scissors && computer instanceof Paper)
            return 1;
        return -1;
    }
}
