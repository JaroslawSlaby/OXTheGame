package com.js.tictactoe.parser;

public class InputParser {

  public static int[] parseStringInput(String input) {

    String regex = "[0-9]+";

    if (input.trim().contains(" ")) {
      String size[] = input.trim().split("\\s+");


      if (size[0].matches(regex) && size[1].matches(regex)) {
        int x = Integer.parseInt(size[0]);
        int y = Integer.parseInt(size[1]);

        return new int[]{x, y};
      }

    } else {

      if (input.matches(regex)) {

        int x = Integer.parseInt(input);
        return new int[]{x, x};
      }
    }
    return new int[]{-1 - 1};
  }
}
