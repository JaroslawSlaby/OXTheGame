package com.js.tictactoe.validators;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Test
public class PlayerSignTest {

  public void createCorrectSign() {
    InputValidator validator = new PlayerSignValidator();
    boolean isSignCorrect = validator.validate("X");
    assertTrue(isSignCorrect);
  }

  public void createIncorrectSign() {
    InputValidator validator = new PlayerSignValidator();
    boolean isSignCorrect = validator.validate("Z");
    assertFalse(isSignCorrect);
  }

  public void createIncorrectSignWithMoreThanOneLetterAsInput() {
    InputValidator validator = new PlayerSignValidator();
    boolean isSignCorrect = validator.validate("XAAAA");
    assertFalse(isSignCorrect);
  }

  public void createSignWithNullAsInput() {
    InputValidator validator = new PlayerSignValidator();
    boolean isSignCorrect = validator.validate(null);
    assertFalse(isSignCorrect);
  }

  public void createSignWithNumberAsInput() {
    InputValidator validator = new PlayerSignValidator();
    boolean isSignCorrect = validator.validate("1");
    assertFalse(isSignCorrect);
  }
}
