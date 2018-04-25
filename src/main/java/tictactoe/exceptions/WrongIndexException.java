package tictactoe.exceptions;

public class WrongIndexException extends Exception {

    public static final long serialVersionUID = 8248914162461284L;

    public WrongIndexException(String message) {
        super(message);
    }
}
