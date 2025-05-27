package scoreboard;

import org.junit.jupiter.api.Test;
import pl.kosieradzki.exceptions.InvalidTeamNameException;
import pl.kosieradzki.scoreboard.Match;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MatchTest {
    @Test
    void shouldSetAndGetScoresCorrectly() {
        Match match = new Match("TeamA", "TeamB");
        match.setHomeTeamScore(2);
        match.setAwayTeamScore(3);
        assertEquals(2, match.getHomeTeamScore());
        assertEquals(3, match.getAwayTeamScore());
    }

    @Test
    void shouldCalculateSumCorrectly() {
        Match match = new Match("A", "B");
        match.setHomeTeamScore(1);
        match.setAwayTeamScore(4);
        match.sum();
        assertEquals(5, match.getSum());
    }

    @Test
    void shouldThrowWhenTeamNameIsInvalid() {
        assertThrows(InvalidTeamNameException.class, () -> new Match("Mexico", ""));
        assertThrows(InvalidTeamNameException.class, () -> new Match("   ", "Spain"));
        assertThrows(InvalidTeamNameException.class, () -> new Match("-----", ""));
    }
}
