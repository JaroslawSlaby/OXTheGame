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
    private int moves;

    public Game(Board board, Sign signO, Sign signX, int moves) {
        this.board = board;
        this.signO = signO;
        this.signX = signX;
        this.moves = moves;
    }

    public void runGame() throws WrongIndexException {

        Scanner scanner = new Scanner(System.in);

        Sign currentPlayer = signO;
        int i = 0;
        while (i < moves) {
            board.printBoard();
            boolean added;
            do {
                System.out.println("Player " + currentPlayer.toString() + " make your move [pattern: x y] and x must be lower than " + board.getHeight() + ", y lower than " + board.getWidth());
                String line = scanner.nextLine();
                added = board.insertSign(Coordinates.parseCoordinates(line), currentPlayer);
            } while (!added);
            currentPlayer = currentPlayer.getOppositePlayer();
            i++;
        }
        board.printBoard();
        System.out.println("Game ended!1");
    }
}
