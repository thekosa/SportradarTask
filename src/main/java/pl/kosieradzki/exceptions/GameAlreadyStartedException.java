package pl.kosieradzki.exceptions;

public class GameAlreadyStartedException extends RuntimeException {
    public GameAlreadyStartedException(String message) {
        super(message);
    }

    public GameAlreadyStartedException() {
        super("Game already started");
    }
}
