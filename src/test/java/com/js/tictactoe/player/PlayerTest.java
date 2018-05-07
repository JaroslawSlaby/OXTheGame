package com.js.tictactoe.player;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class PlayerTest {

    public void createPlayerWithCorrectInput() {
        Player player = new Player(Sign.O, "test");
        Sign sign = player.getSign();
        assertEquals(Sign.O, sign);
    }
}
