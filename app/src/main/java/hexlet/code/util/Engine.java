package hexlet.code.util;

import java.util.Scanner;

import static hexlet.code.util.ConsoleService.getUserName;
import static hexlet.code.util.ConsoleService.print;
import static hexlet.code.util.ConsoleService.printRules;
import static hexlet.code.util.ConsoleService.sayHello;
import static hexlet.code.util.ConsoleService.sayToUser;

public final class Engine {
    private static final int NEEDED_TO_WIN = 3;

    private Engine() {
    }

    public static void play(Scanner scanner, String userChoice) {
        var game = GameFactory.create(userChoice);
        int numberOfCorrect = 0;

        var userName = getUserName(scanner);
        sayHello(userName);
        printRules(game.getRules());

        while (numberOfCorrect < NEEDED_TO_WIN) {
            if (!game.doTask(scanner)) {
                sayToUser("Let's try again", userName);
                return;
            }
            print("Correct!\n");
            numberOfCorrect++;
        }
        sayToUser("Congratulations", userName);
    }
}
