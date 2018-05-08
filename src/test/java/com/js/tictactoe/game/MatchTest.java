package com.js.tictactoe.game;

import com.js.tictactoe.player.Player;
import com.js.tictactoe.player.Sign;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

@Test
public class MatchTest {

    private List<Player> players = new ArrayList<>();
    private Match match;

    @BeforeMethod
    public void setUp() {
        match = new Match();
        players.add(new Player(Sign.X, "Jarek"));
        players.add(new Player(Sign.O, "Rafal"));
        match.setPlayers(players);
    }

    public void addNewEmptyListWithPlayersAndCheckIfAllHaveZeroPoints() {
        assertTrue(match.getPlayersScore(players.get(0)) == 0);
    }

    public void addWinningToFirstPlayer() {
        match.addGameWinner(players.get(0));
        assertTrue(match.getPlayersScore(players.get(0)) == 3);
    }

    public void addDrawAfterWinningToFirstPlayer() {
        match.addGameWinner(players.get(0));
        match.addGameDraw();
        assertTrue(match.getPlayersScore(players.get(0)) == 4);
    }

}
