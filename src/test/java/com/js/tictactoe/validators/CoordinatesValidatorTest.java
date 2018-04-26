package com.js.tictactoe.validators;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CoordinatesValidatorTest {

    @Test
    public void validateCoordinatesIfInputIsCorrect() {
        InputValidator validator = new CoordinatesValidator();
        boolean areCoordinatesValid = validator.validate("1 2");
        Assert.assertTrue(areCoordinatesValid);
    }

    @Test
    public void validateCoordinatesIfInputContainsOneDigit() {
        InputValidator validator = new CoordinatesValidator();
        boolean areCoordinatesValid = validator.validate("1");
        Assert.assertFalse(areCoordinatesValid);
    }

    @Test
    public void validateCoordinatesIfInputContainsNegativeNumbers() {
        InputValidator validator = new CoordinatesValidator();
        boolean areCoordinatesValid = validator.validate("-1 2");
        Assert.assertFalse(areCoordinatesValid);
    }

    @Test
    public void validateCoordinatesIfInputContainsZero() {
        InputValidator validator = new CoordinatesValidator();
        boolean areCoordinatesValid = validator.validate("0 0");
        Assert.assertTrue(areCoordinatesValid);
    }

    @Test
    public void validateCoordinatesIfInputContainsOnlyZero() {
        InputValidator validator = new CoordinatesValidator();
        boolean areCoordinatesValid = validator.validate("0");
        Assert.assertFalse(areCoordinatesValid);
    }

    @Test
    public void validateCoordinatesIfInputIsNull() {
        InputValidator validator = new CoordinatesValidator();
        boolean areCoordinatesValid = validator.validate(null);
        Assert.assertFalse(areCoordinatesValid);
    }
}
