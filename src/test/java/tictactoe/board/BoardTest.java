package tictactoe.board;

import org.testng.Assert;
import org.testng.annotations.Test;
import tictactoe.board.coords.Coordinates;
import tictactoe.exceptions.WrongIndexException;
import tictactoe.exceptions.WrongSizeException;
import tictactoe.player.Sign;

public class BoardTest {

    private static final int DEFAULT_SIZE_OF_BOARD = 3;
    private static final int DEFAULT_WIDTH = 4;
    private static final int DEFAULT_HEIGHT = 5;

    @Test
    public void createBoard() throws WrongSizeException {
        Board board = Board.getSquareBoard(DEFAULT_SIZE_OF_BOARD);
        Assert.assertEquals(DEFAULT_SIZE_OF_BOARD, board.getWidth());
    }

    @Test
    public void createTwoDimensionalBoard() throws WrongSizeException {
        Board board = Board.getRectangleBoard(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        Assert.assertEquals(DEFAULT_WIDTH, board.getWidth());
    }

    @Test(expectedExceptions = WrongSizeException.class)
    public void createSquareBoardWithZeroDimension() throws WrongSizeException {
        Board.getSquareBoard(0);
    }

    @Test(expectedExceptions = WrongSizeException.class)
    public void createRectangleBoardWithZeroDimension() throws WrongSizeException {
        Board.getRectangleBoard(0, 0);
    }

    @Test
    public void insertCorrectSignToBoardInCorrectCoordinates() throws WrongSizeException, WrongIndexException {
        Board board = Board.getSquareBoard(DEFAULT_SIZE_OF_BOARD);
        Sign sign = Sign.X;
        Coordinates coordinates = Coordinates.parseCoordinates("1 2");
        boolean isAdded = board.insertSign(coordinates, sign);
        Assert.assertEquals(true, isAdded);
    }


}
