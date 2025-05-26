package pl.kosieradzki.exceptions;

public class InvalidScoreException extends RuntimeException {
    public InvalidScoreException(String message) {
        super(message);
    }
    public InvalidScoreException(int score) {
        super("Invalid score: " + score);
    }
}
