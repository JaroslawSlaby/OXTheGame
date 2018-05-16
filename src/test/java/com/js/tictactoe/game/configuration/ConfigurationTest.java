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
    Board board = configuration.generateTable();
    assertEquals(3, board.getWidth());
  }

  public void checkIfCorrectInputForSequenceReturnsCorrectValue() {
    Configuration configuration = new Configuration(() -> "3", e -> {});
    configuration.setReader(LanguageConfigurator.setLanguage( () -> "PL", e -> {}));
    configuration.generateTable();
    int sequenceNumber = configuration.chooseSequenceNumber();
    assertEquals(3, sequenceNumber);
  }


}
