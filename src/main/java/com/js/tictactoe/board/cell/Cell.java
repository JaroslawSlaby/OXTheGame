package com.js.tictactoe.board.cell;

import com.js.tictactoe.player.Sign;

public interface Cell {

  Sign getValue();

  boolean isCellEmpty();
}
