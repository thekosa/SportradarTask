package scoreboard;

import org.junit.jupiter.api.Test;
import pl.kosieradzki.scoreboard.LiveScoreBoard;
import pl.kosieradzki.scoreboard.Match;
import pl.kosieradzki.scoreboard.Summary;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SummaryTest {
    @Test
    void generateSummaryTest() {
        LiveScoreBoard liveScoreBoard = new LiveScoreBoard();

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
        LiveScoreBoard liveScoreBoard = new LiveScoreBoard();

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
