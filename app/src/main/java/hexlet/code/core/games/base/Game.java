package hexlet.code.core.games.base;

import java.util.Scanner;

public interface Game {
    boolean runTask(Scanner scanner);

    String getRules();
}
