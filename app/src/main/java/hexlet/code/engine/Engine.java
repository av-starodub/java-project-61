package hexlet.code.engine;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Scanner;

public final class Engine {
    public static final int ROUNDS_DEFAULT = 3;

    private Engine() {
    }

    /**
     * @param tasks           Map where the key is the question and the value is the correct answer.
     * @param gameDescription game rules.
     */
    public static void play(Map<String, String> tasks, String gameDescription) {
        try (var scanner = new Scanner(System.in, Charset.defaultCharset())) {
            print("""
                    Welcome to the Brain Games!
                    May I have your name?\s""");
            var playerName = scanner.nextLine();
            print("Hello, %s!\n", playerName);
            print(gameDescription + "\n");
            for (var task : tasks.entrySet()) {
                var question = task.getKey();
                var correctAnswer = task.getValue();
                print("Question: %s\n", question);
                print("Your answer: ");
                var playerAnswer = scanner.nextLine();
                if (!correctAnswer.equals(playerAnswer)) {
                    print("""
                            '%s' is wrong answer ;(. Correct answer was '%s'.
                            Let's try again, %s!
                            """, playerAnswer, correctAnswer, playerName);
                    return;
                }
                print("Correct!\n");
            }
            print("Congratulations, %s!\n", playerName);
        }
    }

    private static void print(String template, Object... params) {
        System.out.printf(template, params);
    }
}
