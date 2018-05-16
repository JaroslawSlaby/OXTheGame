package com.js.tictactoe.language;

public class DefaultLanguage implements ILanguage {

  @Override
  public String loadString(String string) {
    return DefaultLang.valueOf(string).code;
  }
}

