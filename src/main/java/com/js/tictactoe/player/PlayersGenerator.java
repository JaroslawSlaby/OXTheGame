package com.js.tictactoe.player;

import com.js.tictactoe.validators.InputValidator;
import com.js.tictactoe.validators.PlayerSignValidator;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class PlayersGenerator {

  public static List<Player> createPlayers(Supplier<String> input) {

    List<Player> players = new LinkedList<>();

    System.out.println("Enter 1st player name: ");
    String name = PlayersGenerator.createName(input);
    Sign sign = PlayersGenerator.createSign(input, name);

    Player player = new Player(sign, name);
    players.add(player);

    System.out.println("Enter 2nd player name: ");
    name = PlayersGenerator.createName(input);
    sign = sign.getOppositePlayer();

    Player player1 = new Player(sign, name);
    players.add(player1);

    return players;
  }

  private static String createName(Supplier<String> input) {
    String name;
    do {
      name = input.get();
    } while (name.length() == 0);

    return name;
  }

  private static Sign createSign(Supplier<String> input, String name) {
    InputValidator validator = new PlayerSignValidator();
    String sign;
    boolean correct;
    do {
      System.out.println("Choose sign (O/X) for player " + name);
      sign = input.get();
      correct = validator.validate(sign);
    } while (!correct);

    return Sign.valueOf(sign.toUpperCase());
  }
}
