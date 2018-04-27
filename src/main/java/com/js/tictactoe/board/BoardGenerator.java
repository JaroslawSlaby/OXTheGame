package com.js.tictactoe.board;

import com.js.tictactoe.board.cell.Cell;
import com.js.tictactoe.board.cell.CellWithValue;
import com.js.tictactoe.board.cell.EmptyCell;
import com.js.tictactoe.board.coords.Coordinates;
import com.js.tictactoe.engine.Dimensions.Dimensions;
import com.js.tictactoe.player.Sign;

class BoardGenerator {

    Cell[][] table;

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
        int x = coordinates.getIntegerX();
        int y = coordinates.getIntegerY();

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
        for (Cell[] aTable : table) {
            for (Cell cell : aTable) {
                System.out.print("| " + cell.getValue() + " |");
            }

            System.out.print("\n");
        }

    }
}
