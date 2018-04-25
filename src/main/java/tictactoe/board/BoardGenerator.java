package tictactoe.board;

import tictactoe.engine.Dimensions.Dimensions;
import tictactoe.player.Sign;

public class BoardGenerator {

    public static Sign[][] createEmptyBoard(Dimensions dimensions) {
        return new Sign[dimensions.getWidth()][dimensions.getWidth()];
    }
}
