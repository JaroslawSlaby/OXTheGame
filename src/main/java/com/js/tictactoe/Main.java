package com.js.tictactoe;

import com.js.tictactoe.game.Game;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static Game game;

    public static void main(String[] args) {

        System.out.println("Let's go!");
        Game game = new Game();
        game.runGame();
    }
}