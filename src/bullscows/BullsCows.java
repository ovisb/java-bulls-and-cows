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
        String userInput = scanner.nextLine();
        findBullCow(userInput);
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
