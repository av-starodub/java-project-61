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
                case "2" -> ParityCheck.run(getPlayerName(scanner));
                case "3" -> Calculator.run(getPlayerName(scanner));
                case "4" -> GreatestCommonDivisor.run(getPlayerName(scanner));
                case "5" -> ArithmeticProgression.run(getPlayerName(scanner));
                case "6" -> IsTheNumberPrime.run(getPlayerName(scanner));
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

    private static String getPlayerName(Scanner scanner) {
        System.out.print(GREETINGS);
        return scanner.nextLine();
    }

    private static void exit() {
        System.out.println();
    }
}
