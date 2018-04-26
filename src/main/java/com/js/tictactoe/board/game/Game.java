package com.js.tictactoe.board.game;

import com.js.tictactoe.board.Board;
import com.js.tictactoe.board.coords.Coordinates;
import com.js.tictactoe.exceptions.WrongIndexException;
import com.js.tictactoe.player.Sign;

import java.util.Scanner;

public class Game {

    private Board board;
    private Sign signO;
    private Sign signX;

    public Game(Board board, Sign signO, Sign signX) {
        this.board = board;
        this.signO = signO;
        this.signX = signX;
    }

    public void runGame() throws WrongIndexException {

        Scanner scanner = new Scanner(System.in);

        Sign currentPlayer = signO;
        int i = 0;
        while (i < 9) {
            board.printBoard();
            System.out.println("Player " + currentPlayer.toString() + " make your move");
            String line = scanner.nextLine();
            board.insertSign(Coordinates.parseCoordinates(line), currentPlayer);
            currentPlayer = currentPlayer.getOppositePlayer();
            i++;
        }
    }
}
