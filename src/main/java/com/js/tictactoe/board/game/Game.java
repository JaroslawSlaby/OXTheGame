package com.js.tictactoe.board.game;

import com.js.tictactoe.board.Board;
import com.js.tictactoe.board.coords.Coordinates;
import com.js.tictactoe.exceptions.WrongIndexException;
import com.js.tictactoe.parser.DigitParser;
import com.js.tictactoe.parser.InputParser;
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

    Scanner scanner = new Scanner(System.in);
    Sign currentPlayer;

    public void runGame() {

        currentPlayer = signO;
        int i = 0;
        while (i < moves) {
            board.printBoard();
            boolean added;
            do {
                System.out.println("Player " + currentPlayer.toString() + " make your move [pattern: x y] and x must be lower than " + board.getHeight() + ", y lower than " + board.getWidth());
                String line = correctCoordinates();


                added = makeMove(line, currentPlayer);
            } while (!added);
            currentPlayer = currentPlayer.getOppositePlayer();
            i++;
        }
        board.printBoard();
        System.out.println("Game ended!1");
    }

    private boolean makeMove(String line, Sign currentPlayer) {

        try {
            int[] coords = InputParser.parseStringInput(line);
            return board.insertSign(Coordinates.parseCoordinates(coords), currentPlayer);
        } catch (WrongIndexException e) {
            System.out.println("Wrong coordinates, please try again.");
            line = scanner.nextLine();
            makeMove(line, currentPlayer);
        }
        return true;
    }

    private String correctCoordinates() {

        boolean isNumber;
        String line;
        do {

            line = scanner.nextLine();
            isNumber = DigitParser.isInputContainingDigits(line);

            if (!isNumber)
                System.out.println("Wrong coordinates! All dimensions must be more than -1!");

        } while (!isNumber);

        return line;
    }
}
