package com.js.tictactoe.language;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.Properties;

public class FileReader {

  private final Properties langProperties  = new Properties();
  private final String fileName;
  private InputStream input;

  public FileReader(String fileName) {
    this.fileName = fileName;
  }

  public String loadString(String string) {
    try {
      setUpReaders();
      langProperties.load(new InputStreamReader(input, Charset.forName("UTF-8")));
    } catch (NullPointerException | IOException e) {
      //e.printStackTrace();
    }

    return langProperties.getProperty(string);
  }
  private void setUpReaders() {
    String path = Objects.requireNonNull(this.getClass().getClassLoader().getResource(fileName + ".lang")).getFile();
    try {
      input = new FileInputStream(new File(path));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
