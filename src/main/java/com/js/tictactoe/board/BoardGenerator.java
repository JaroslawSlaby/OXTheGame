package com.js.tictactoe.board;

import com.js.tictactoe.board.cell.Cell;
import com.js.tictactoe.board.cell.CellWithValue;
import com.js.tictactoe.board.cell.EmptyCell;
import com.js.tictactoe.board.coords.Coordinates;
import com.js.tictactoe.dimensions.Dimensions;
import com.js.tictactoe.player.Colors;
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
        System.out.print(Colors.ANSI_DEFAULT + "y\\x");
        for (int i = 0; i < table[0].length; i++) {
            System.out.print(Colors.ANSI_DEFAULT + "\t" + i + Colors.ANSI_DEFAULT + "\t");
        }

        System.out.println();
        for (int i = 0; i < table.length; i++) {
            System.out.print(Colors.ANSI_DEFAULT + "" + i + " ");

            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j].getValue().toString().equalsIgnoreCase("O"))
                    System.out.print(Colors.ANSI_DEFAULT + "|\t" + Colors.ANSI_GREEN + table[i][j].getValue() + Colors.ANSI_DEFAULT + "\t|");
                else
                    System.out.print(Colors.ANSI_DEFAULT + "|\t" + Colors.ANSI_RED + table[i][j].getValue() + Colors.ANSI_DEFAULT + "\t|");
            }
            System.out.print(Colors.ANSI_DEFAULT + "\n");
        }
    }

    public void clearBoard() {
        for (int i = 0; i < table.length; i++)
            for (int j = 0; j < table[i].length; j++)
                table[i][j] = new EmptyCell();
    }
}
