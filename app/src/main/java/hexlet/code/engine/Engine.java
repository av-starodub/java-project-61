package hexlet.code.engine;

import hexlet.code.core.task.Task;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Scanner;

public final class Engine {
    public static final int ROUNDS_DEFAULT = 3;
    public static final String GREETINGS = """
            \nWelcome to the Brain Games!
            May I have your name?\s""";
    private static final String FAIL_STOP_GAME_TEMPLATE = """
            '%s' is wrong answer ;(. Correct answer was '%s'.
            Let's try again, %s!
            """;
    private static final String WIN_STOP_GAME_TEMPLATE = "Congratulations, %s!\n";

    private Engine() {
    }

    public static void play(List<Task> tasks, String gameDescription) {
        try (var scanner = new Scanner(System.in, Charset.defaultCharset())) {
            var playerName = getPlayerName(scanner);
            print(gameDescription);
            for (var task : tasks) {
                ask(task.getQuestion());
                var userAnswer = scanner.nextLine();
                var correctAnswer = task.getAnswer();
                if (!correctAnswer.equals(userAnswer)) {
                    stopGame(FAIL_STOP_GAME_TEMPLATE, userAnswer, correctAnswer, playerName);
                    return;
                }
                print("Correct!");
            }
            stopGame(WIN_STOP_GAME_TEMPLATE, playerName);
        }
    }

    private static String getPlayerName(Scanner scanner) {
        System.out.print(GREETINGS);
        var playerName = scanner.nextLine();
        System.out.printf("Hello, %s!\n", playerName);
        return playerName;
    }

    private static void ask(String question) {
        System.out.printf("Question: %s\nYour answer: ", question);
    }

    private static void stopGame(String stopGameTemplate, String... params) {
        System.out.printf(stopGameTemplate, (Object[]) params);
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
