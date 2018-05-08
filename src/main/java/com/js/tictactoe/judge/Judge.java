package com.js.tictactoe.judge;

import com.js.tictactoe.board.Board;
import com.js.tictactoe.board.cell.Cell;
import com.js.tictactoe.board.coords.Coordinates;
import com.js.tictactoe.player.Sign;

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

        return isWinnerInRow(y, sign) || isWinnerInColumn(x, sign) || isWinnerInDiagonal1(x, y, sign) || isWinnerInDiagonal2(x, y, sign);

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

    private boolean isWinnerInDiagonal1(int x, int y, Sign sign) {

        int counter = 1;

        int boundary = -amount + 1;

        StringBuilder line = new StringBuilder();

        for (int i = boundary; i < amount; i++) {

            int currX = x + i;
            int currY = y + i;


            if (checkPositionX(currX) && checkPositionY(currY)) {

                Cell cell = board.getCell(currX, currY);
                if (!cell.isCellEmpty() && cell.getValue().equals(sign)) {
                    line.append(cell.getValue());
                }

            }
        }

        return line.toString().length() == amount;

    }

    private boolean isWinnerInDiagonal2(int x, int y, Sign sign) { //todo: incorrect

        int counter = 1;

        int sum = x + y;

        int startX = sum > board.getWidth() ? sum - board.getWidth() + 1 : 0;
        int startY = sum > board.getHeight() ? board.getHeight() - 1 : sum;

//        for(; startX < board.getWidth() - 1; startX++) {
//
//            for (; startY > board.getHeight() - 1; startY--) {
//
//                if (!board.getCell(startX, startY).isCellEmpty() && board.getCell(startX, startY).getValue().equals(sign) && board.getCell(startX, startY).getValue().equals(board.getCell(startX + 1, startY - 1).getValue())) {
//                    counter++;
//                }
//            }
//        }


        return counter >= amount;
    }

    private boolean checkWinningInUnit(String line) {
        return line.matches("");
    }

    private boolean checkPositionX(int position) {
        return position >= 0 && position < board.getHeight() - 1;
    }

    private boolean checkPositionY(int position) {
        return position >= 0 && position < board.getWidth() - 1;
    }
}
