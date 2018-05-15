package com.js.tictactoe.judge;

import com.js.tictactoe.board.Board;
import com.js.tictactoe.board.cell.Cell;
import com.js.tictactoe.board.coords.Coordinates;
import com.js.tictactoe.player.Sign;

import java.util.function.ToIntBiFunction;

public class Judge {

  private Board board;
  private int amount;

  public Judge(Board board, int amount) {
    this.board = board;
    this.amount = amount;
  }

  public boolean isWinner(Sign sign) {

    Coordinates latest = board.getLatestMove();
    int x = latest.getIntegerX();
    int y = latest.getIntegerY();

    return isWinnerInRow(y, sign) || isWinnerInColumn(x, sign) || checkWinningInUnit(sign, isWinnerInDiagonal1(x, y)) || checkWinningInUnit(sign, isWinnerInDiagonal2(x, y));

  }

  private boolean isWinnerInRow(int row, Sign sign) {

    int counter = 1;

    Cell[] boardRow = board.getRow(row);

    for (int j = 0; j < boardRow.length - 1; j++) {
      if (!boardRow[j].isCellEmpty() && boardRow[j].getValue().equals(sign) && boardRow[j].getValue().equals(boardRow[j + 1].getValue())) {
        counter++;
      }
    }

    return counter >= amount;
  }

  private boolean isWinnerInColumn(int column, Sign sign) {

    int counter = 1;

    Cell[] boardColumn = board.getColumn(column);

    for (int j = 0; j < boardColumn.length - 1; j++) {
      if (!boardColumn[j].isCellEmpty() && boardColumn[j].getValue().equals(sign) && boardColumn[j].getValue().equals(boardColumn[j + 1].getValue())) {
        counter++;
      }
    }

    return counter >= amount;
  }

  String isWinnerInDiagonal1(int x, int y) {
    return isWinnerInDiagonal(x, y, plusSizeFunction());
  }

  String isWinnerInDiagonal2(int x, int y) {
    return isWinnerInDiagonal(x, y, minusSizeFunction());
  }

  private ToIntBiFunction<Integer, Integer> plusSizeFunction() {
    return (integer, integer2) -> integer + integer2;
  }


  String isWinnerInDiagonal(int x, int y, ToIntBiFunction<Integer, Integer> function) {

    int boundary = -amount + 1;

    StringBuilder line = new StringBuilder();

    for (int i = boundary; i < amount; i++) {

      int currX = x + i;
      int currY = function.applyAsInt(y, i);

      if (checkPositionX(currX) && checkPositionY(currY)) {

        Cell cell = board.getCell(currY, currX);
        line.append(cell.getValue());
      }
    }
    return line.toString();

  }

  private ToIntBiFunction<Integer, Integer> minusSizeFunction() {
    return (integer, integer2) -> integer - integer2;
  }

  private boolean checkWinningInUnit(Sign sign, String line) {
    String regex = ".*" + sign.toString() + "{" + amount + "}.*";
    return line.matches(regex);
  }

  private boolean checkPositionX(int position) {
    return position >= 0 && position < board.getWidth();
  }

  private boolean checkPositionY(int position) {
    return position >= 0 && position < board.getHeight();
  }
}
