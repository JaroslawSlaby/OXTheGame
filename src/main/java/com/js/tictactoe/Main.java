package com.js.tictactoe;

import com.js.tictactoe.board.Board;
import com.js.tictactoe.board.game.Game;
import com.js.tictactoe.exceptions.WrongIndexException;
import com.js.tictactoe.exceptions.WrongSizeException;
import com.js.tictactoe.player.Sign;

public class Main {

    public static void main(String[] args) {
        System.out.println("Let's go!");
        try {
            Game game = new Game(Board.getSquareBoard(5), Sign.X, Sign.O);
            game.runGame();
        } catch (WrongSizeException | WrongIndexException e) {
            e.printStackTrace();
        }

    }
}
