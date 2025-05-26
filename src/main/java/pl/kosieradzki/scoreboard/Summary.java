package pl.kosieradzki.scoreboard;

import java.util.ArrayList;
import java.util.List;

public class Summary {
    private final List<Match> matches = new ArrayList<>();

    public void addMatch(Match match) {
        matches.add(match);
    }

    public List<Match> getSummary() {
        sortSummary();
        return matches;
    }

    private void sortSummary() {
    }
}
