package com.js.tictactoe.board.game;

import com.js.tictactoe.board.Board;
import com.js.tictactoe.board.coords.Coordinates;
import com.js.tictactoe.exceptions.WrongIndexException;
import com.js.tictactoe.parser.DigitParser;
import com.js.tictactoe.parser.InputParser;
import com.js.tictactoe.player.Player;
import com.js.tictactoe.player.Sign;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Board board;
    private Sign signO;
    private Sign signX;
    private int moves;

    private List<Player> players;

    public Game(Board board, Sign signO, Sign signX, int moves) {
        this.board = board;
        this.signO = signO;
        this.signX = signX;
        this.moves = moves;
    }

    Scanner scanner = new Scanner(System.in);
    Player currentPlayer;

    public void runGame() {

        createPlayers();

        currentPlayer = players.get(0);
        int i = 0;
        while (i < moves) {
            board.printBoard();
            boolean added;
            do {
                System.out.println("Player " + currentPlayer.getName() + " make your move [pattern: x y] and x must be lower than " + board.getHeight() + ", y lower than " + board.getWidth());
                String line = correctCoordinates();


                added = makeMove(line, currentPlayer);
            } while (!added);
            //currentPlayer =
            switchPlayers();
            i++;
        }
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

        players = new LinkedList<>();

        System.out.println("Enter 1st player name: ");
        String name = scanner.nextLine();
        System.out.println("Choose sign (O/X)");
        Sign sign = Sign.valueOf(scanner.nextLine());

        Player player = new Player(sign, name);
        players.add(player);

        System.out.println("Enter 2st player name: ");
        name = scanner.nextLine();
        sign = sign.getOppositePlayer();

        Player player1 = new Player(sign, name);
        players.add(player1);

    }

    private boolean makeMove(String line, Player currentPlayer) {

        try {
            int[] coords = InputParser.parseStringInput(line);
            return board.insertSign(Coordinates.parseCoordinates(coords), currentPlayer.getSign());
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
