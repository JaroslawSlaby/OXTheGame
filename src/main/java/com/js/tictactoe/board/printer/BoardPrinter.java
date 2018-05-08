package com.js.tictactoe.board.printer;

import com.js.tictactoe.board.cell.Cell;
import com.js.tictactoe.player.Colors;

public class BoardPrinter {
    public static void printBoard(Cell[][] table) {
        System.out.print(Colors.ANSI_DEFAULT + "y\\x");
        for (int i = 0; i < table[0].length; i++) {
            System.out.print(Colors.ANSI_DEFAULT + "\t" + i + Colors.ANSI_DEFAULT + "\t");
        }

        System.out.println();
        for (int i = 0; i < table.length; i++) {
            System.out.print(Colors.ANSI_DEFAULT + "" + i + " ");

            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j].getValue().toString().equalsIgnoreCase("O"))
                    System.out.print(Colors.ANSI_DEFAULT + "|\t" + Colors.ANSI_GREEN + table[i][j].getValue() + Colors.ANSI_DEFAULT + "\t|");
                else
                    System.out.print(Colors.ANSI_DEFAULT + "|\t" + Colors.ANSI_RED + table[i][j].getValue() + Colors.ANSI_DEFAULT + "\t|");
            }
            System.out.print(Colors.ANSI_DEFAULT + "\n");
        }
    }
}
