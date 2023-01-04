package hexlet.code;

import java.util.Scanner;

public final class Cli {
    public static void greet(Scanner sc) {
        print("""
                Welcome to the Brain Games!
                May I have your name?\s""");
        print(String.format("Hello, %s!\n", getUserAnswer(sc)));
    }

    public static void showMenu() {
        print(createMenu());
    }

    private static String createMenu() {
        return """
                Please enter the game number and press Enter.
                1 - Greet
                0 - Exit
                Your choice:\s""";
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static String getUserAnswer(Scanner sc) {
        return sc.nextLine();
    }
}
