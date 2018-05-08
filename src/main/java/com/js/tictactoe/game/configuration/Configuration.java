package com.js.tictactoe.game.configuration;

import com.js.tictactoe.board.Board;
import com.js.tictactoe.exceptions.WrongSizeException;
import com.js.tictactoe.parser.DigitParser;
import com.js.tictactoe.parser.InputParser;
import com.js.tictactoe.player.Player;
import com.js.tictactoe.player.PlayersGenerator;
import com.js.tictactoe.validators.InputValidator;
import com.js.tictactoe.validators.TableSizeValidator;

import java.util.List;
import java.util.function.Supplier;

public class Configuration {

    private Supplier<String> input;
    private Board board;

    public Configuration(Supplier<String> input) {
        this.input = input;
    }


    public Board createTable() {
        String line = getInput();
        try {
            return newBoardAfterParsing(line);
        } catch (WrongSizeException | OutOfMemoryError e) {
            System.out.println("wrong size");
            createTable();
        }
        return null;
    }

    private Board newBoardAfterParsing(String line) throws WrongSizeException {
        int[] size = InputParser.parseStringInput(line);
        int width = size[0];
        int height = size[1];
        board = Board.getRectangleBoard(width, height);
        return board;
    }


    private String getInput() {
        InputValidator validator = new TableSizeValidator();
        String line;
        System.out.println("Enter board size (All dimensions must be higher or equal 3 and less than 100) [pattern: x y (or x if you want square board)]: ");
        line = inputTableSize();
        validator.validate(line);
        return line;
    }

    private String inputTableSize() {
        boolean isNumber;
        String line;
        do {
            line = input.get();
            isNumber = DigitParser.isInputContainingDigits(line);

            if (!isNumber)
                System.out.println("Wrong table size!");
        } while (!isNumber);

        return line;
    }

    public int chooseSequenceNumber() {
        int signSequence;
        do {
            signSequence = getNumberOfSignsToWin();
        } while (signSequence == 0);

        return signSequence;
    }

    private int getNumberOfSignsToWin() {
        boolean isValid;
        String line;
        do {
            System.out.println("Enter number of signs to win: ");
            line = input.get();
            isValid = DigitParser.isInputContainingDigits(line);
        } while (!isValid);

        int number = Integer.parseInt(line);
        int min = board.getWidth() > board.getHeight() ? board.getHeight() : board.getWidth();

        if (number <= min && number >= 3) {
            return number;
        } else {
            System.out.println("Incorrect number. Try again");
            return 0;
        }
    }

    public List<Player> createPlayers() {
        List<Player> players = PlayersGenerator.createPlayers(input);
        return players;
    }

    public Player chooseStartingSign(List<Player> players) {
        Player currentPlayer;

        do {
            currentPlayer = chooseStartingPlayer(players);
        } while (currentPlayer == null);

        return currentPlayer;
    }

    private Player chooseStartingPlayer(List<Player> players) {

        System.out.println("Who does start? O/X");
        String line = input.get();

        if (players.get(0).getSign().toString().equalsIgnoreCase(line)) {
            return players.get(0);
        } else if (players.get(1).getSign().toString().equalsIgnoreCase(line)) {
            return players.get(1);
        } else {
            System.out.println("Incorrect player. Try again: ");
            return null;
        }
    }
}
