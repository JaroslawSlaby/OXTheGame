package com.js.tictactoe.game.configuration;

import com.js.tictactoe.board.Board;
import com.js.tictactoe.parser.DigitParser;
import com.js.tictactoe.player.Player;

import java.util.List;
import java.util.function.Supplier;

public class Configuration {

    private Supplier<String> input;
    private Board board;
    private int signSequence = 0;

    public Configuration(Supplier<String> input, Board board) {
        this.input = input;
        this.board = board;
    }

    public int chooseSequenceNumber() {
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
