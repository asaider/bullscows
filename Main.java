package bullscows;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int step = 1, bulls, cows, countPossibleSymbols, sizeSecretCode;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Please, enter the secret code's length: ");
            sizeSecretCode = scanner.nextInt();

            System.out.println("Input the number of possible symbols in the code:");
            countPossibleSymbols = scanner.nextInt();

            Validator.validate(sizeSecretCode, countPossibleSymbols);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return;
        }

        String secretCode = Generator.generateSecretCode(sizeSecretCode, countPossibleSymbols);
        Generator.printInitData(countPossibleSymbols);

        while (true) {
            System.out.println("Turn " + step + ":");
            String predictedDigital = scanner.nextLine();

            bulls = Game.findBulls(predictedDigital, secretCode);
            cows = Game.findCows(predictedDigital, secretCode);

            //Game.printResult(bulls, cows, sizeSecretCode);
            Game.printResult(bulls, cows, sizeSecretCode);

            if (Game.isFinish) {
                return;
            }
            step++;
        }
    }
}
