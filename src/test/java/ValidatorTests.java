import cardNumber.Validator;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.logging.Logger;

public class ValidatorTests {

    Validator validator = new Validator();

    private final static Logger logger = Logger.getLogger(ValidatorTests.class.getName());

    static {
        PropertyConfigurator.configure(ValidatorTests.class.getClassLoader().getResource("log4j.properties"));
    }

    @Test
    public void doubleDigit_whenSumLessThanTen_shouldReturnCorrectResult() {
        logger.info("Run test case for sum less than 10");
        Assert.assertEquals(validator.doubleDigit(4), 8, "When input equals to 4 then doubled value is 8");
        logger.info("Test passed: when sum equals to 4 then doubled value is 8");
    }

    @Test
    public void doubleDigit_whenSumGreaterThanTen_shouldReturnCorrectResult() {
        logger.info("Run test case for sum greater than 10");
        Assert.assertEquals(validator.doubleDigit(7), 5, "When input equals to 7 then doubled value is 5");
        logger.info("Test passed: when sum equals to 7 then doubled value is 5");
    }

    @Test
    public void whenSumDividableByTen_shouldReturnTrue() {
        logger.info("Run test case to verify sum is dividable by 10");
        Assert.assertTrue(validator.isSumOfDigitsDividableByTen(Arrays.asList(1, 2, 3, 4)), "When sum dividable by ten then return true");
        logger.info("Test passed: sum of 1,2,3,4 is dividable by 10");
    }

    @Test
    public void whenSumDividableByTen_shouldReturnFalse() {
        logger.info("Run test case to verify sum is dividable by 10");
        Assert.assertFalse(validator.isSumOfDigitsDividableByTen(Arrays.asList(1, 2, 3, 4, 8)), "When sum dividable by ten then return true");
        logger.info("Test passed: sum of 1,2,3,4,8 is not dividable by 10");
    }

}
