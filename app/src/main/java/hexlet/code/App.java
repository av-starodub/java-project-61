package hexlet.code;

import hexlet.code.exception.WrongChoiceException;
import hexlet.code.core.engine.Engine;

import java.nio.charset.Charset;
import java.util.Scanner;

import static hexlet.code.service.ConsoleGameService.getUserChoice;
import static hexlet.code.service.ConsoleGameService.exit;
import static hexlet.code.service.ConsoleGameService.showMenu;

public class App {
    public static final String GREETINGS = """
            Welcome to the Brain Games!
            May I have your name?\s""";

    public static void main(String[] args) {
        var sc = new Scanner(System.in, Charset.defaultCharset());
        showMenu();
        var userChoice = getUserChoice(sc);
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
}
