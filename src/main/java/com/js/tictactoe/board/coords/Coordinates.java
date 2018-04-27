package com.js.tictactoe.board.coords;

import com.js.tictactoe.exceptions.WrongIndexException;

public class Coordinates {

    private String X;
    private String Y;

    private Coordinates(String firstCorrectCoordinate, String secondCorrectCoordinate) {
        this.X = firstCorrectCoordinate;
        this.Y = secondCorrectCoordinate;
    }

    public static Coordinates parseCoordinates(String s) throws WrongIndexException {
        String[] elements = s.split("\\s+");

        if (areCoordinatesPositive(elements))
            return new Coordinates(elements[0], elements[1]);
        else
            throw new WrongIndexException("Both coordinates must be positive numbers!"); //TODO: internationalization
    }

    public static Coordinates parseCoordinates(int[] coordinates) throws WrongIndexException {
        if (coordinates[0] >= 0 && coordinates[1] >= 0)
            return new Coordinates(String.valueOf(coordinates[0]), String.valueOf(coordinates[1]));
        else
            throw new WrongIndexException("Coordinates must be integers!");
    }

    public int getIntegerX() {
        return Integer.parseInt(X);
    }

    public int getIntegerY() {
        return Integer.parseInt(Y);
    }

    private static boolean areCoordinatesPositive(String[] elements) {
        int x = Integer.parseInt(elements[0]);
        int y = Integer.parseInt(elements[1]);

        return x >= 0 && y >= 0;
    }
}
