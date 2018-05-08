package com.js.tictactoe.game;

import com.js.tictactoe.board.Board;
import com.js.tictactoe.board.coords.Coordinates;
import com.js.tictactoe.exceptions.WrongIndexException;
import com.js.tictactoe.game.configuration.Configuration;
import com.js.tictactoe.judge.Judge;
import com.js.tictactoe.parser.DigitParser;
import com.js.tictactoe.parser.InputParser;
import com.js.tictactoe.player.Player;

import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class Game {

    private Board board;
    private Supplier<String> input = new Scanner(System.in)::nextLine;
    private Player currentPlayer;
    private Judge judge;
    private List<Player> players;
    private Match match;

    public void runGame() {

        Configuration configuration = new Configuration(input);
        board = configuration.createTable();
        int signsToWin = configuration.chooseSequenceNumber();

        players = configuration.createPlayers();
        setMatch();

        judge = new Judge(board, signsToWin);
        currentPlayer = configuration.chooseStartingSign(players);
        playingLoop();

        System.out.println("Match is end! Situation: " + match.getWinnerOrDraw() + "! Congratulations!");
    }

    private void setMatch() {
        match = new Match();
        match.setPlayers(players);
    }

    private void playingLoop() {
        do {
            boolean winner = move();
            switchPlayers();

            if (winner) {
                match.addGameWinner(currentPlayer);
            } else {
                match.addGameDraw();
            }

            board.printBoard();
            System.out.println("End of round.");
            System.out.println("Player: " + players.get(0).getName() + " Score: " + match.getPlayersScore(players.get(0)));
            System.out.println("Player: " + players.get(1).getName() + " Score: " + match.getPlayersScore(players.get(1)));
            switchPlayers();
            board.clearBoard();

        } while (match.isNextRound());
    }

    private void switchPlayers() {

        if (currentPlayer.equals(players.get(0))) {
            currentPlayer = players.get(1);
        } else {
            currentPlayer = players.get(0);
        }
    }

    private boolean move() {
        boolean isWinner;
        int i = 0;
        do {
            board.printBoard();
            boolean added;
            do {
                System.out.println("Player " + currentPlayer.getName() +
                        " make your move [pattern: x y] and x must be lower than " + board.getWidth() + ", y lower than " + board.getHeight());
                String line = DigitParser.correctCoordinates(input);

                if (line.equalsIgnoreCase("quit")) {
                    match.endMatch();
                    return false;
                }
                added = makeMove(line, currentPlayer);
            } while (!added);

            isWinner = judge.isWinner(currentPlayer.getSign());
            i++;
            switchPlayers();
        } while (!isWinner && i < board.getHeight() * board.getWidth());

        return isWinner;
    }

    private boolean makeMove(String line, Player currentPlayer) {
        try {
            int[] coords = InputParser.parseStringInput(line);
            return board.insertSign(Coordinates.parseCoordinates(coords), currentPlayer.getSign());
        } catch (WrongIndexException | NumberFormatException e) {
            System.out.println("Wrong coordinates, please try again.");
            line = input.get();
            makeMove(line, currentPlayer);
        }
        return true;
    }
}
