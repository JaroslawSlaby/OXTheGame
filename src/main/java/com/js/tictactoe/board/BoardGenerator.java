package com.js.tictactoe.board;

import com.js.tictactoe.board.cell.Cell;
import com.js.tictactoe.board.cell.EmptyCell;
import com.js.tictactoe.engine.Dimensions.Dimensions;

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

    public void printBoard() {

        for (Cell[] aTable : table) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.print("| " + aTable[j].getValue() + " |");
            }

            System.out.print("\n");
        }

    }
}
