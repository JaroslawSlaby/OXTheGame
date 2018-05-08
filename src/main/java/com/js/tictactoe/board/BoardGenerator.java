package com.js.tictactoe.board;

import com.js.tictactoe.board.cell.Cell;
import com.js.tictactoe.board.cell.CellWithValue;
import com.js.tictactoe.board.cell.EmptyCell;
import com.js.tictactoe.board.coords.Coordinates;
import com.js.tictactoe.board.printer.BoardPrinter;
import com.js.tictactoe.dimensions.Dimensions;
import com.js.tictactoe.player.Sign;

class BoardGenerator {

    Cell[][] table;
    Coordinates latest;

    void createEmptyBoard(Dimensions dimensions) {
        table = new Cell[dimensions.getHeight()][dimensions.getWidth()];
        fillTableEmptyValues(dimensions);

    }

    private void fillTableEmptyValues(Dimensions dimensions) {
        for (int i = 0; i < dimensions.getHeight(); i++)
            for (int j = 0; j < dimensions.getWidth(); j++)
                table[i][j] = new EmptyCell();
    }

    boolean insertSign(Coordinates coordinates, Sign sign) {
        int y = coordinates.getIntegerX();
        int x = coordinates.getIntegerY();

        if (x >= table.length || y >= table[0].length) {
            return false;
        }

        if (table[x][y].isCellEmpty()) {
            table[x][y] = new CellWithValue(sign);
            return true;
        }

        return false;
    }

    void printBoard() {
        BoardPrinter.printBoard(table);
    }

    public void clearBoard() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = new EmptyCell();
            }
        }
    }
}
