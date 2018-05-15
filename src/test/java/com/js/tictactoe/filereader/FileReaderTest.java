package com.js.tictactoe.filereader;

import com.js.tictactoe.language.FileReader;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNull;

@Test
public class FileReaderTest {

//  @Test(expectedExceptions = NullPointerException.class)
  public void notExistingFileThrowsNPException() {
    FileReader fileReader = new FileReader("PG");
    fileReader.loadString("test");
  }

  public void readingFromExistingFileNotExistingValue() {
    FileReader fileReader = new FileReader("EN");
    String test = fileReader.loadString("test");
    assertNull(test);
  }
}
