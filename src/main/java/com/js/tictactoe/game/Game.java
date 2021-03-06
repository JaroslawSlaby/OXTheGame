package com.js.tictactoe.game;

import com.js.tictactoe.board.Board;
import com.js.tictactoe.board.coords.Coordinates;
import com.js.tictactoe.exceptions.WrongIndexException;
import com.js.tictactoe.game.configuration.Configuration;
import com.js.tictactoe.judge.Judge;
import com.js.tictactoe.language.ILanguage;
import com.js.tictactoe.parser.DigitParser;
import com.js.tictactoe.parser.InputParser;
import com.js.tictactoe.player.Player;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Game {

  private Board board;
  private final Supplier<String> input = new Scanner(System.in)::nextLine;
  private final Consumer<String> output = System.out::print;
  private Player currentPlayer;
  private Judge judge;
  private List<Player> players;
  private Match match;
  private ILanguage reader;

  public void runGame() {
    Configuration configuration = new Configuration(input, output);
    reader = configuration.setLanguage();
    board = configuration.generateTable();

    int signsToWin = configuration.chooseSequenceNumber();
    players = configuration.createPlayers();
    setMatch();
    judge = new Judge(board, signsToWin);
    currentPlayer = configuration.chooseStartingSign(players);
    playingLoop();
    output.accept(reader.loadString("endMatch"));
  }


  private void setMatch() {
    match = new Match();
    match.setPlayers(players);
  }

  private void playingLoop() {
    do {
      boolean winner = move();
      switchPlayers();
      addCurrentSituation(winner);
      printResults();
      board.clearBoard();
      switchPlayers();
    } while (match.isNextRound());
  }

  private void printResults() {
    output.accept(players.get(0).getSign() + ": " + match.getPlayersScore(players.get(0)) + " ");
    output.accept(players.get(1).getSign() + ": " + match.getPlayersScore(players.get(1)) + "\n\n");
  }

  private void addCurrentSituation(boolean winner) {
    if (winner) {
      output.accept(reader.loadString("winner") + currentPlayer.getSign() + ". ");
      match.addGameWinner(currentPlayer);
    } else {
      output.accept(reader.loadString("draw"));
      match.addGameDraw();
    }
  }

  private void switchPlayers() {

    if (currentPlayer.equals(players.get(0))) {
      currentPlayer = players.get(1);
    } else {
      currentPlayer = players.get(0);
    }
  }

  private boolean move() {
    boolean isWinner = false;
    int moveCounter = 0;
    int maxMoves = board.getWidth() * board.getHeight();
    do {
      printOutputDuringMove();
      String line = DigitParser.getCorrectCoordinates(input, output, reader);

      if(DigitParser.returnQuitLine(line)) {
        match.endMatch();
        return false;
      }

      boolean isAdded = tryToMakeMove(line);
      if (isAdded) {
        isWinner = judge.isWinner(currentPlayer.getSign());
        moveCounter++;
        switchPlayers();
      }

    } while (!isWinner && moveCounter < maxMoves && match.isNextRound());

    return isWinner;
  }

  private void printOutputDuringMove() {
    board.printBoard(output);
    output.accept(reader.loadString("player") + currentPlayer.getName() + "(" + currentPlayer.getSign() + ")" +
            reader.loadString("move") + board.getWidth() + reader.loadString("movePt2") + board.getHeight() + ": ");
  }

  private boolean tryToMakeMove(String line) {
    boolean added;
    do {
      added = makeMove(line, currentPlayer);

      if(!added) {
        output.accept(reader.loadString("coords"));
      }

    } while (!added);

    return true;
  }

  private boolean makeMove(String line, Player currentPlayer) {
    boolean added = false;
    try {
      int[] coords = InputParser.parseStringInput(line);
      added = board.tryToInsertSign(Coordinates.parseCoordinates(coords), currentPlayer.getSign());
      if(!added) {
        output.accept(reader.loadString("cell"));
      }
    } catch (WrongIndexException | NumberFormatException e) {
      output.accept(reader.loadString("coords"));
    }
    return added;
  }
}
