package com.js.tictactoe.filereader;

import com.js.tictactoe.language.Language;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNull;

@Test
public class FileReaderTest {

  public void notExistingFileThrowsNPException() {
    Language fileReader = new Language("PG");
    fileReader.loadString("test");
  }

  public void readingFromExistingFileNotExistingValue() {
    Language fileReader = new Language("EN");
    String test = fileReader.loadString("test");
    assertNull(test);
  }
}
