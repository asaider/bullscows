package bullscows;

public class Validator {
    private static final int MAX_COUNT_SYMBOLS = 36;

    public static void validate(Integer sizeSecretCode, Integer countPossibleSymbols) throws GameExeption {
        if (sizeSecretCode <= 0) {
            throw new GameExeption("\"" + sizeSecretCode + "\" isn't a valid number.");
        }
        if (countPossibleSymbols < sizeSecretCode) {
            throw new GameExeption("it's not possible to generate a code with a length of " + sizeSecretCode + " with " + countPossibleSymbols + " unique symbols.");
        }

        if (countPossibleSymbols > MAX_COUNT_SYMBOLS) {
            throw new GameExeption("maximum number of possible symbols in the code is 36 (0-9, a-z).");
        }
    }
}
