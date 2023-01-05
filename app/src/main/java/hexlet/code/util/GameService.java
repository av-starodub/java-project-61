package hexlet.code.util;

public final class GameService {
    private GameService() {
    }

    public static int getRandomIntInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
