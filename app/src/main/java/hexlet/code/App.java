package hexlet.code;

import hexlet.code.util.Engine;

import java.nio.charset.Charset;
import java.util.Scanner;

import static hexlet.code.util.ConsoleService.getUserChoice;
import static hexlet.code.util.ConsoleService.getUserName;
import static hexlet.code.util.ConsoleService.print;
import static hexlet.code.util.ConsoleService.sayHello;
import static hexlet.code.util.ConsoleService.showMenu;

public class App {
    public static void main(String[] args) {
        var sc = new Scanner(System.in, Charset.defaultCharset());
        showMenu();
        var userChoice = getUserChoice(sc);
        switch (userChoice) {
            case "1" -> sayHello(getUserName(sc));
            case "2", "3", "4", "5", "6" -> Engine.play(sc, userChoice);
            default -> print("\n");
        }
    }
}
