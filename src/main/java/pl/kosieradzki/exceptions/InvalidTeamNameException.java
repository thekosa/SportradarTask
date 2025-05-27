package pl.kosieradzki.exceptions;

public class InvalidTeamNameException extends RuntimeException {
    public InvalidTeamNameException(String name) {
        super("Invalid team name: \"" + name + "\"");
    }
}
