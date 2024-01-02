package hexlet.code.games.base;

import java.util.Scanner;

public interface Game {
    boolean doTask(Scanner scanner);

    String getRules();
}
