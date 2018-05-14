package com.js.tictactoe.player;

import com.js.tictactoe.validators.InputValidator;
import com.js.tictactoe.validators.PlayerSignValidator;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PlayersGenerator {

  public static List<Player> createPlayers(Supplier<String> input, Consumer<String> output) {

    List<Player> players = new LinkedList<>();
    String name = PlayersGenerator.createName(input, output);
    Sign sign = PlayersGenerator.createSign(input, output, name);

    Player player = new Player(sign, name);
    players.add(player);

    name = PlayersGenerator.createName(input, output);
    sign = sign.getOppositePlayer();

    Player player1 = new Player(sign, name);
    players.add(player1);

    return players;
  }

  private static String createName(Supplier<String> input, Consumer<String> output) {
    String name;
    do {
      output.accept("Enter player name: ");
      name = input.get();
    } while (name.length() == 0);

    return name;
  }

  private static Sign createSign(Supplier<String> input, Consumer<String> output, String name) {
    InputValidator validator = new PlayerSignValidator();
    String sign;
    boolean correct;
    do {
      output.accept("Choose sign (O/X) for player " + name + ": ");
      sign = input.get();
      correct = validator.validate(sign);
    } while (!correct);

    return Sign.valueOf(sign.toUpperCase());
  }
}
