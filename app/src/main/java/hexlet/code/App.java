package hexlet.code;

import hexlet.code.core.games.ArithmeticProgression;
import hexlet.code.core.games.Calculator;
import hexlet.code.core.games.GreatestCommonDivisor;
import hexlet.code.core.games.ParityCheck;
import hexlet.code.core.games.IsTheNumberPrime;

import java.nio.charset.Charset;
import java.util.Scanner;

public class App {
    public static final int ROUNDS_DEFAULT = 3;
    public static final String GREETINGS = """
            Welcome to the Brain Games!
            May I have your name?\s""";

    public static void main(String[] args) {
        showMenu();
        try (var scanner = new Scanner(System.in, Charset.defaultCharset())) {
            var userChoice = scanner.nextLine();
            switch (userChoice) {
                case "1" -> Cli.greet();
                case "2" -> ParityCheck.run(greetPlayer(scanner));
                case "3" -> Calculator.run(greetPlayer(scanner));
                case "4" -> GreatestCommonDivisor.run(greetPlayer(scanner));
                case "5" -> ArithmeticProgression.run(greetPlayer(scanner));
                case "6" -> IsTheNumberPrime.run(greetPlayer(scanner));
                default -> exit();
            }
        }
    }

    private static void showMenu() {
        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice:\s""");
    }

    private static String greetPlayer(Scanner scanner) {
        System.out.print(GREETINGS);
        var userName = scanner.nextLine();
        System.out.printf("Hello, %s!\n", userName);
        return userName;
    }

    private static void exit() {
        System.out.println();
    }
}
