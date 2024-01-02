package hexlet.code.util;

import hexlet.code.exception.WrongChoiceException;
import hexlet.code.factory.GameFactory;

import java.util.Objects;
import java.util.Scanner;

import static hexlet.code.service.ConsoleGameService.getUserName;
import static hexlet.code.service.ConsoleGameService.print;
import static hexlet.code.service.ConsoleGameService.printRules;
import static hexlet.code.service.ConsoleGameService.sayHello;
import static hexlet.code.service.ConsoleGameService.sayToUser;

public final class Engine {
    private static final int NEEDED_TO_WIN = 3;

    private Engine() {
    }

    public static void play(Scanner scanner, String userChoice) {
        var gameFactory = new GameFactory();
        var game = gameFactory.create(userChoice);

        if (Objects.isNull(game)) {
            throw new WrongChoiceException("game not exist: " + userChoice);
        }

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
