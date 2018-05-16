package com.js.tictactoe.game.configuration;

import com.js.tictactoe.board.Board;
import com.js.tictactoe.language.LanguageConfigurator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

@Test
public class ConfigurationTest {

  public void checkIfCorrectInputForBoardCreatorReturnsCorrectBoard() {
    Configuration configuration = new Configuration(() -> "3", e -> {});
    configuration.setReader(LanguageConfigurator.setLanguage( () -> "PL", e -> {}));
    Board board = configuration.createTable();
    assertEquals(3, board.getWidth());
  }

  @Test(expectedExceptions = StackOverflowError.class)
  public void checkIfIncorrectInputForBoardCreatorReturnsCorrectBoard() {
    Configuration configuration = new Configuration(() -> "0", e -> {});
    configuration.setReader(LanguageConfigurator.setLanguage( () -> "PL", e -> {}));
    Board board = configuration.createTable();
    assertNull(board);
  }

  public void checkIfCorrectInputForSequenceReturnsCorrectValue() {
    Configuration configuration = new Configuration(() -> "3", e -> {});
    configuration.setReader(LanguageConfigurator.setLanguage( () -> "PL", e -> {}));
    configuration.createTable();
    int sequenceNumber = configuration.chooseSequenceNumber();
    assertEquals(3, sequenceNumber);
  }


}