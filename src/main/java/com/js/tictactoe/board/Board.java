package com.js.tictactoe.board;

import com.js.tictactoe.board.cell.Cell;
import com.js.tictactoe.board.coords.Coordinates;
import com.js.tictactoe.dimensions.Dimensions;
import com.js.tictactoe.exceptions.WrongSizeException;
import com.js.tictactoe.player.Sign;

public class Board extends BoardGenerator {

  private static final int MIN_SIZE = 3;
  private static final int MAX_SIZE = 100;

  private Board(Dimensions sizeOfBoard) {
    createEmptyBoard(sizeOfBoard);
  }

  public static Board getSquareBoard(int size) throws WrongSizeException {

    if (size < 3) {
      throw new WrongSizeException("Size of square board must be higher than 3!"); //TODO: internationalization
    }

    return new Board(new Dimensions(size));
  }

  public static Board getRectangleBoard(int width, int height) throws WrongSizeException {

    if (width < MIN_SIZE || height < MIN_SIZE || width > MAX_SIZE || height > MAX_SIZE) {
      throw new WrongSizeException("All dimensions of board must be higher than 3!"); //todo: internationalization
    }

    return new Board(new Dimensions(width, height));
  }

  public boolean insertSign(Coordinates coordinates, Sign sign) {
    latest = coordinates;
    return super.insertSign(coordinates, sign);
  }

  public Cell[] getRow(int row) {
    return table[row];
  }

  public Cell[] getColumn(int column) {

    Cell[] expectedColumn = new Cell[table.length];
    for (int row = 0; row < table.length; row++) {
      expectedColumn[row] = table[row][column];
    }

    return expectedColumn;

  }

  public Cell getCell(int x, int y) {
    return table[x][y];
  }

  public void printBoard() {
    super.printBoard();
  }

  public int getWidth() {
    return table[0].length;
  }

  public int getHeight() {
    return table.length;
  }

  public Coordinates getLatestMove() {
    return latest;
  }

}
