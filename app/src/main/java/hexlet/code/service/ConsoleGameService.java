package hexlet.code.service;

import java.util.Scanner;

import static hexlet.code.util.Cli.greet;

public final class ConsoleGameService {
    private ConsoleGameService() {
    }

    public static void showMenu() {
        print(GameMenuProvider.create());
    }

    public static void sayHello(String name) {
        sayToUser("Hello", name);
    }

    public static String getUserChoice(Scanner scanner) {
        print("Your choice: ");
        return scanner.nextLine();
    }

    public static void sayToUser(String message, String name) {
        print(String.format("%s, %s!\n", message, name));
    }

    public static String getUserName(Scanner scanner) {
        print(greet());
        print("May I have your name? ");
        return scanner.nextLine();
    }

    public static void askUser(String question) {
        print("Question: " + question);
    }

    public static String getUserAnswer(Scanner sc) {
        print("\nYour answer: ");
        return sc.nextLine();
    }

    public static void exit() {
        System.out.print("\n");
    }

    public static void printRules(String rules) {
        print(rules + "\n");
    }

    public static void print(String message) {
        System.out.print(message);
    }
}
