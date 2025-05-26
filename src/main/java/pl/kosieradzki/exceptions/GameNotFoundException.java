package pl.kosieradzki.exceptions;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(String homeTeam, String awayTeam) {
        super("Game not found: " + homeTeam + " vs " + awayTeam);
    }

    public GameNotFoundException(String message) {
        super(message);
    }

    public GameNotFoundException() {
        super("Game not found: ");
    }
}
