package pl.kosieradzki.scoreboard;

import pl.kosieradzki.exceptions.GameAlreadyStartedException;
import pl.kosieradzki.exceptions.GameNotFoundException;
import pl.kosieradzki.exceptions.InvalidScoreException;

public class LiveScoreBoard {
    private boolean isLive = false;
    private Match match;

    public void startGame(Match match) {
        if (isLive) {
            throw new GameAlreadyStartedException();
        }
        isLive = true;
        this.match = match;
    }

    public void incrementScore(String team) {
        if (!isLive) {
            throw new GameNotFoundException();
        }
        if (match.getHomeTeam().equals(team)) {
            match.setHomeTeamScore(validateScore(match.getHomeTeamScore() + 1));
        } else {
            match.setAwayTeamScore(validateScore(match.getAwayTeamScore() + 1));
        }
    }

    public void updateScore(int homeTeamScore, int awayTeamScore) {
        if (!isLive) {
            throw new GameNotFoundException();
        }
        match.setHomeTeamScore(validateScore(homeTeamScore));
        match.setAwayTeamScore(validateScore(awayTeamScore));
    }

    public Match getMatch() {
        return match;
    }

    public Match finishGame() {
        if (!isLive) {
            throw new GameNotFoundException();
        }
        isLive = false;
        match.sum();
        return match;
    }

    public boolean isLive() {
        return isLive;
    }

    private int validateScore(int score) {
        int maxScore = 1000;
        if (score < 0 || score > maxScore) {
            throw new InvalidScoreException(score);
        }
        return score;
    }
}
