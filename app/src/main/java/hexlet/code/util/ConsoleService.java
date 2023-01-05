package hexlet.code.util;

import java.util.Scanner;

import static hexlet.code.util.Cli.greet;

public final class ConsoleService {
    private ConsoleService() {
    }

    public static void showMenu() {
        print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                0 - Exit
                """
        );
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

    public static void printRules(String rules) {
        print(rules + "\n");
    }
    public static void print(String message) {
        System.out.print(message);
    }
}
