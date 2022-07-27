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
    public void isInputValid_whenValidInputThenReturnTrue() {
        logger.info("Run test case for valid format");
        Assert.assertTrue(reader.isInputValid("374412448596234"), "Input format is valid");
        logger.info("Test passed: 374412448596234 is valid format of credit card number");
    }

    @Test(groups = {"invalidInput"})
    public void isInputValid_whenInvalidInputThenReturnFalse() {
        logger.info("Run test case for invalid format");
        Assert.assertFalse(reader.isInputValid("invalid input"), "Input format is valid");
        logger.info("Test passed: invalid input is invalid format of credit card number");
    }

    @Test(groups = {"invalidInput"})
    public void IsInputValid_whenEmptyInputThenReturnFalse() {
        logger.info("Run test case for empty string");
        Assert.assertFalse(reader.isInputValid(""), "Input format is valid");
        logger.info("Test passed: empty string is invalid format of credit card number");
    }

    @Test(groups = {"invalidInput"})
    public void IsInputValid_whenNullInputThenReturnFalse() {
        logger.info("Run test case for null value");
        Assert.assertFalse(reader.isInputValid(null), "Input format is valid");
        logger.info("Test passed: null value is invalid format of credit card number");
    }
}
