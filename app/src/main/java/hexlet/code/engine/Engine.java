package hexlet.code.engine;

import hexlet.code.exception.WrongChoiceException;
import hexlet.code.factory.GameSupplierFactory;

import java.util.Objects;
import java.util.Scanner;

import static hexlet.code.service.ConsoleGameService.getUserName;
import static hexlet.code.service.ConsoleGameService.printMessage;
import static hexlet.code.service.ConsoleGameService.printGameRules;
import static hexlet.code.service.ConsoleGameService.sayHello;
import static hexlet.code.service.ConsoleGameService.sayToUser;

public final class Engine {
    private static final int NEEDED_TO_WIN = 3;

    private Engine() {
    }

    public static void play(Scanner scanner, String userChoice) {
        var gameSupplierFactory = new GameSupplierFactory();
        var gameSupplier = gameSupplierFactory.getGameSupplier(userChoice);

        if (Objects.isNull(gameSupplier)) {
            throw new WrongChoiceException("game not exist: " + userChoice);
        }

        var correctAnswers = 0;
        var roundsCompleted = 0;
        var userName = getUserName(scanner);
        sayHello(userName);

        while (correctAnswers < NEEDED_TO_WIN) {
            var game = gameSupplier.create();
            if (roundsCompleted == 0) {
                printGameRules(game);
            }
            if (!game.runTask(scanner)) {
                sayToUser("Let's try again", userName);
                return;
            }
            printMessage("Correct!\n");
            correctAnswers++;
            roundsCompleted++;
        }
        sayToUser("Congratulations", userName);
    }
}
