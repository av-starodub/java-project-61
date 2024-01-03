package hexlet.code.games.base;

import java.util.Scanner;

public interface Game {
    boolean runTask(Scanner scanner);

    String getRules();
}
