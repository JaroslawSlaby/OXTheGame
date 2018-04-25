package com.js.tictactoe.board;

import com.js.tictactoe.engine.Dimensions.Dimensions;
import com.js.tictactoe.player.Sign;

class BoardGenerator {

    Sign[][] table;

    void createEmptyBoard(Dimensions dimensions) {
        table = new Sign[dimensions.getWidth()][dimensions.getWidth()];
    }
}
