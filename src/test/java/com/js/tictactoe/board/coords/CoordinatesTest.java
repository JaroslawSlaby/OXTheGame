package com.js.tictactoe.board.coords;

import com.js.tictactoe.exceptions.WrongIndexException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class CoordinatesTest {

    private static final String FIRST_CORRECT_COORDINATE = "1";
    private static final String SECOND_CORRECT_COORDINATE = "2";
    private static final int FIRST_COORDINATE_INT = 1;
    private static final int SECOND_COORDINATE_INT = 2;

    public void parseCoordinatesFromCorrectString() throws WrongIndexException {
        Coordinates coordinates = Coordinates.parseCoordinates(FIRST_CORRECT_COORDINATE + " " + SECOND_CORRECT_COORDINATE);
        assertEquals(FIRST_COORDINATE_INT, coordinates.getIntegerX());
    }

    public void checkIfAllCoordinatesAreParsedCorrectly() throws WrongIndexException {
        Coordinates coordinates = Coordinates.parseCoordinates(FIRST_CORRECT_COORDINATE + " " + SECOND_CORRECT_COORDINATE);
        int[] correct = {FIRST_COORDINATE_INT, SECOND_COORDINATE_INT};
        int[] fromCoordinates = {coordinates.getIntegerX(), coordinates.getIntegerY()};
        assertEquals(correct, fromCoordinates);
    }

    @Test(expectedExceptions = WrongIndexException.class)
    public void insertCorrectSignToBoardInIncorrectCoordinates() throws WrongIndexException {
        Coordinates.parseCoordinates("-1 -2");
    }

    @Test(expectedExceptions = WrongIndexException.class)
    public void insertCorrectSignToBoardInNonIntegerCoordinates() throws WrongIndexException {
        int[] table = {-1, -2};
        Coordinates.parseCoordinates(table);
    }

    @Test
    public void insertCorrectSignToBoardInCorrectCoordinates() throws WrongIndexException {
        int[] table = {1, 2};
        Coordinates coords = Coordinates.parseCoordinates(table);
        assertEquals(FIRST_COORDINATE_INT, coords.getIntegerX());
    }

}
