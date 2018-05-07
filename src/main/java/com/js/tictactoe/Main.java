package com.js.tictactoe;

import com.js.tictactoe.board.Board;
import com.js.tictactoe.board.game.Game;
import com.js.tictactoe.exceptions.WrongSizeException;
import com.js.tictactoe.parser.DigitParser;
import com.js.tictactoe.parser.InputParser;
import com.js.tictactoe.validators.InputValidator;
import com.js.tictactoe.validators.TableSizeValidator;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static Game game;

    public static void main(String[] args) {

        System.out.println("Let's go!");
        createTable();

    }

    private static void createTable() {
        String line = getInput();
        try {
            newGame(line);
        } catch (WrongSizeException e) {
            System.out.println("wrong size");
            createTable();
        }
    }

    private static void newGame(String line) throws WrongSizeException {
        int[] size = InputParser.parseStringInput(line);
        int width = size[0];
        int height = size[1];
        game = new Game(Board.getRectangleBoard(width, height));
        game.runGame();
    }


    private static String getInput() {
        InputValidator validator = new TableSizeValidator();
        String line;
        System.out.println("Enter board size (All dimensions must be higher or equal 3) [pattern: x y]: ");
        line = inputTableSize();
        validator.validate(line);
        return line;
    }

    private static String inputTableSize() {
        boolean isNumber;
        String line;
        do {
            line = in.nextLine();
            isNumber = DigitParser.isInputContainingDigits(line);

            if (!isNumber)
                System.out.println("Wrong table size!");
        } while (!isNumber);

        return line;
    }
}