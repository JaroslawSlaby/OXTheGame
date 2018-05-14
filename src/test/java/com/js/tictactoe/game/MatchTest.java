package com.js.tictactoe.game;

import com.js.tictactoe.player.Player;
import com.js.tictactoe.player.Sign;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

@Test
public class MatchTest {

    private final List<Player> players = new ArrayList<>();
    private Match match;

    @BeforeMethod
    public void setUp() {
        match = new Match();
        players.add(new Player(Sign.X, "Jarek"));
        players.add(new Player(Sign.O, "Rafal"));
        match.setPlayers(players);
    }

    public void addNewEmptyListWithPlayersAndCheckIfAllHaveZeroPoints() {
        assertEquals(0, (int) match.getPlayersScore(players.get(0)));
    }

    public void addWinningToFirstPlayer() {
        match.addGameWinner(players.get(0));
        assertEquals(3, (int) match.getPlayersScore(players.get(0)));
    }

    public void addDrawAfterWinningToFirstPlayer() {
        match.addGameWinner(players.get(0));
        match.addGameDraw();
        assertEquals(4, (int) match.getPlayersScore(players.get(0)));
    }

}
