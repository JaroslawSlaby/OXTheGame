package com.js.tictactoe.player;

import com.js.tictactoe.language.Language;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Test
public class PlayersGeneratorTest {

  public void testCreatePlayers() {
    List<Player> players = PlayersGenerator.createPlayers(() -> "O", e -> {
    }, new Language("PL"));
    assertTrue(players.get(0).getName().equalsIgnoreCase("O"));
  }

  public void testCreatePlayersWithCorrectInput() {
    List<Player> players = PlayersGenerator.createPlayers(() -> "X", e -> {
    }, new Language("PL"));
    assertFalse(players.get(0).getName().equalsIgnoreCase("O"));
  }
}
