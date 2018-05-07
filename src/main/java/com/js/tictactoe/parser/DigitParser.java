package com.js.tictactoe.parser;

import java.util.function.Supplier;

public class DigitParser {


    public static String correctCoordinates(Supplier<String> input) {
        boolean isNumber;
        String line;
        do {
            line = input.get();
            isNumber = DigitParser.isInputContainingDigits(line);

            if (!isNumber)
                System.out.println("Wrong coordinates!");

        } while (!isNumber);
        return line;
    }

    public static boolean isInputContainingDigits(String line) {
        return line.matches("[0-9 ]+");
    }

    public static boolean isInputContainingDigitsHigherThan2(String line) {
        return line.matches("[3-9 ]+");
    }


}
