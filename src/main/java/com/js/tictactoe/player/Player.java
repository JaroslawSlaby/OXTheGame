package com.js.tictactoe.player;

public class Player {

    private Sign sign;
    private String name;

    public Player(Sign sign, String name) {
        this.sign = sign;
        this.name = name;
    }

    public Sign getSign() {
        return sign;
    }

    public String getName() {
        return name;
    }
}
