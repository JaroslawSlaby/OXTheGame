package com.js.tictactoe.language;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Language implements ILanguage {

  private final Properties langProperties  = new Properties();
  private final String fileName;
  private InputStream input;

  private final Logger logger = Logger.getLogger(getClass().getName());

  public Language(String fileName) {
    this.fileName = fileName;
  }

  public String loadString(String string) {
    try {
      setUpReaders();
      langProperties.load(new InputStreamReader(input, Charset.forName("UTF-8")));
    } catch (NullPointerException | IOException e) {
      logger.log(Level.CONFIG, e.getLocalizedMessage());
    }

    return langProperties.getProperty(string);
  }
  private void setUpReaders() {
    String path = ("languages/" + fileName + ".lang");
    try {
      input = new FileInputStream(new File(path));
    } catch (FileNotFoundException e) {
      logger.log(Level.INFO, e.getCause() + e.getLocalizedMessage());
    }
  }
}
