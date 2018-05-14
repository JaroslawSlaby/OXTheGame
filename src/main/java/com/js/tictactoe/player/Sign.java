package com.js.tictactoe.player;

public enum Sign {

  X("X") {
    @Override
    public Sign getOppositePlayer() {
      return O;
    }
  }, O("O") {
    @Override
    public Sign getOppositePlayer() {
      return X;
    }
  }, EMPTY("") {
    @Override
    public Sign getOppositePlayer() {
      return EMPTY;
    }
  };

  private final String sign;

  Sign(String sign) {
    this.sign = sign;
  }

  @Override
  public String toString() {
    return sign;
  }

  public abstract Sign getOppositePlayer();
}

