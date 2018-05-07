package com.js.tictactoe.validators;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Test
public class TableSizeValidatorTest {

    public void validateSquareTableSize() {
        InputValidator validator = new TableSizeValidator();
        boolean isTableSizeValid = validator.validate("6");
        assertTrue(isTableSizeValid);
    }

    public void validateSquareTableSizeWithIncorrectNumber() {
        InputValidator validator = new TableSizeValidator();
        boolean isTableSizeValid = validator.validate("2");
        assertFalse(isTableSizeValid);
    }

    public void validateRectangleTableSizeWithCorrectData() {
        InputValidator validator = new TableSizeValidator();
        boolean isTableSizeValid = validator.validate("6 6");
        assertTrue(isTableSizeValid);
    }

    public void validateRectangleTableSizeWithIncorrectData() {
        InputValidator validator = new TableSizeValidator();
        boolean isTableSizeValid = validator.validate("1 2");
        assertFalse(isTableSizeValid);
    }

    public void validateRectangleTableSizeWithMoreThanTwoDimensions() {
        InputValidator validator = new TableSizeValidator();
        boolean isTableSizeValid = validator.validate("4 5 6");
        assertTrue(isTableSizeValid);
    }

    public void validateTableSizeWithNullAsInput() {
        InputValidator validator = new TableSizeValidator();
        boolean isTableSizeValid = validator.validate(null);
        assertFalse(isTableSizeValid);
    }

}
