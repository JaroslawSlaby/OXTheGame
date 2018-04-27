package com.js.tictactoe.parser;

public class InputParser {

    public static int[] parseStringInput(String input) {
        String regex = "[0-9]+";
        String size[] = input.trim().split("\\s+");


        if (size[0].matches(regex) && size[1].matches(regex)) {
            int x = Integer.parseInt(size[0]);
            int y = Integer.parseInt(size[1]);

            return new int[]{x, y};
        }

        return new int[]{0, 0};
    }
}
