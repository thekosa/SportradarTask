package pl.kosieradzki.scoreboard;

import java.util.ArrayList;
import java.util.List;

public class Summary {
    private final List<Match> matches = new ArrayList<>();

    public void addMatch(Match match) {
        if (matches.isEmpty()) {
            matches.add(match);
            return;
        }
        for (int i = 0; i < matches.size(); i++) {
            if (match.getSum() > matches.get(i).getSum()) {
                matches.add(i, match);
                return;
            } else if (match.getSum() == matches.get(i).getSum()) {
                matches.add(i, match);
                return;
            }
        }
        if (match.getSum() < matches.get(matches.size() - 1).getSum()) {
            matches.add(match);
        }
    }

    public List<Match> getSummary() {
        sortSummary();
        return matches;
    }

    private void sortSummary() {
    }
}
