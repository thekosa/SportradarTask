package scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kosieradzki.exceptions.GameAlreadyStartedException;
import pl.kosieradzki.exceptions.GameNotFoundException;
import pl.kosieradzki.exceptions.InvalidScoreException;
import pl.kosieradzki.scoreboard.LiveScoreBoard;
import pl.kosieradzki.scoreboard.Match;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void updateScoreTest() {
        liveScoreBoard.startGame(new Match("Mexico", "Canada"));
        liveScoreBoard.updateScore(0, 5);
        assertEquals(0, liveScoreBoard.getMatch().getHomeTeamScore());
        assertEquals(5, liveScoreBoard.getMatch().getAwayTeamScore());
    }

    @Test
    void finishGameTest() {
        liveScoreBoard.startGame(new Match("Mexico", "Canada"));
        liveScoreBoard.finishGame();
        assertFalse(liveScoreBoard.isLive());
    }

    @Test
    void shouldThrowWhenUpdatingNonExistentMatch() {
        LiveScoreBoard lsb = new LiveScoreBoard();
        assertThrows(GameNotFoundException.class, () -> lsb.updateScore(1, 1));
    }

    @Test
    void shouldThrowWhenScoreExceedsLimit() {
        LiveScoreBoard lsb = new LiveScoreBoard();
        lsb.startGame(new Match("A", "B"));
        assertThrows(InvalidScoreException.class, () -> lsb.updateScore(-25, 3));
        assertThrows(InvalidScoreException.class, () -> lsb.updateScore(2, 10002));
    }

    @Test
    void shouldThrowWhenGameAlreadyStarted() {
        LiveScoreBoard lsb = new LiveScoreBoard();
        Match match = new Match("Mexico", "Canada");
        lsb.startGame(match);
        assertThrows(GameAlreadyStartedException.class, () -> lsb.startGame(match));
    }
}
