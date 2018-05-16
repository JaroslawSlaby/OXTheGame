package com.js.tictactoe.parser;

import com.js.tictactoe.language.ILanguage;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class DigitParser {


  public static String correctCoordinates(Supplier<String> input, Consumer<String> output, ILanguage reader) {
    boolean isNumber;
    String line;
    do {
      line = input.get();

      if (returnQuitLine(line)) return line;

      isNumber = DigitParser.isInputContainingDigits(line);
      showIncorrectNumberMessage(output, reader, isNumber);

    } while (!isNumber);
    return line;
  }

  private static boolean returnQuitLine(String line) {
    return line.equalsIgnoreCase("quit");
  }

  private static void showIncorrectNumberMessage(Consumer<String> output, ILanguage reader, boolean isNumber) {
    if (!isNumber)
      output.accept(reader.loadString("coords"));
  }

  public static boolean isInputContainingDigits(String line) {
    return line.matches("[0-9 ]+");
  }
}
