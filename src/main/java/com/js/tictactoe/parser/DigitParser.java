package com.js.tictactoe.parser;

import com.js.tictactoe.language.FileReader;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class DigitParser {


  public static String correctCoordinates(Supplier<String> input, Consumer<String> output, FileReader reader) {
    boolean isNumber;
    String line;
    do {
      line = input.get();

      if (line.equalsIgnoreCase("quit"))
        return line;

      isNumber = DigitParser.isInputContainingDigits(line);

      if (!isNumber)
        output.accept(reader.loadString("coords"));

    } while (!isNumber);
    return line;
  }

  public static boolean isInputContainingDigits(String line) {
    return line.matches("[0-9 ]+");
  }
}
