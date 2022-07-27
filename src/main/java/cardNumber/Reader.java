package cardNumber;

import org.apache.commons.lang3.math.NumberUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    public String readNumber() {
        String cardNumber = "";

        System.out.println("Please type credit card number to validation: ");
        try {
            cardNumber = new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (isInputValid(cardNumber) == false) {
            return null;
        } else {
            return cardNumber;
        }
    }

    public boolean isInputValid(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("Sorry, your input is empty");
            return false;
        }
        if (!NumberUtils.isDigits(input)) {
            System.out.println("Sorry, your input is not a number");
            return false;
        }
        return true;
    }
}
