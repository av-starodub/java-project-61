package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void greet() {
        var sc = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name?");
        var userName = sc.nextLine();
        System.out.printf("Hello, %s!\n", userName);
    }
}
