package com.js.tictactoe.player;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class SignTest {

    public void createNewXSign() {
        Sign sign = Sign.X;
        assertEquals("X", sign.toString());
    }

    public void createNewOSign() {
        Sign sign = Sign.O;
        assertEquals("O", sign.toString());
    }

    public void getOppositePlayerToX() {
        Sign signX = Sign.X;
        Sign signO = signX.getOppositePlayer();
        assertEquals(Sign.O, signO);
    }

    public void getOppositePlayerToO() {
        Sign signO = Sign.O;
        Sign signX = signO.getOppositePlayer();
        assertEquals(Sign.X, signX);
    }
}
