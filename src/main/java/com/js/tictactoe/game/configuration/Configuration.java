package com.js.tictactoe.game.configuration;

import com.js.tictactoe.board.Board;
import com.js.tictactoe.exceptions.WrongSizeException;
import com.js.tictactoe.language.FileReader;
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
  private final FileReader reader;

  public Configuration(Supplier<String> input, Consumer<String> output, FileReader reader) {
    this.input = input;
    this.output = output;
    this.reader = reader;
  }


  public Board createTable() {
    String line = getInput();
    try {
      return newBoardAfterParsing(line);
    } catch (WrongSizeException | OutOfMemoryError e) {
      output.accept(reader.loadString("size"));
      createTable();
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
    InputValidator validator = new TableSizeValidator();
    String line;
    output.accept(reader.loadString("boardSize"));
    line = inputTableSize();
    validator.validate(line);
    return line;
  }

  private String inputTableSize() {
    boolean isNumber;
    String line;
    do {
      line = input.get();
      isNumber = DigitParser.isInputContainingDigits(line);

      if (!isNumber)
        output.accept(reader.loadString("wrongTableSize"));
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
      line = input.get();
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
      output.accept(reader.loadString("incorrectPlayer")); //incorrectPlayer
      return null;
    }
  }
}
