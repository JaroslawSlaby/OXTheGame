package com.js.tictactoe.validators;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayerSignTest {

    @Test
    public void createCorrectSign() {
        InputValidator validator = new PlayerSignValidator();
        boolean isSignCorrect = validator.validate("X");
        Assert.assertTrue(isSignCorrect);
    }

    @Test
    public void createIncorrectSign() {
        InputValidator validator = new PlayerSignValidator();
        boolean isSignCorrect = validator.validate("Z");
        Assert.assertFalse(isSignCorrect);
    }

    @Test
    public void createIncorrectSignWithMoreThanOneLetterAsInput() {
        InputValidator validator = new PlayerSignValidator();
        boolean isSignCorrect = validator.validate("XAAAA");
        Assert.assertFalse(isSignCorrect);
    }

    @Test
    public void createSignWithNullAsInput() {
        InputValidator validator = new PlayerSignValidator();
        boolean isSignCorrect = validator.validate(null);
        Assert.assertFalse(isSignCorrect);
    }
}
