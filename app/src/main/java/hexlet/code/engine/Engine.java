package hexlet.code.engine;

import hexlet.code.core.task.Task;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Scanner;

public final class Engine {

    private Engine() {
    }

    public static void play(List<Task> tasks, String gameDescription, String playerName) {
        try (var scanner = new Scanner(System.in, Charset.defaultCharset())) {
            System.out.println(gameDescription);
            for (var task : tasks) {
                System.out.printf("Question: %s\nYour answer: ", task.getQuestion());
                var userAnswer = scanner.nextLine();
                var correctAnswer = task.getAnswer();
                if (!correctAnswer.equals(userAnswer)) {
                    System.out.printf(
                            "'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again %s\n",
                            userAnswer,
                            correctAnswer,
                            playerName
                    );
                    return;
                }
                System.out.println("Correct!");
            }
            System.out.printf("Congratulations, %s!\n", playerName);
        }
    }
}
