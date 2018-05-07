package com.js.tictactoe.player;

import com.js.tictactoe.validators.InputValidator;
import com.js.tictactoe.validators.PlayerSignValidator;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class PlayersGenerator {

    public static List<Player> createPlayers() {

        List<Player> players = new LinkedList<>();

        System.out.println("Enter 1st player name: ");
        String name = PlayersGenerator.createName(new Scanner(System.in)::nextLine);
        Sign sign = PlayersGenerator.createSign(new Scanner(System.in)::nextLine);

        Player player = new Player(sign, name);
        players.add(player);

        System.out.println("Enter 2nd player name: ");
        name = PlayersGenerator.createName(new Scanner(System.in)::nextLine);
        sign = sign.getOppositePlayer();

        Player player1 = new Player(sign, name);
        players.add(player1);

        return players;
    }

    private static String createName(Supplier<String> input) {
        String name;
        do {
            name = input.get();
        } while (name.equalsIgnoreCase(""));

        return name;
    }

    private static Sign createSign(Supplier<String> input) {
        InputValidator validator = new PlayerSignValidator();
        String sign;
        boolean correct;
        do {
            System.out.println("Choose sign (O/X)");
            sign = input.get();
            correct = validator.validate(sign);
        } while (!correct);

        return Sign.valueOf(sign.toUpperCase());
    }
}
