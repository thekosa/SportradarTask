package pl.kosieradzki.scoreboard;

public class LiveScoreBoard {
    private boolean isLive = false;
    private Match match;

    public void startGame(Match match) {
        isLive = true;
        this.match = match;
    }

    public void incrementScore(String team) {
        if(match.getHomeTeam().equals(team)) {
            match.setHomeTeamScore(match.getHomeTeamScore() + 1);
        }else {
            match.setAwayTeamScore(match.getAwayTeamScore() + 1);
        }
    }
    public void updateScore(int homeTeamScore, int awayTeamScore) {
            match.setHomeTeamScore(homeTeamScore);
            match.setAwayTeamScore(awayTeamScore);
    }
    public Match getMatch() {
        return match;
    }
    public void finishGame() {
    }
    public boolean isLive() {
    }
}
