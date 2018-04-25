package com.js.tictactoe.player;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignTest {

    @Test
    public void createNewXSign() {
        Sign sign = Sign.X;
        Assert.assertEquals("X", sign.toString());
    }

    @Test
    public void createNewOSign() {
        Sign sign = Sign.O;
        Assert.assertEquals("O", sign.toString());
    }

    @Test
    public void getOppositePlayerToX() {
        Sign signX = Sign.X;
        Sign signO = signX.getOppositePlayer();
        Assert.assertEquals(Sign.O, signO);
    }

    @Test
    public void getOppositePlayerToO() {
        Sign signO = Sign.O;
        Sign signX = signO.getOppositePlayer();
        Assert.assertEquals(Sign.X, signX);
    }
}
