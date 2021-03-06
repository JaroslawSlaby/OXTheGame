package com.js.tictactoe.game.configuration;

import com.js.tictactoe.board.Board;
import com.js.tictactoe.exceptions.WrongSizeException;
import com.js.tictactoe.language.ILanguage;
import com.js.tictactoe.language.Language;
import com.js.tictactoe.language.LanguageConfigurator;
import com.js.tictactoe.parser.DigitParser;
import com.js.tictactoe.parser.InputParser;
import com.js.tictactoe.player.Player;
import com.js.tictactoe.player.PlayersGenerator;
import com.js.tictactoe.validators.InputValidator;
import com.js.tictactoe.validators.TableSizeValidator;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Configuration {

  private final Supplier<String> input;
  private final Consumer<String> output;
  private Board board;
  private ILanguage reader;

  public Configuration(Supplier<String> input, Consumer<String> output) {
    this.input = input;
    this.output = output;
  }


  public ILanguage setLanguage() {
    reader = LanguageConfigurator.setLanguage(input, output);
    return reader;
  }

  public Board generateTable() {
    Board board;

    do {
      board = createTable();
    }
    while (board == null);

    return board;
  }

  private Board createTable() {
    String line = getInput();
    try {
      return newBoardAfterParsing(line);
    } catch (WrongSizeException | OutOfMemoryError e) {
      output.accept(reader.loadString("size"));
    }
    return null;
  }

  private Board newBoardAfterParsing(String line) throws WrongSizeException {
    int[] size = InputParser.parseStringInput(line);
    int width = size[0];
    int height = size[1];
    board = Board.getRectangleBoard(width, height);
    return board;
  }


  private String getInput() {
    String line;
    output.accept(reader.loadString("boardSize"));
    line = inputTableSize();
    return line;
  }

  private String inputTableSize() {
    boolean isNumber;
    String line;
    do {
      line = input.get();
      isNumber = DigitParser.isInputContainingDigits(line);

      if (!isNumber)
        output.accept(reader.loadString("wrongTableSize") + " " + reader.loadString("boardSize"));
    } while (!isNumber);

    return line;
  }

  public int chooseSequenceNumber() {
    int signSequence;
    do {
      signSequence = getNumberOfSignsToWin();
    } while (signSequence == 0);

    return signSequence;
  }

  private int getNumberOfSignsToWin() {
    boolean isValid;
    String line;
    do {
      output.accept(reader.loadString("signsNo"));
      line = input.get().replaceAll("\\s","");
      isValid = DigitParser.isInputContainingDigits(line);
    } while (!isValid);

    int number = Integer.parseInt(line);
    int min = board.getWidth() > board.getHeight() ? board.getHeight() : board.getWidth();

    if (number <= min && number >= 3) {
      return number;
    } else {
      output.accept(reader.loadString("incorrectNumber"));
      return 0;
    }
  }

  public List<Player> createPlayers() {
    return PlayersGenerator.createPlayers(input, output, reader);
  }

  public Player chooseStartingSign(List<Player> players) {
    Player currentPlayer;

    do {
      currentPlayer = chooseStartingPlayer(players);
    } while (currentPlayer == null);

    return currentPlayer;
  }

  private Player chooseStartingPlayer(List<Player> players) {

    output.accept(reader.loadString("startSign"));
    String line = input.get();

    if (players.get(0).getSign().toString().equalsIgnoreCase(line)) {
      return players.get(0);
    } else if (players.get(1).getSign().toString().equalsIgnoreCase(line)) {
      return players.get(1);
    } else {
      output.accept(reader.loadString("incorrectPlayer"));
      return null;
    }
  }

  void setReader(ILanguage reader) {
    this.reader = reader;
  }
}
