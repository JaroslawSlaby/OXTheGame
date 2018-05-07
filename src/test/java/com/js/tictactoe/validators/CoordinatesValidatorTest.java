package com.js.tictactoe.validators;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CoordinatesValidatorTest {

    @Test
    public void validateCoordinatesIfInputIsCorrect() {
        InputValidator validator = new CoordinatesValidator();
        boolean areCoordinatesValid = validator.validate("1 2");
        assertTrue(areCoordinatesValid);
    }

    @Test
    public void validateCoordinatesIfInputContainsOneDigit() {
        InputValidator validator = new CoordinatesValidator();
        boolean areCoordinatesValid = validator.validate("1");
        assertFalse(areCoordinatesValid);
    }

    @Test
    public void validateCoordinatesIfInputContainsNegativeNumbers() {
        InputValidator validator = new CoordinatesValidator();
        boolean areCoordinatesValid = validator.validate("-1 2");
        assertFalse(areCoordinatesValid);
    }

    @Test
    public void validateCoordinatesIfInputContainsZero() {
        InputValidator validator = new CoordinatesValidator();
        boolean areCoordinatesValid = validator.validate("0 0");
        assertTrue(areCoordinatesValid);
    }

    @Test
    public void validateCoordinatesIfInputContainsOnlyZero() {
        InputValidator validator = new CoordinatesValidator();
        boolean areCoordinatesValid = validator.validate("0");
        assertFalse(areCoordinatesValid);
    }

    @Test
    public void validateCoordinatesIfInputIsNull() {
        InputValidator validator = new CoordinatesValidator();
        boolean areCoordinatesValid = validator.validate(null);
        assertFalse(areCoordinatesValid);
    }
}
