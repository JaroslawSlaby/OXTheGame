package com.js.tictactoe.board;

import com.js.tictactoe.board.coords.Coordinates;
import com.js.tictactoe.exceptions.WrongIndexException;
import com.js.tictactoe.exceptions.WrongSizeException;
import com.js.tictactoe.player.Sign;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class BoardTest {

    private static final int DEFAULT_SIZE_OF_BOARD = 3;
    private static final int DEFAULT_WIDTH = 4;
    private static final int DEFAULT_HEIGHT = 5;

    public void createBoard() throws WrongSizeException {
        Board board = Board.getSquareBoard(DEFAULT_SIZE_OF_BOARD);
        assertEquals(DEFAULT_SIZE_OF_BOARD, board.getWidth());
    }

    public void createTwoDimensionalBoard() throws WrongSizeException {
        Board board = Board.getRectangleBoard(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        assertEquals(DEFAULT_WIDTH, board.getWidth());
    }

    @Test(expectedExceptions = WrongSizeException.class)
    public void createSquareBoardWithZeroDimension() throws WrongSizeException {
        Board.getSquareBoard(0);
    }

    @Test(expectedExceptions = WrongSizeException.class)
    public void createRectangleBoardWithZeroDimension() throws WrongSizeException {
        Board.getRectangleBoard(0, 0);
    }

    public void insertCorrectSignToBoardInCorrectCoordinates() throws WrongSizeException, WrongIndexException {
        Board board = Board.getSquareBoard(DEFAULT_SIZE_OF_BOARD);
        Sign sign = Sign.X;
        Coordinates coordinates = Coordinates.parseCoordinates("1 2");
        boolean isAdded = board.insertSign(coordinates, sign);
        assertTrue(isAdded);
    }

    @Test(expectedExceptions = WrongIndexException.class)
    public void insertCorrectSignToBoardInIncorrectCoordinates() throws WrongSizeException, WrongIndexException {
        Board board = Board.getSquareBoard(DEFAULT_SIZE_OF_BOARD);
        Sign sign = Sign.X;
        Coordinates coordinates = Coordinates.parseCoordinates("-1 -2");
        board.insertSign(coordinates, sign);
    }

    public void insertCorrectSignToFilledCellInBoard() throws WrongIndexException, WrongSizeException {
        Board board = Board.getSquareBoard(DEFAULT_SIZE_OF_BOARD);
        Sign sign = Sign.X;
        Coordinates coordinates = Coordinates.parseCoordinates("1 2");
        board.insertSign(coordinates, sign);
        sign = sign.getOppositePlayer();
        boolean isAdded = board.insertSign(coordinates, sign);
        assertFalse(isAdded);
    }

    public void insertSingInCoordinatesBiggerThanTableSize() throws WrongSizeException, WrongIndexException {
        Board board = Board.getSquareBoard(5);
        Sign sign = Sign.O;
        Coordinates coordinates = Coordinates.parseCoordinates("10 10");
        boolean isAdded = board.insertSign(coordinates, sign);
        assertFalse(isAdded);
    }

}
