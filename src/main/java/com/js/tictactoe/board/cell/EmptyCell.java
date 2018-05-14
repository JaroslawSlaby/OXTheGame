package com.js.tictactoe.board.cell;

import com.js.tictactoe.player.Sign;

public class EmptyCell implements Cell {

  @Override
  public boolean isCellEmpty() {
    return true;
  }

  @Override
  public Sign getValue() {
    return Sign.EMPTY;
  }
}
