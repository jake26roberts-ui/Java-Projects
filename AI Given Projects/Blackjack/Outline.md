# Blackjack — Project Outline

## Overview
A console-based Blackjack (21) game where a single player plays against the dealer. The player has a bankroll, places bets, and plays rounds until they quit or run out of money. The dealer follows standard house rules.

## Goals
- Practice object-oriented design in Java.
- Implement game logic: deck, dealing, hand totals (incl. Aces), hitting, standing, dealer rules.
- Add betting, bankroll management, and round replay.
- Build a clear, testable code structure with separate classes.

## Core Features (Minimum Viable Product)
- Deck and card representation (52 cards).
- Shuffling and dealing random cards.
- Player and dealer hands with score calculation (Aces = 1 or 11).
- Player actions: Hit, Stand.
- Dealer automated play: hit until 17 or higher (configurable soft-17 rule).
- Win/loss/draw resolution, with bankroll updates.
- Text-based UI and input validation.
- Repeat rounds until bankroll <= 0 or player quits.

## Optional / Advanced Features
- Double down, split pairs, insurance.
- Multiple players (hotseat).
- Persistent high scores or bankroll saved to a file.
- Graphical UI (Swing/JavaFX) or web front-end.
- Unit tests for core logic (Deck, Hand evaluation).
- Betting limits, configurable rules, card counting demo.

## User Stories
- As a player, I can place a bet at the start of each round.
- As a player, I can choose to hit or stand.
- As a player, I see my and the dealer's cards and outcomes each round.
- As a player, my bankroll updates correctly after each round.
- As a player, I can quit at any time.

## Suggested Class Structure
- Card
  - fields: rank, suit, value
  - methods: toString()
- Deck
  - fields: List<Card>
  - methods: shuffle(), draw()
- Hand
  - fields: List<Card>
  - methods: addCard(), getTotal(), isBust(), isBlackjack(), clear()
- Player
  - fields: Hand hand, int bankroll
  - methods: placeBet(), adjustBankroll()
- Dealer (can extend Player or be separate)
  - methods: playTurn(Deck deck)
- BlackjackGame (main controller)
  - fields: Deck deck, Player player, Dealer dealer, Scanner input
  - methods: playRound(), resolveOutcome(), promptBet(), promptAction()

## Key Algorithms / Rules
- Hand total: treat Aces as 11 where possible without busting; otherwise treat as 1.
- Blackjack pays (optionally) 3:2 if player has initial 21 vs dealer.
- Dealer rule: hit until total >= 17 (soft-17 handling configurable).

## Input / Output / UI
- Console prompts for bets and actions.
- Validate integer bets and choices (H/S/D/Q).
- Show: player cards, dealer visible card(s), actions, and bankroll after each round.

## Example Round Flow
1. Shuffle deck (or reshuffle when low).
2. Prompt player bet.
3. Deal two cards to player and dealer (one dealer card face-down).
4. If player has Blackjack — resolve vs dealer.
5. Player chooses Hit/Stand (and optional Double Down/Split).
6. Dealer reveals and plays by rules.
7. Resolve win/loss/push and update bankroll.
8. Ask to play again or quit.

## File / Package Layout (suggested)
- src/
  - aiProjects/
    - card/
      - Card.java
      - Deck.java
      - Hand.java
    - players/
      - Player.java
      - Dealer.java
    - game/
      - BlackjackGame.java
- README.md
- tests/ (optional)

## Milestones & Tasks
1. Create Card, Deck, Hand classes; write unit tests for getTotal().
2. Implement Player/Dealer and basic deal/hit/stand loop.
3. Add betting and bankroll management.
4. Add input validation and a clean console UI.
5. Add optional rules (double down, Blackjack payout).
6. Polish, document, and add tests.

## Testing / Validation
- Unit-test hand scoring (Aces combinations).
- Simulate edge cases: immediate Blackjack, multiple Aces, busting.
- Manual playthroughs for UI flow and input validation.

## Estimated Difficulty & Time
- Core console version: beginner → intermediate, ~6–12 hours.
- With splits/double down and tests: intermediate, additional 6–12 hours.

## Notes & Tips
- Keep game rules configurable via constants so you can toggle payouts and dealer soft-17 behavior.
- Use ArrayList<Card> for hands and deck; Collections.shuffle for shuffling.
- Consider separating IO (Scanner/printing) from game logic to make testing easier.
