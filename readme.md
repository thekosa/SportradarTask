# SportradarTask

A simple library that simulates a live Football World Cup scoreboard.
This project was developed as a recruitment task for Sportradar.

---

## 📋 Features

* Start a new football match with two team names.
* Update the score of a running match.
* Finish a match (remove from the scoreboard).
* View a summary of all ongoing matches:
* Validate team names and score limits.
---

## ✅ Assumptions

* **Team name**:

    * Must contain at least one word consisting of **letters or digits**.
    * **No special characters** allowed (e.g., `@`, `#`, `.`, `!`).
    * Cannot be **null**, **empty**, or made only of whitespace.
    * Invalid name throws an `InvalidTeamNameException`
* **Score values**:

    * Must be integers in the inclusive range **0 to 1000**.
    * Negative or too high values throw an `InvalidScoreException`.
* **Summary sorting**:

    * Matches are **sorted immediately** after adding each to the summary list.
    * Sorting rules:

        1. By total score (descending),
        2. By match creation time (most recent first, if tied).

---

## 🛠️ Technologies

* Java 17
* Maven
* JUnit 5

---

## 💾 Example Usage

```java
Summary summary = new Summary();
LiveScoreBoard liveScoreBoard = new LiveScoreBoard();
liveScoreBoard.startGame(new Match("Canada", "Spain"));
liveScoreBoard.updateScore(2, 1);
liveScoreBoard.incrementScore("Canada");
summary.addMatch(liveScoreBoard.finishGame());
summary.getSummary();
```

---

## ⚠️ Exception Handling

* `InvalidTeamNameException` – thrown when a team name is invalid.
* `MatchNotFoundException` – thrown when a match is not found in active scoreboard.
* `InvalidScoreException` – thrown when a score is below 0 or above 1000.
* `GameAlreadyStartedException` - thrown when game has been already started.

---

## 📄 License

Project created for recruitment and educational purposes.
