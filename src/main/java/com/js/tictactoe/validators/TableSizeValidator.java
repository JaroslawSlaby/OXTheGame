package com.js.tictactoe.validators;

import com.js.tictactoe.parser.InputParser;

public class TableSizeValidator implements InputValidator {

    @Override
    public boolean validate(String input) {

        if (input == null) {
            return false;
        }

        if (input.contains(" ")) {
            int[] dimensions = InputParser.parseStringInput(input);

            return dimensions[0] > 2 && dimensions[1] > 2;

        } else {
            int size = Integer.parseInt(input);

            return size > 2;
        }
    }
}
