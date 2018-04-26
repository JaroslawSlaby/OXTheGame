package com.js.tictactoe.validators;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TableSizeValidatorTest {

    @Test
    public void validateSquareTableSize() {
        InputValidator validator = new TableSizeValidator();
        boolean isTableSizeValid = validator.validate("6");
        Assert.assertTrue(isTableSizeValid);
    }

    @Test
    public void validateSquareTableSizeWithIncorrectNumber() {
        InputValidator validator = new TableSizeValidator();
        boolean isTableSizeValid = validator.validate("2");
        Assert.assertFalse(isTableSizeValid);
    }

    @Test
    public void validateRectangleTableSizeWithCorrectData() {
        InputValidator validator = new TableSizeValidator();
        boolean isTableSizeValid = validator.validate("6 6");
        Assert.assertTrue(isTableSizeValid);
    }

    @Test
    public void validateRectangleTableSizeWithIncorrectData() {
        InputValidator validator = new TableSizeValidator();
        boolean isTableSizeValid = validator.validate("1 2");
        Assert.assertFalse(isTableSizeValid);
    }

    @Test
    public void validateRectangleTableSizeWithMoreThanTwoDimensions() {
        InputValidator validator = new TableSizeValidator();
        boolean isTableSizeValid = validator.validate("4 5 6");
        Assert.assertTrue(isTableSizeValid);
    }

    @Test
    public void validateTableSizeWithNullAsInput() {
        InputValidator validator = new TableSizeValidator();
        boolean isTableSizeValid = validator.validate(null);
        Assert.assertFalse(isTableSizeValid);
    }

}
