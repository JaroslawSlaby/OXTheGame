package com.js.tictactoe.player;

import com.js.tictactoe.language.FileReader;
import com.js.tictactoe.validators.InputValidator;
import com.js.tictactoe.validators.PlayerSignValidator;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PlayersGenerator {

  public static List<Player> createPlayers(Supplier<String> input, Consumer<String> output, FileReader reader) {

    List<Player> players = new LinkedList<>();
    String name = PlayersGenerator.createName(input, output, reader);
    Sign sign = PlayersGenerator.createSign(input, output, name, reader);

    Player player = new Player(sign, name);
    players.add(player);

    name = PlayersGenerator.createName(input, output, reader);
    sign = sign.getOppositePlayer();

    Player player1 = new Player(sign, name);
    players.add(player1);

    return players;
  }

  private static String createName(Supplier<String> input, Consumer<String> output, FileReader reader) {
    String name;
    do {
      output.accept(reader.loadString("playerName"));
      name = input.get();
    } while (name.length() == 0);

    return name;
  }

  private static Sign createSign(Supplier<String> input, Consumer<String> output, String name, FileReader reader) {
    InputValidator validator = new PlayerSignValidator();
    String sign;
    boolean correct;
    do {
      output.accept(reader.loadString("playerSign") + name + ": ");
      sign = input.get();
      correct = validator.validate(sign);
    } while (!correct);

    return Sign.valueOf(sign.toUpperCase());
  }
}
