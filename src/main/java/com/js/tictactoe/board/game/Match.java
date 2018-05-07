package com.js.tictactoe.board.game;

import com.js.tictactoe.player.Player;

import java.util.*;

public class Match {

    private static final int MAX_GAMES = 3;
    private Map<Player, Integer> scores = new HashMap<>();
    private int numberOfGames = 0;


    public void setPlayers(List<Player> players) {
        for (Player player : players)
            scores.put(player, 0);
    }

    public void addGameWinner(Player player) {
        scores.computeIfPresent(player, (k, v) -> v + 3);
        numberOfGames++;

    }

    public void addGameDraw() {
        for (Player player : scores.keySet()) {
            scores.computeIfPresent(player, (k, v) -> v + 1);
        }
        numberOfGames++;
    }

    public Player getPlayerWithMorePoints() {
        Map.Entry<Player, Integer> max = Collections.max(scores.entrySet(), Comparator.comparingInt(Map.Entry::getValue));
        return max.getKey();
    }

    public Integer getPlayersScore(Player player) {
        return scores.get(player);
    }

    public boolean isNextRound() {
        return numberOfGames < MAX_GAMES;
    }
}
