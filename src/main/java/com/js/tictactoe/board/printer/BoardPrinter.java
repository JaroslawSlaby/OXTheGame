package com.js.tictactoe.board.printer;

import com.js.tictactoe.board.cell.Cell;
import com.js.tictactoe.player.Colors;

import java.util.function.Consumer;

public class BoardPrinter {

  private static final int FIRST_NUMBER_WITH_TWO_DIGITS = 10;

  public static void printBoard(Cell[][] table, Consumer<String> output) {
    output.accept(Colors.ANSI_DEFAULT + "y\\x");
    for (int i = 0; i < table[0].length; i++) {
      output.accept(Colors.ANSI_DEFAULT + "\t" + i + Colors.ANSI_DEFAULT + "\t");
    }

    System.out.println();
    for (int i = 0; i < table.length; i++) {
      printRightMargin(output, i);
      for (int j = 0; j < table[i].length; j++) {
        colorCell(table[i][j], output);
      }
      output.accept(Colors.ANSI_DEFAULT + "\n");
    }
  }

  private static void printRightMargin(Consumer<String> output, int i) {
    if(i < FIRST_NUMBER_WITH_TWO_DIGITS) {
      output.accept(Colors.ANSI_DEFAULT + "" + i + " ");
    } else {
      output.accept(Colors.ANSI_DEFAULT + "" + i + "");
    }
  }

  private static void colorCell(Cell cell, Consumer<String> output) {
    if (cell.getValue().toString().equalsIgnoreCase("O"))
      output.accept(Colors.ANSI_DEFAULT + "|\t" + Colors.ANSI_GREEN + cell.getValue() + Colors.ANSI_DEFAULT + "\t|");
    else
      output.accept(Colors.ANSI_DEFAULT + "|\t" + Colors.ANSI_RED + cell.getValue() + Colors.ANSI_DEFAULT + "\t|");
  }
}
