package com.js.tictactoe.validators;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Test
public class CoordinatesValidatorTest {

  public void validateCoordinatesIfInputIsCorrect() {
    InputValidator validator = new CoordinatesValidator();
    boolean areCoordinatesValid = validator.validate("1 2");
    assertTrue(areCoordinatesValid);
  }

  public void validateCoordinatesIfInputContainsOneDigit() {
    InputValidator validator = new CoordinatesValidator();
    boolean areCoordinatesValid = validator.validate("1");
    assertFalse(areCoordinatesValid);
  }

  public void validateCoordinatesIfInputContainsNegativeNumbers() {
    InputValidator validator = new CoordinatesValidator();
    boolean areCoordinatesValid = validator.validate("-1 2");
    assertFalse(areCoordinatesValid);
  }

  public void validateCoordinatesIfInputContainsZero() {
    InputValidator validator = new CoordinatesValidator();
    boolean areCoordinatesValid = validator.validate("0 0");
    assertTrue(areCoordinatesValid);
  }

  public void validateCoordinatesIfInputContainsOnlyZero() {
    InputValidator validator = new CoordinatesValidator();
    boolean areCoordinatesValid = validator.validate("0");
    assertFalse(areCoordinatesValid);
  }

  public void validateCoordinatesIfInputIsNull() {
    InputValidator validator = new CoordinatesValidator();
    boolean areCoordinatesValid = validator.validate(null);
    assertFalse(areCoordinatesValid);
  }
}
