package com.js.tictactoe.parsers;

import com.js.tictactoe.parser.DigitParser;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class DigitParserTest {

    public void checkIfCorrectInputReturnsTrue() {
        String line = "1 2";
        boolean isCorrect = DigitParser.isInputContainingDigits(line);
        assertTrue(isCorrect);
    }

    public void checkIfLettersOnInputReturnsFalse() {
        String line = "1 a";
        boolean isCorrect = DigitParser.isInputContainingDigits(line);
        assertFalse(isCorrect);
    }

    public void checkIfInputCanBeMoreThan9() {
        String line = "12 12";
        boolean isCorrect = DigitParser.isInputContainingDigits(line);
        assertTrue(isCorrect);
    }

    public void checkIfInputCanBeDifferentThanDigit() {
        String correct = DigitParser.correctCoordinates(() -> "10 10", e -> {});
        assertEquals(correct, "10 10");
    }
}
