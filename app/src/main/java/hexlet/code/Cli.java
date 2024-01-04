package hexlet.code;

import java.nio.charset.Charset;
import java.util.Scanner;

public final class Cli {
    private Cli() {
    }

    public static void greet() {
        try (var scanner = new Scanner(System.in, Charset.defaultCharset())) {
            System.out.print(App.GREETINGS);
            var userName = scanner.nextLine();
            System.out.printf("Hello, %s!\n", userName);
        }
    }
}
