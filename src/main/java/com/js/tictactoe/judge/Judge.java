package com.js.tictactoe.judge;

import com.js.tictactoe.board.Board;
import com.js.tictactoe.board.cell.Cell;
import com.js.tictactoe.board.coords.Coordinates;

public class Judge {

    private Board board;
    private int amount;

    public Judge(Board board, int amount) {
        this.board = board;
        this.amount = amount;
    }

    public boolean isWinner() {

        Coordinates latest = board.getLatestMove();
        int x = latest.getIntegerX();
        int y = latest.getIntegerY();

        return isWinnerInRow(y) || isWinnerInColumn(x) || isWinnerInDiagonal1(x, y) || isWinnerInDiagonal2(x, y);

    }

    private boolean isWinnerInRow(int row) {

        int counter = 1;

        Cell[] boardRow = board.getRow(row);

        for (int j = 0; j < boardRow.length - 1; j++) {
            if (!boardRow[j].isCellEmpty() && boardRow[j].getValue().equals(boardRow[j + 1].getValue())) {
                counter++;
            }
        }

        return counter == amount;
    }

    private boolean isWinnerInColumn(int column) {

        int counter = 1;

        Cell[] boardColumn = board.getColumn(column);

        for (int j = 0; j < boardColumn.length - 1; j++) {
            if (!boardColumn[j].isCellEmpty() && boardColumn[j].getValue().equals(boardColumn[j + 1].getValue())) {
                counter++;
            }
        }

        return counter == amount;
    }

    private boolean isWinnerInDiagonal1(int x, int y) {
//
//        for (int i = 0; i < board.getWidth(); i++) {
//
//        }

        return false;

    }

    private boolean isWinnerInDiagonal2(int x, int y) {
        return false;
    }
}
