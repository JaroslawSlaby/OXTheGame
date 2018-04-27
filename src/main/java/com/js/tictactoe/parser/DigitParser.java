package com.js.tictactoe.parser;

public class DigitParser {

    public static boolean isInputContainingDigits(String line) {
        return line.matches("[0-9 ]+");
    }

}
