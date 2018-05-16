package com.js.tictactoe.validators;

import com.js.tictactoe.parser.InputParser;

public class CoordinatesValidator implements InputValidator {

  @Override
  public boolean validate(String input) {

    if (input == null) {
      return false;
    }

    if (input.contains(" ")) {
      int[] coordinates = InputParser.parseStringInput(input);

      return coordinates[0] >= 0 && coordinates[1] >= 0;
    }

    return false;
  }
}
