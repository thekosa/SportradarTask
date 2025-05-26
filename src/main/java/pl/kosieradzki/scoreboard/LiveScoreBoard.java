package pl.kosieradzki.scoreboard;

public class LiveScoreBoard {
    private boolean isLive = false;
    private Match match;

    public void startGame(Match match) {
        isLive = true;
        this.match = match;
    }
    public Match getMatch() {
        return match;
    }
}
