package bullscows;

import java.util.Scanner;

class BullsCows {
    private int bulls;
    private int cows;
    Scanner scanner = new Scanner(System.in);

    BullsCows() {
        this.bulls = 0;
        this.cows = 0;
    }

    private void findBullCow(StringBuilder secretCode, String userInput) {
        for (int i = 0; i < secretCode.length(); i++) {
            if (secretCode.charAt(i) == userInput.charAt(i)) {
                this.bulls++;
            }
            for (int j = 0; j < userInput.length(); j++) {
                if (secretCode.charAt(i) == userInput.charAt(j) && i != j) {
                    this.cows++;
                }
            }
        }
    }

    private void resetValues() {
        this.cows = 0;
        this.bulls = 0;
    }

    public void play() {
        System.out.println("Input the length of the secret code:");
        int secretLength = scanner.nextInt();
//        if (secretLength > 10 || secretLength <= 0) {
//            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
//            return;
//        }
        System.out.println("Input the number of possible symbols in the code:");
        int amountOfSymbols = scanner.nextInt();
        StringBuilder secretCode = generateSecret(secretLength, amountOfSymbols);
//        System.out.printf("Secret code is %s%n", secretCode);
        System.out.println("Okay, let's start a game!");

        int i = 1;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.printf("Turn %d:%n", i++);
            String userInput = sc.nextLine();
            findBullCow(secretCode, userInput);
            getResults();

            if (bulls == secretCode.length()) {
                System.out.println("Congratulations! You guessed the secret code.");
                return;
            }
            resetValues();
        }
    }

    private boolean checkUniqueDigit(StringBuilder secret, int index, StringBuilder digits) {
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == digits.charAt(index)) {
                return false;
            }
        }
        return true;
    }

    private StringBuilder possibleSymbols() {
        StringBuilder symbols = new StringBuilder();

        for (int i = 0; i <= 9; i++) {
            symbols.append(i);
        }

        for (char ch = 'a'; ch <= 'z'; ch ++) {
            symbols.append(ch);
        }

        return symbols;
    }

    private StringBuilder generateSecret(int secretLength, int amountOfSymbols) {
        StringBuilder possibleSymbols = possibleSymbols();
        StringBuilder hideSecret = new StringBuilder(secretLength);
        hideSecret.append("*".repeat(secretLength));

        StringBuilder digits = new StringBuilder(amountOfSymbols);
        for (int i = 0; i < amountOfSymbols; i++) {
            digits.append(possibleSymbols.charAt(i));
        }
        StringBuilder secret = new StringBuilder();

        while (secret.length() != secretLength) {
            boolean unique;

            int index = (int) (digits.length() * Math.random());

            unique = checkUniqueDigit(secret, index, digits);

            if (unique) {
                secret.append(digits.charAt(index));
            }
        }
        friendlyPrintSecretMessage(digits, hideSecret);
        return secret;
    }

    private void friendlyPrintSecretMessage(StringBuilder digits, StringBuilder hideSecret) {
        if (digits.length() > 10) {
            char firstNum = digits.charAt(0);
            char endNum = digits.charAt(9);
            char firstLetter = digits.charAt(10);
            char lastLetter = digits.charAt(digits.length() - 1);
            System.out.printf("The secret is prepared: %s (%c-%c, %s-%s).%n", hideSecret, firstNum, endNum, firstLetter, lastLetter);
        } else {
            char firstNum = digits.charAt(0);
            char endNum = digits.charAt(digits.length() - 1);
            System.out.printf("The secret is prepared: %s (%c-%c).%n", hideSecret, firstNum, endNum);
        }
    }


    private void getResults() {
        if (bulls > 0 && cows > 0) {
            System.out.printf("Grade: %d bull(s) and %d cow(s).%n", bulls, cows);
        } else if (bulls > 0) {
            System.out.printf("Grade: %d bull(s).%n", bulls);
        } else if (cows > 0) {
            System.out.printf("Grade: %d cow(s).%n", cows);
        } else {
            System.out.println("Grade: None.");
        }
    }
}
