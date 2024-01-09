package hexlet.code;

import hexlet.code.games.ArithmeticProgression;
import hexlet.code.games.Calculator;
import hexlet.code.games.GreatestCommonDivisor;
import hexlet.code.games.ParityCheck;
import hexlet.code.games.IsTheNumberPrime;

import java.nio.charset.Charset;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
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
        try (var scanner = new Scanner(System.in, Charset.defaultCharset())) {
            var playerChoice = scanner.nextLine();
            switch (playerChoice) {
                case "1" -> Cli.greet();
                case "2" -> ParityCheck.run();
                case "3" -> Calculator.run();
                case "4" -> GreatestCommonDivisor.run();
                case "5" -> ArithmeticProgression.run();
                case "6" -> IsTheNumberPrime.run();
                case "0" -> System.out.println("\nGoodbye!");
                default -> System.out.println("\nInvalid number entered: " + playerChoice);
            }
        }
    }
}
