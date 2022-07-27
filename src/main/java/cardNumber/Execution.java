package cardNumber;

import java.util.List;

public class Execution {
    public static void main(String[] args) {
        Reader reader = new Reader();
        Validator validator = new Validator();

        String numberToVerify = reader.readNumber();

        if (numberToVerify == null)
            System.exit(1);

        List<Integer> transformedDigits = validator.transformCardNumber(numberToVerify);

        if (validator.isSumOfDigitsDividableByTen(transformedDigits)) {
            System.out.println("Credit card number: " + numberToVerify + " is valid.");
        } else {
            System.out.println("Credit card number: " + numberToVerify + " is invalid.");
        }
    }
}
