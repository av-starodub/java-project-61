package hexlet.code;

import java.nio.charset.Charset;
import java.util.Scanner;

import static hexlet.code.Cli.getUserAnswer;
import static hexlet.code.Cli.greet;
import static hexlet.code.Cli.print;
import static hexlet.code.Cli.showMenu;

public class App {
    public static void main(String[] args) {
        var sc = new Scanner(System.in, Charset.defaultCharset());
        showMenu();
        switch (getUserAnswer(sc)) {
            case "1" -> greet(sc);
            case "2" -> runGame(sc);
            case "0" -> print("See you!\n");
            default -> print("");
        }
    }
    private static void runGame(Scanner sc) {
        greet(sc);
    }
}
