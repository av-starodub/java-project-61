package hexlet.code.games;

import java.util.Scanner;

public interface Game {
    boolean doTask(Scanner scanner);

    String getRules();
}
