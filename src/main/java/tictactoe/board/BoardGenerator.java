package tictactoe.board;

import tictactoe.engine.Dimensions.Dimensions;
import tictactoe.player.Sign;

class BoardGenerator {

    Sign[][] table;

    void createEmptyBoard(Dimensions dimensions) {
        table = new Sign[dimensions.getWidth()][dimensions.getWidth()];
    }
}
