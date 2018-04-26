package com.js.tictactoe.board.cell;

import com.js.tictactoe.player.Sign;

public class CellWithValue implements Cell {

    private Sign sign;

    public CellWithValue(Sign sign) {
        this.sign = sign;
    }

    @Override
    public boolean isCellEmpty() {
        return false;
    }

    @Override
    public Sign getValue() {
        return sign;
    }
}
