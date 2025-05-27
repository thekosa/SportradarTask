package scoreboard;

import org.junit.jupiter.api.Test;
import pl.kosieradzki.exceptions.InvalidTeamNameException;
import pl.kosieradzki.scoreboard.Match;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MatchTest {
    @Test
    void shouldThrowWhenTeamNameIsInvalid() {
        assertThrows(InvalidTeamNameException.class, () -> new Match("Mexico", ""));
        assertThrows(InvalidTeamNameException.class, () -> new Match("   ", "Spain"));
        assertThrows(InvalidTeamNameException.class, () -> new Match("-----", ""));
    }
}
