package com.js.tictactoe.parsers;

import com.js.tictactoe.parser.DigitParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DigitParserTest {

    @Test
    public void checkIfCorrectInputReturnsTrue() {
        String line = "1 2";
        boolean isCorrect = DigitParser.isInputContainingDigits(line);
        Assert.assertTrue(isCorrect);
    }

    @Test
    public void checkIfLettersOnInputReturnsFalse() {
        String line = "1 a";
        boolean isCorrect = DigitParser.isInputContainingDigits(line);
        Assert.assertFalse(isCorrect);
    }

    @Test
    public void checkIfInputCanBeMoreThan9() {
        String line = "12 12";
        boolean isCorrect = DigitParser.isInputContainingDigits(line);
        Assert.assertTrue(isCorrect);
    }
}
