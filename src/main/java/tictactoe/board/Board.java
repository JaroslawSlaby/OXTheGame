package tictactoe.board;

import tictactoe.engine.Dimensions.Dimensions;
import tictactoe.exceptions.WrongSizeException;

public class Board {

    private Dimensions dimensionsOfBoard;

    private Board(Dimensions sizeOfBoard) {
        this.dimensionsOfBoard = sizeOfBoard;

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
        return dimensionsOfBoard.getWidth();
    }

    public int getHeight() {
        return dimensionsOfBoard.getHeight();
    }
}
