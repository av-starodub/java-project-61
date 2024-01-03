package hexlet.code.service;

import hexlet.code.core.types.GameType;

import java.util.Arrays;
import java.util.Comparator;

public final class GameMenuProvider {
    private GameMenuProvider() {
    }

    public static String create() {
        var menu = new StringBuilder();
        menu.append("Please enter the game number and press Enter.\n");
        addMenuItem(1, "Greet", menu);
        Arrays.stream(GameType.values())
                .sorted(Comparator.comparingInt(GameType::getMenuNumber))
                .forEach(gameType -> addMenuItem(gameType.getMenuNumber(), gameType.getTitle(), menu));
        addMenuItem(0, "Exit", menu);
        return menu.toString();
    }

    private static void addMenuItem(int menuNumber, String title, StringBuilder menu) {
        menu.append(menuNumber).append(" - ").append(title).append("\n");
    }
}
