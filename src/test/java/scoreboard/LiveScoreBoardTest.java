package scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kosieradzki.scoreboard.LiveScoreBoard;
import pl.kosieradzki.scoreboard.Match;
import pl.kosieradzki.scoreboard.Summary;

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
    void generateSummaryTest() {
        Summary summary = new Summary();

        liveScoreBoard.startGame(new Match("Mexico", "Canada"));
        summary.addMatch(liveScoreBoard.finishGame());

        liveScoreBoard = new LiveScoreBoard();
        liveScoreBoard.startGame(new Match("Spain", "Brazil"));
        liveScoreBoard.updateScore( 10, 2);
        summary.addMatch(liveScoreBoard.finishGame());

        liveScoreBoard = new LiveScoreBoard();
        liveScoreBoard.startGame(new Match("Germany", "France"));
        liveScoreBoard.updateScore( 2, 2);
        summary.addMatch(liveScoreBoard.finishGame());

        assertEquals(3, summary.getSummary().size());
    }

    @Test
    void sortSummaryTest(){
        Summary summary = new Summary();

        liveScoreBoard.startGame(new Match("Mexico", "Canada"));
        summary.addMatch(liveScoreBoard.finishGame());

        liveScoreBoard = new LiveScoreBoard();
        liveScoreBoard.startGame(new Match("Spain", "Brazil"));
        liveScoreBoard.updateScore( 10, 2);
        summary.addMatch(liveScoreBoard.finishGame());

        liveScoreBoard = new LiveScoreBoard();
        liveScoreBoard.startGame(new Match("Germany", "France"));
        liveScoreBoard.updateScore( 6, 6);
        summary.addMatch(liveScoreBoard.finishGame());

        assertEquals("Mexico", summary.getSummary().get(2).getHomeTeam());
        assertEquals("Spain", summary.getSummary().get(1).getHomeTeam());
        assertEquals("Germany", summary.getSummary().get(0).getHomeTeam());
    }
}
