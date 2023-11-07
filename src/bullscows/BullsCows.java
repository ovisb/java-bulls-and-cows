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
        cows = 0;
        bulls = 0;
    }

    public void play() {
        System.out.println("Please, enter the secret code's length:");
        int secretLength = scanner.nextInt();
        if (secretLength > 10 || secretLength <= 0) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            return;
        }
        StringBuilder secredCode = generateSecret(secretLength);
//        System.out.printf("Secret code is %s%n", secredCode);
        System.out.println("Okay, let's start a game!");

        int i = 1;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.printf("Turn %d:%n", i++);
            String userInput = sc.nextLine();
            findBullCow(secredCode, userInput);
            getResults();

            if (bulls == secredCode.length()) {
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

    private StringBuilder generateSecret(int secretLength) {
        StringBuilder digits = new StringBuilder("0123456789");
        StringBuilder secret = new StringBuilder();

        while (secret.length() != secretLength) {
            boolean unique = true;

            int index = (int) (digits.length() * Math.random());

            // first digit is not allowed to be 0
            if (secret.isEmpty()) {
                if (digits.charAt(index) == '0') {
                    continue;
                }
            }

            unique = checkUniqueDigit(secret, index, digits);

            if (unique) {
                secret.append(digits.charAt(index));
                digits.deleteCharAt(index);
            }
        }
        return secret;
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
