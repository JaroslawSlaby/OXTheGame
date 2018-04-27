package com.js.tictactoe.board.game;

import com.js.tictactoe.board.Board;
import com.js.tictactoe.board.coords.Coordinates;
import com.js.tictactoe.exceptions.WrongIndexException;
import com.js.tictactoe.judge.Judge;
import com.js.tictactoe.parser.DigitParser;
import com.js.tictactoe.parser.InputParser;
import com.js.tictactoe.player.Player;
import com.js.tictactoe.player.PlayersGenerator;
import com.js.tictactoe.player.Sign;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Board board;
    private int moves;

    private Scanner scanner = new Scanner(System.in);
    private Player currentPlayer;


    private List<Player> players;

    public Game(Board board, int moves) {
        this.board = board;
        this.moves = moves;
    }

    public void runGame() {
        players = new LinkedList<>();
        createPlayers();

        currentPlayer = players.get(0);

        boolean isWinner = false;

        int i = 0;
        do {

            board.printBoard();
            boolean added;
            do {
                System.out.println("Player " + currentPlayer.getName() +
                        " make your move [pattern: x y] and x must be lower than " + board.getWidth() + ", y lower than " + board.getHeight());
                String line = correctCoordinates();
                added = makeMove(line, currentPlayer);
            } while (!added);

            Judge judge = new Judge(board, board.getWidth() > board.getHeight() ? board.getHeight() : board.getWidth());
            isWinner = judge.isWinner();

            switchPlayers();
            i++;
        } while (!isWinner);
        board.printBoard();
        System.out.println("Game ended!");
    }

    private void switchPlayers() {

        if (currentPlayer.equals(players.get(0))) {
            currentPlayer = players.get(1);
        } else {
            currentPlayer = players.get(0);
        }
    }

    private void createPlayers() {
        System.out.println("Enter 1st player name: ");
        String name = PlayersGenerator.createName(scanner::nextLine);
        Sign sign = PlayersGenerator.createSign(scanner::nextLine);

        Player player = new Player(sign, name);
        players.add(player);

        System.out.println("Enter 2nd player name: ");
        name = PlayersGenerator.createName(scanner::nextLine);
        sign = sign.getOppositePlayer();

        Player player1 = new Player(sign, name);
        players.add(player1);
    }


    private boolean makeMove(String line, Player currentPlayer) {
        try {
            int[] coords = InputParser.parseStringInput(line);
            return board.insertSign(Coordinates.parseCoordinates(coords), currentPlayer.getSign());
        } catch (WrongIndexException | NumberFormatException e) {
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
                System.out.println("Wrong coordinates!");

        } while (!isNumber);
        return line;
    }
}
