# NumberQuest: The Guessing Gauntlet 🎯 (Java Edition)

A simple, fun command-line number guessing game built in **Java**. The computer picks a secret number in a range you choose, and you try to guess it within a limited number of attempts. Play multiple rounds and track your score!

## Features

- 🎲 Random number generation within a customizable range (default: 1–100)
- 💬 Instant feedback — "too high" or "too low" — after every guess
- ⏱️ Limited attempts per round (default: 7, customizable)
- 🔁 Multiple rounds with a "play again" option
- 🏆 Score tracking — more points for guessing in fewer attempts
- ✅ Input validation (handles invalid or out-of-range input gracefully)

## Project Structure

```
NumberQuest/
├── NumberGuessingGame.java
└── README.md
```

## Getting Started

### Prerequisites

- JDK 8 or later installed
- Check your version:
  ```bash
  java -version
  javac -version
  ```

### Compiling

```bash
javac NumberGuessingGame.java
```

### Running

```bash
java NumberGuessingGame
```

## How to Play

1. Choose whether to customize the number range and attempt limit, or use the defaults (1–100, 7 attempts).
2. Enter your guess when prompted.
3. Get feedback: **too high**, **too low**, or **correct!**
4. Keep guessing until you find the number or run out of attempts.
5. See your score for the round, then choose whether to play again.
6. Your total score and round stats are tracked across the whole session.

## Scoring

Points are awarded based on how many attempts you used:

```
points = max(100 - (attemptsUsed - 1) * 10, 10)
```

Fewer attempts = higher score, with a minimum of 10 points per win.

## Class Overview

`NumberGuessingGame.java` contains:

| Method | Purpose |
|---|---|
| `main(String[] args)` | Runs the game loop — handles rounds, replay, and overall scoreboard |
| `playRound(int low, int high, int maxAttempts)` | Runs a single round: picks the target number, loops guesses, returns points earned |
| `getValidGuess(int low, int high)` | Reads and validates user input, re-prompting on invalid entries |

## Possible Future Enhancements

- [ ] Difficulty levels (Easy / Medium / Hard) with preset ranges and attempt limits
- [ ] Persistent high-score leaderboard saved to a file
- [ ] GUI version using JavaFX or Swing
- [ ] Hint system (e.g., "getting warmer")

## License

This project is open source and available under the [MIT License](LICENSE).

## Author

Built as a fun coding exercise — contributions and forks welcome!
