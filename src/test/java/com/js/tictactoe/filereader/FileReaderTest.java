package com.js.tictactoe.filereader;

import com.js.tictactoe.language.Language;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertNull;

@Test
public class FileReaderTest {

  @Test(expectedExceptions = FileNotFoundException.class)
  public void notExistingFileThrowsNPException() throws FileNotFoundException {
    Language fileReader = new Language("PG");
    fileReader.loadString("test");
  }

  public void readingFromExistingFileNotExistingValue() throws FileNotFoundException {
    Language fileReader = new Language("PL");
    String test = fileReader.loadString("test");
    assertNull(test);
  }
}
