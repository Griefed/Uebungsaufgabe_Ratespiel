package de.griefed.ratespiel;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random randomInt = new Random();
        int random = randomInt.nextInt(10)+1;
        int count = 0;

        String userInput;
        Scanner inputObj = new Scanner(System.in);

        do {
            do {

                System.out.print("Eingabe: ");
                userInput = inputObj.nextLine();
                count++;

            } while (!isInputCorrect(userInput, count));
        } while (!guessedCorrect(random, userInput));

        System.out.println("Herzlichen Gluehstrumpf! Richtig geraten!");
    }

    private static boolean guessedCorrect(Integer random, String input) {
        boolean guessedCorrect = true;

        if (random > Integer.parseInt(input)) {
            guessedCorrect = false;
            System.out.println("Die Zahl ist zu klein. Versuch es nochmal.");

        } else if (random < Integer.parseInt(input)) {
            guessedCorrect = false;
            System.out.println("Die Zahl ist zu gross. Versuch es nochmal.");
        }

        return guessedCorrect;
    }

    private static boolean isInputCorrect(String input, Integer count) {
        boolean isCorrect = false;

        if (count < 3) {
            if (input.matches("[0-9]*")) {

                if (Integer.parseInt(input) < 11) {
                    isCorrect = true;

                } else {
                    System.out.println("Die Zahl muss kleiner/gleich 10 sein! Versuch es nochmal.");
                }
            } else {
                System.out.println("Du musst eine (ganze) Zahl eingeben. Versuch es nochmal.");
            }
        } else  {
            System.out.println("Du hast deine drei Versuche leider aufgebraucht....");
            System.exit(0);
        }
        return isCorrect;
    }
}
