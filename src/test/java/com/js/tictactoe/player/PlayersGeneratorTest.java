package com.js.tictactoe.player;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Test
public class PlayersGeneratorTest {

    public void testCreatePlayers() {
        List<Player> players = PlayersGenerator.createPlayers(() -> "O");
        assertTrue(players.get(0).getName().equalsIgnoreCase("O"));
    }

    public void testCreatePlayersWithCorrectInput() {
        List<Player> players = PlayersGenerator.createPlayers(() -> "X");
        assertFalse(players.get(0).getName().equalsIgnoreCase("O"));
    }
}
