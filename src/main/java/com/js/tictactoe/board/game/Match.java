package com.js.tictactoe.board.game;

import com.js.tictactoe.player.Player;

import java.util.*;

public class Match {

    private Map<Player, Integer> scores = new HashMap<>();


    public void setPlayers(List<Player> players) {
        for (Player player : players)
            scores.put(player, 0);
    }

    public void addGameWinner(Player player) {
        scores.computeIfPresent(player, (k, v) -> v + 3);
    }

    public void addGameDraw() {
        for (Player player : scores.keySet()) {
            scores.computeIfPresent(player, (k, v) -> v + 1);
        }
    }

    public Player getPlayerWithMorePoints() {
        Map.Entry<Player, Integer> max = Collections.max(scores.entrySet(), Comparator.comparingInt(Map.Entry::getValue));
        return max.getKey();
    }

    public Integer getPlayersScore(Player player) {
        return scores.get(player);
    }
}
