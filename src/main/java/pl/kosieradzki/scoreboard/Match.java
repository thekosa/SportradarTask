package pl.kosieradzki.scoreboard;

import pl.kosieradzki.exceptions.InvalidTeamNameException;

public class Match {
    private String homeTeam;
    private String awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;
    private int sum;

    public Match(String homeTeam, String awayTeam) {
        this.homeTeam = validateTeamName(homeTeam);
        this.awayTeam = validateTeamName(awayTeam);
        this.homeTeamScore = 0;
        this.awayTeamScore = 0;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void sum() {
        sum = homeTeamScore + awayTeamScore;
    }

    private String validateTeamName(String teamName) {
        if (teamName == null || !teamName.matches("^([A-Za-z0-9]+(?: [A-Za-z0-9]+)*)$")) {
            throw new InvalidTeamNameException(teamName);
        }
        return teamName;
    }
}
