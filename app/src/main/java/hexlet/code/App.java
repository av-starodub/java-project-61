package hexlet.code;

import hexlet.code.exception.WrongChoiceException;
import hexlet.code.core.engine.Engine;

import java.nio.charset.Charset;
import java.util.Scanner;

import static hexlet.code.service.ConsoleGameService.exit;

public class App {
    public static final String GREETINGS = """
            Welcome to the Brain Games!
            May I have your name?\s""";

    public static void main(String[] args) {
        showMenu();
        var sc = new Scanner(System.in, Charset.defaultCharset());
        var userChoice = sc.nextLine();
        switch (userChoice) {
            case "1" -> Cli.greet();
            case "0" -> exit();
            default -> {
                try {
                    Engine.play(sc, userChoice);
                } catch (WrongChoiceException e) {
                    exit();
                }
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
}
