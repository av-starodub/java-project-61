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
            var playerChoice = scanner.nextLine();
            switch (playerChoice) {
                case "1" -> Cli.greet();
                case "2" -> run(ParityCheck::run, scanner);
                case "3" -> run(Calculator::run, scanner);
                case "4" -> run(GreatestCommonDivisor::run, scanner);
                case "5" -> run(ArithmeticProgression::run, scanner);
                case "6" -> run(IsTheNumberPrime::run, scanner);
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

    private static void run(GameRunner runner, Scanner scanner) {
        var playerName = getPlayerName(scanner);
        runner.run(playerName);
    }

    @FunctionalInterface
    private interface GameRunner {
        void run(String playerName);
    }

    private static String getPlayerName(Scanner scanner) {
        System.out.print(GREETINGS);
        var playerName = scanner.nextLine();
        return String.format("Hello, %s!\n", playerName);
    }

    private static void exit() {
        System.out.println();
    }
}
