package tictactoe.board.coords;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CoordinatesTest {

    private static final String FIRST_CORRECT_COORDINATE = "1";
    private static final String SECOND_CORRECT_COORDINATE = "2";
    private static final int FIRST_COORDINATE_INT = 1;
    private static final int SECOND_COORDINATE_INT = 2;

    @Test
    public void parseCoordinatesFromCorrectString() {
        Coordinates coordinates = Coordinates.parseCoordinates(FIRST_CORRECT_COORDINATE + " " + SECOND_CORRECT_COORDINATE);
        Assert.assertEquals(FIRST_COORDINATE_INT, coordinates.getIntegerX());
    }

    @Test
    public void checkIfAllCoordinatesAreParsedCorrectly() {
        Coordinates coordinates = Coordinates.parseCoordinates(FIRST_CORRECT_COORDINATE + " " + SECOND_CORRECT_COORDINATE);
        int[] correct = {FIRST_COORDINATE_INT, SECOND_COORDINATE_INT};
        int[] fromCoordinates = {coordinates.getIntegerX(), coordinates.getIntegerY()};
        Assert.assertEquals(correct, fromCoordinates);
    }

}
