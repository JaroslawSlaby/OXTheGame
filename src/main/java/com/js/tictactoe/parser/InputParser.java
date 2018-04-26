package com.js.tictactoe.parser;

public class InputParser {

    public static int[] parseStringInput(String input) {
        String size[] = input.trim().split("\\s+");
        int x = Integer.parseInt(size[0]);
        int y = Integer.parseInt(size[1]);

        return new int[]{x, y};
    }
}
