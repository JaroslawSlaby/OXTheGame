package com.js.tictactoe.language;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class LanguageConfigurator {

  public static ILanguage setLanguage(Supplier<String> input, Consumer<String> output) {
    String in;
    do {
      output.accept("Language/Język/язык: PL/EN/RU: ");
      in = input.get().replaceAll("\\s", "");
    } while (!in.equalsIgnoreCase("PL") && !in.equalsIgnoreCase("EN") && !in.equalsIgnoreCase("RU"));

    try {
      return new Language(in.toUpperCase());
    } catch (Exception e) {
      output.accept("File not found. Loaded default language.\n");
      return new DefaultLanguage();
    }
  }
}
