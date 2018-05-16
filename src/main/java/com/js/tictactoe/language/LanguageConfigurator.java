package com.js.tictactoe.language;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class LanguageConfigurator {

  public static FileReader setLanguage(Supplier<String> input, Consumer<String> output) {
    String in;
    do {
      output.accept("Language/Język/язык: PL/EN/RU: ");
      in = input.get();
    } while (!in.equalsIgnoreCase("PL") && !in.equalsIgnoreCase("EN") && !in.equalsIgnoreCase("RU"));

    return new FileReader(in.toUpperCase());
  }
}
