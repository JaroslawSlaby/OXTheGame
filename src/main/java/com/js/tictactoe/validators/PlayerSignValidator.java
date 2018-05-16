package com.js.tictactoe.validators;

public class PlayerSignValidator implements InputValidator {

  @Override
  public boolean validate(String input) {
    return input != null && (input.equalsIgnoreCase("X") || input.equalsIgnoreCase("O"));
  }
}
