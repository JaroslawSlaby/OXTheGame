package com.js.tictactoe.board;

import com.js.tictactoe.board.coords.Coordinates;
import com.js.tictactoe.engine.Dimensions.Dimensions;
import com.js.tictactoe.exceptions.WrongSizeException;
import com.js.tictactoe.player.Sign;

public class Board extends BoardGenerator {

    private Board(Dimensions sizeOfBoard) {
        createEmptyBoard(sizeOfBoard);
    }

    public static Board getSquareBoard(int size) throws WrongSizeException {

        if (size < 3) {
            throw new WrongSizeException("Size of square board must be higher than 3!"); //TODO: internationalization
        }

        return new Board(new Dimensions(size));
    }

    public static Board getRectangleBoard(int width, int height) throws WrongSizeException {

        if (width < 3 || height < 3) {
            throw new WrongSizeException("All dimensions of board must be higher than 3!"); //todo: internationalization
        }

        return new Board(new Dimensions(width, height));
    }

    public int getWidth() {
        return table[0].length;
    }

    public int getHeight() {
        return table.length;
    }

    public boolean insertSign(Coordinates coordinates, Sign sign) {
        int x = coordinates.getIntegerX();
        int y = coordinates.getIntegerY();


        table[x][y] = sign;
        return true;
    }
}
