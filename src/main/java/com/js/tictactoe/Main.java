package com.js.tictactoe;

import com.js.tictactoe.board.Board;
import com.js.tictactoe.board.game.Game;
import com.js.tictactoe.exceptions.WrongIndexException;
import com.js.tictactoe.exceptions.WrongSizeException;
import com.js.tictactoe.parser.InputParser;
import com.js.tictactoe.player.Sign;
import com.js.tictactoe.validators.InputValidator;
import com.js.tictactoe.validators.TableSizeValidator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        InputValidator validator = new TableSizeValidator();

        System.out.println("Let's go!");
        String line;
        boolean correctBoardSize;

        do {
            System.out.println("Enter board size [pattern: x y]: ");
            line = in.nextLine();
            correctBoardSize = validator.validate(line);
        } while (!correctBoardSize);


        try {
            int[] size = InputParser.parseStringInput(line);
            Game game = new Game(Board.getRectangleBoard(size[0], size[1]), Sign.X, Sign.O, size[0] * size[1]);
            game.runGame();
        } catch (WrongSizeException | WrongIndexException e) {
            e.printStackTrace();
        }

    }
}
