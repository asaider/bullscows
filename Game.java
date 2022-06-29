package bullscows;

public class Game {
    static boolean isFinish = false;
    public static int findCows(String predictedDigital, String secretCode) {
        int cows = 0;

        for (int i = 0; i < predictedDigital.length(); i++) {
            if (secretCode.indexOf(predictedDigital.charAt(i)) >= 0) {
                cows++;
            }
        }

        return cows;
    }

    public static int findBulls(String predictedDigital, String secretCode) {
        int bulls = 0;

        for (int i = 0; i < predictedDigital.length(); i++) {
            if (predictedDigital.charAt(i) == secretCode.charAt(i)) {
                bulls++;
            }
        }

        return bulls;
    }

    public static void printResult(int bulls, int cows, Integer sizeSecretCode) {
        if (bulls == sizeSecretCode) {
            System.out.println("Grade: " + bulls + " bulls");
            System.out.println("Congratulations! You guessed the secret code.");
            isFinish = true;
            return;
        }
        if (bulls == 0 && cows == 0) {
            System.out.println("Grade: 0 bulls and 0 cows");
            return;
        }

        String countCows = cows > 1 ? "(s)" : "";
        String countBulls = bulls > 1 ? "(s)" : "";
        if (bulls == 0) {
            System.out.println("Grade: " + cows + " cow" + countCows);
            return;
        } else if (cows == 0) {
            System.out.println("Grade: " + bulls + " bull" + countBulls);
            return;
        }

        System.out.println("Grade: " + bulls + " bull" + countBulls + " and " + cows + " cow" + countCows);
    }
}
