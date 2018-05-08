package com.js.tictactoe.game;

import com.js.tictactoe.board.Board;
import com.js.tictactoe.board.coords.Coordinates;
import com.js.tictactoe.exceptions.WrongIndexException;
import com.js.tictactoe.judge.Judge;
import com.js.tictactoe.parser.DigitParser;
import com.js.tictactoe.parser.InputParser;
import com.js.tictactoe.player.Player;
import com.js.tictactoe.player.PlayersGenerator;

import java.util.List;
import java.util.Scanner;

public class Game {

    private Board board;
    private Scanner scanner = new Scanner(System.in);
    private Player currentPlayer;
    private Judge judge;
    private List<Player> players;
    private Match match;

    public Game(Board board) {
        this.board = board;
    }

    public void runGame() {
        int signsCount = getNumberOfSignsToWin();
        players = PlayersGenerator.createPlayers(scanner::nextLine);
        match = new Match();
        match.setPlayers(players);
        judge = new Judge(board, signsCount);

        do {
            currentPlayer = chooseStartingPlayer();
        } while (currentPlayer == null);


        playingLoop(match);

        System.out.println("Match is end! Situation: " + match.getWinnerOrDraw() + "! Congratulations!");

    }

    private void playingLoop(Match match) {
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


    private int getNumberOfSignsToWin() {
        boolean isValid;
        String line;
        do {
            System.out.println("Enter number of signs to win: ");
            line = scanner.nextLine();
            isValid = DigitParser.isInputContainingDigits(line);
        } while (!isValid);

        int number = Integer.parseInt(line);
        int min = board.getWidth() > board.getHeight() ? board.getHeight() : board.getWidth();

        if (number <= min && number >= 3) {
            System.out.println("Correct number");
            return number;
        } else {
            System.out.println("Incorrect number. Sequence to win: " + min);
            return min;
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
                String line = DigitParser.correctCoordinates(scanner::nextLine);

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
            line = scanner.nextLine();
            makeMove(line, currentPlayer);
        }
        return true;
    }


    private Player chooseStartingPlayer() {

        System.out.println("Who does start? O/X");
        String line = scanner.nextLine();

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
