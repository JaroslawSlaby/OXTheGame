package tictactoe.board.coords;

public class Coordinates {

    private String X;
    private String Y;

    private Coordinates(String firstCorrectCoordinate, String secondCorrectCoordinate) {
        this.X = firstCorrectCoordinate;
        this.Y = secondCorrectCoordinate;
    }

    public static Coordinates parseCoordinates(String s) {
        String[] elements = s.split("\\s+");
        return new Coordinates(elements[0], elements[1]);
    }

    public int getIntegerX() {
        return Integer.parseInt(X);
    }

    public int getIntegerY() {
        return Integer.parseInt(Y);
    }
}
