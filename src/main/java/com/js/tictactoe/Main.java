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
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {


        InputValidator validator = new TableSizeValidator();

        System.out.println("Let's go!");
        String line;
        boolean correctBoardSize;

        do {
            System.out.println("Enter board size (All dimensions must be higher than 3) [pattern: x y]: ");
            line = inputTableSize();
            correctBoardSize = validator.validate(line);
        } while (!correctBoardSize);


        try {
            int[] size = InputParser.parseStringInput(line);
            int width = size[0];
            int height = size[1];
            Game game = new Game(Board.getRectangleBoard(width, height), size[0] * size[1]);
            game.runGame();
        } catch (WrongSizeException e) {
            e.printStackTrace();
        }

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
