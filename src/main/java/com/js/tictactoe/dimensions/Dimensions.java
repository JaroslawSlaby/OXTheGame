package com.js.tictactoe.dimensions;

public class Dimensions {

  private final int width;
  private final int height;

  public Dimensions(int sizeOfBoard) {
    this.height = sizeOfBoard;
    this.width = sizeOfBoard;
  }

  public Dimensions(int defaultWidth, int defaultHeight) {
    this.height = defaultHeight;
    this.width = defaultWidth;
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }
}
