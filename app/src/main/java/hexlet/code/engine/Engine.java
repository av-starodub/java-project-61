package hexlet.code.engine;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Scanner;

public final class Engine {
    public static final int ROUNDS_DEFAULT = 3;
    public static final String GREETINGS = """
            \nWelcome to the Brain Games!
            May I have your name?\s""";
    private static final String HELL0_TEMPLATE = "Hello, %s!\n";
    private static final String QUESTION_TEMPLATE = "\nQuestion: %s\nYour answer: ";
    private static final String FAIL_STOP_GAME_TEMPLATE = """
            '%s' is wrong answer ;(. Correct answer was '%s'.
            Let's try again, %s!
            """;
    private static final String WIN_STOP_GAME_TEMPLATE = "\nCongratulations, %s!\n";

    private Engine() {
    }

    /**
     *
     * @param tasks Map where the key is the question and the value is the correct answer.
     * @param gameDescription game rules.
     */
    public static void play(Map<String, String> tasks, String gameDescription) {
        try (var scanner = new Scanner(System.in, Charset.defaultCharset())) {
            print(GREETINGS);
            var playerName = scanner.nextLine();
            print(HELL0_TEMPLATE, playerName);
            print(gameDescription);
            for (var task : tasks.entrySet()) {
                var question = task.getKey();
                var correctAnswer = task.getValue();
                print(QUESTION_TEMPLATE, question);
                var playerAnswer = scanner.nextLine();
                if (!correctAnswer.equals(playerAnswer)) {
                    print(FAIL_STOP_GAME_TEMPLATE, playerAnswer, correctAnswer, playerName);
                    return;
                }
                print("Correct!");
            }
            print(WIN_STOP_GAME_TEMPLATE, playerName);
        }
    }

    private static void print(String template, Object... params) {
        System.out.printf(template, params);
    }
}
