package com.js.tictactoe.validators;

public class TableSizeValidator implements InputValidator {

    @Override
    public boolean validate(String input) {
        if (input.contains(" ")) {
            String size[] = input.trim().split("\\s+");
            int x = Integer.parseInt(size[0]);
            int y = Integer.parseInt(size[1]);

            return x > 2 && y > 2;

        } else {
            int size = Integer.parseInt(input);

            return size > 2;
        }
    }
}
