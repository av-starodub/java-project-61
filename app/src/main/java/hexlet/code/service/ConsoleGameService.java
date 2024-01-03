package hexlet.code.service;

import hexlet.code.core.games.base.Game;

import java.util.Scanner;

import static hexlet.code.cli.Cli.greet;

public final class ConsoleGameService {
    private ConsoleGameService() {
    }

    public static void showMenu() {
        printMessage(GameMenuProvider.create());
    }

    public static void sayHello(String name) {
        sayToUser("Hello", name);
    }

    public static String getUserChoice(Scanner scanner) {
        printMessage("Your choice: ");
        return scanner.nextLine();
    }

    public static void sayToUser(String message, String name) {
        printMessage(String.format("%s, %s!\n", message, name));
    }

    public static String getUserName(Scanner scanner) {
        printMessage(greet());
        printMessage("May I have your name? ");
        return scanner.nextLine();
    }

    public static void askUser(String question) {
        printMessage("Question: " + question);
    }

    public static String getUserAnswer(Scanner sc) {
        printMessage("\nYour answer: ");
        return sc.nextLine();
    }

    public static void exit() {
        System.out.println();
    }

    public static void printGameRules(Game game) {
        System.out.println(game.getRules());
    }

    public static void printMessage(String message) {
        System.out.print(message);
    }
}
