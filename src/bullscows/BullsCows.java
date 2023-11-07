package bullscows;

import java.util.Scanner;

class BullsCows {
    private int bulls;
    private int cows;
    private static final String secretCode = "9305";

    Scanner scanner = new Scanner(System.in);

    BullsCows() {
        this.bulls = 0;
        this.cows = 0;
    }

    private void findBullCow(String userInput) {
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

    public void play() {
//        String userInput = scanner.nextLine();
//        findBullCow(userInput);
        int secretLength = scanner.nextInt();
        if (secretLength > 10 || secretLength <= 0) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            return;
        }

        System.out.printf("The random secret number is: %s", generateSecret(secretLength));

    }

    private boolean checkUniqueDigit(StringBuilder secret, int i, String num) {
        for (int j = 0; j < secret.length() ; j++) {
            if (num.charAt(i) == secret.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private StringBuilder generateSecret(int secretLength) {
        StringBuilder secret = new StringBuilder();

        loop: while (true) {
            String num = String.valueOf(System.nanoTime());

            for (int i = num.length() - 1; i >= 0; i--) {
                boolean unique = true;

                // first digit is not allowed to be 0
                if (secret.isEmpty()) {
                    if (num.charAt(i) == '0') {
                        continue;
                    }
                }

                unique = checkUniqueDigit(secret, i, num);

                if (unique) {
                    secret.append(num.charAt(i));
                } else {
                    continue;
                }

                if (secret.length() == secretLength) {
                    break loop;
                }
            }
        }
        return secret;
    }


    public void getResults() {
        if (bulls > 0 && cows > 0) {
            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %s.", bulls, cows, secretCode);
        } else if (bulls > 0) {
            System.out.printf("Grade: %d bull(s). The secret code is %s.", bulls, secretCode);
        } else if (cows > 0) {
            System.out.printf("Grade: %d cow(s). The secret code is %s.", cows, secretCode);
        } else {
            System.out.printf("Grade: None. The secret code is %s.", secretCode);
        }
    }
}
