package cardNumber;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Validator {

    public List<Integer> transformCardNumber(String numberToVerify) {
        List<String> originalDigits = Arrays.asList(numberToVerify.split(""));
        List<Integer> transformedDigits = new LinkedList<>();
        int lastDigitIndex = numberToVerify.length() - 1;

        //Case for odd number of digits
        if (numberToVerify.length() % 2 != 0) {
            this.updateCardNumberWithOddNumberOfDigits(lastDigitIndex, transformedDigits, originalDigits);
        }
        //Case for even number of digits
        else {
            this.updateCardNumberWithEvenNumberOfDigits(lastDigitIndex, transformedDigits, originalDigits);
        }

        //add check sum - unchanged last digit
        transformedDigits.add(Integer.parseInt(originalDigits.get(lastDigitIndex)));

        return transformedDigits;
    }

    public int doubleDigit(int digit) {
        //sum digits of number > 10
        if ((digit * 2) > 9) {
            return 1 + ((digit * 2) % 10);

        } else {
            return digit * 2;
        }
    }

    public boolean isSumOfDigitsDividableByTen(List<Integer> transformedDigits) {
        int digitsSum = 0;
        for (int item : transformedDigits) {
            digitsSum += item;
        }

        if (digitsSum % 10 == 0)
            return true;
        else
            return false;
    }

    private List<Integer> updateCardNumberWithOddNumberOfDigits(int lastDigitIndex, List<Integer> transformedDigits, List<String> originalDigits) {
        int digit;
        //To go over n-1 digits
        for (int i = 0; i < lastDigitIndex; i++) {
            //To double digit at odd position
            if (i % 2 != 0) {
                digit = Integer.parseInt(originalDigits.get(i));
                transformedDigits.add(i, doubleDigit(digit));
            }
            //unchanged digit ad even position
            else {
                transformedDigits.add(i, Integer.parseInt(originalDigits.get(i)));
            }
        }
        return transformedDigits;
    }

    private List<Integer> updateCardNumberWithEvenNumberOfDigits(int lastDigitIndex, List<Integer> transformedDigits, List<String> originalDigits) {
        int digit;
        //To go over n-1 digits
        for (int i = 0; i < lastDigitIndex; i++) {
            //To double digit at odd position
            if (i % 2 == 0) {
                digit = Integer.parseInt(originalDigits.get(i));
                transformedDigits.add(i, doubleDigit(digit));
            }
            //unchanged digit ad even position
            else {
                transformedDigits.add(i, Integer.parseInt(originalDigits.get(i)));
            }
        }
        return transformedDigits;
    }
}
