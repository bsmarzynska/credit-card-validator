import cardNumber.Reader;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class ReaderTests {

    Reader reader = new Reader();

    private final static Logger logger = Logger.getLogger(ReaderTests.class.getName());
    static
    {
        PropertyConfigurator.configure(ReaderTests.class.getClassLoader().getResource("log4j.properties"));
    }

    @Test(groups = {"validInput"})
    public void isInputValid_whenValidInput_shouldReturnTrue() {
        logger.info("Run test case for valid format");
        Assert.assertTrue(reader.isInputValid("374412448596234"), "Validation failed.");
        logger.info("Test passed: 374412448596234 is valid format of credit card number");
    }

    @Test(groups = {"invalidInput"})
    public void isInputValid_whenInvalidInput_shouldReturnFalse() {
        logger.info("Run test case for invalid format");
        Assert.assertFalse(reader.isInputValid("123"), "Validation failed.");
        logger.info("Test passed: invalid input is invalid format of credit card number");
    }

    @Test(groups = {"invalidInput"})
    public void IsInputValid_whenEmptyInput_shouldReturnFalse() {
        logger.info("Run test case for empty string");
        Assert.assertFalse(reader.isInputValid(""), "Validation failed.");
        logger.info("Test passed: empty string is invalid format of credit card number");
    }

    @Test(groups = {"invalidInput"})
    public void IsInputValid_whenNullInput_shouldReturnFalse() {
        logger.info("Run test case for null value");
        Assert.assertFalse(reader.isInputValid(null), "Validation failed.");
        logger.info("Test passed: null value is invalid format of credit card number");
    }
}
