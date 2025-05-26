package pl.kosieradzki.scoreboard;

import pl.kosieradzki.exceptions.GameNotFoundException;

public class LiveScoreBoard {
    private boolean isLive = false;
    private Match match;

    public void startGame(Match match) {
        isLive = true;
        this.match = match;
    }

    public void incrementScore(String team) {
        if (!isLive) {
            throw new GameNotFoundException();
        }
        if (match.getHomeTeam().equals(team)) {
            match.setHomeTeamScore(match.getHomeTeamScore() + 1);
        } else {
            match.setAwayTeamScore(match.getAwayTeamScore() + 1);
        }
    }

    public void updateScore(int homeTeamScore, int awayTeamScore) {
        if (!isLive) {
            throw new GameNotFoundException();
        }
        match.setHomeTeamScore(homeTeamScore);
        match.setAwayTeamScore(awayTeamScore);
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
}
