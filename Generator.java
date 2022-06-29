package bullscows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    private static final ArrayList<Character> symbols = new ArrayList<>(List.of('0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));

    public static String generateSecretCode(Integer sizeSecretCode, Integer countPossibleSymbols) {
        int i = 0, randomIndexSymbol;
        String result = "";
        ArrayList<Character> allowedSymbols = new ArrayList<>(symbols.subList(0, countPossibleSymbols));
        Random random = new Random();
        do {
            randomIndexSymbol = random.nextInt(countPossibleSymbols - 1);

            Character randomSymbolFromCollection = allowedSymbols.get(randomIndexSymbol);
            if (allowedSymbols.indexOf(randomSymbolFromCollection) > 1) {
                result = result.concat(String.valueOf(randomSymbolFromCollection));
                allowedSymbols.remove(randomSymbolFromCollection);
                countPossibleSymbols--;
                i++;
            }
        } while (i < sizeSecretCode);

        return result;
    }

    public static void printInitData(int countPossibleSymbols) {
        String hiddenStarts = "", result;
        for (int i = 0; i < countPossibleSymbols; i++) {
            hiddenStarts = hiddenStarts.concat("*");
        }
        if (countPossibleSymbols < 10) {
            result = "The secret is prepared: " + hiddenStarts + " (0-" + symbols.get(countPossibleSymbols - 1) + ").";
        } else {
            result = "The secret is prepared: " + hiddenStarts + " (0-9, a-" + symbols.get(countPossibleSymbols - 1) + ").";
        }
        System.out.println(result);
        System.out.println("Okay, let's start a game!");
    }
}
