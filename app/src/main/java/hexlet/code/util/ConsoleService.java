package hexlet.code.util;

import java.util.Scanner;

public final class ConsoleService {
    private ConsoleService() {
    }

    public static void showMenu() {
        print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                0 - Exit
                """
        );
    }

    public static String getUserChoice(Scanner scanner) {
        print("Your choice: ");
        return scanner.nextLine();
    }

    public static String sayToUser(String message, String name) {
        return String.format("%s, %s!\n", message, name);
    }

    public static String getUserName(Scanner scanner) {
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

    public static void print(String message) {
        System.out.print(message);
    }
}
