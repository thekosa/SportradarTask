package scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kosieradzki.scoreboard.LiveScoreBoard;
import pl.kosieradzki.scoreboard.Match;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LiveScoreBoardTest {
    private LiveScoreBoard liveScoreBoard;

    @BeforeEach
    void setUp() {
        liveScoreBoard = new LiveScoreBoard();
    }

    @Test
    void startGameTest() {
        liveScoreBoard.startGame(new Match("Mexico", "Canada"));
        assertEquals(0, liveScoreBoard.getMatch().getHomeTeamScore());
        assertEquals(0, liveScoreBoard.getMatch().getAwayTeamScore());
        assertEquals("Mexico", liveScoreBoard.getMatch().getHomeTeam());
        assertEquals("Canada", liveScoreBoard.getMatch().getAwayTeam());
    }

    @Test
    void incrementScoreTest() {
        liveScoreBoard.startGame(new Match("Mexico", "Canada"));
        liveScoreBoard.incrementScore(liveScoreBoard.getMatch().getHomeTeam());
        assertEquals(1, liveScoreBoard.getMatch().getHomeTeamScore());
    }
}
