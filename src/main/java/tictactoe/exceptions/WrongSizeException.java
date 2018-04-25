package tictactoe.exceptions;

public class WrongSizeException extends Exception {

    public static final long serialVersionUID = 24590L;

    public WrongSizeException(String message) {
        super(message);
    }
}
