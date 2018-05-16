package com.js.tictactoe.language;

public enum DefaultLang {

  endMatch("\nMatch ends! Congratulations!"),
  winner("Winner:\u0020"),
  player("Player\u0020"),
  move(", make your move. Pattern: x y (or x, if you want both coordinates the same). X lower than\u0020"),
  movePt2(", and Y lower than\u0020"),
  coords("Wrong coordinates, try again!\u0020"),
  size("Wrong size, try again!\u0020"),
  boardSize("Enter board size(size from range 3 - 20) Pattern: x y (or x if you want square board):\u0020"),
  wrongTableSize("Wrong table size! Try again:\u0020"),
  signsNo("Enter number of signs to win:\u0020"),
  incorrectNumber("Bad number, try again!\n"),
  startSign("Who does start? O/X :\u0020"),
  incorrectPlayer("Wrong player, try again!:\u0020"),
  stplayerName("Enter 1st player name:\u0020"),
  ndplayerName("Enter 2nd player name:\u0020"),
  playerSign("Choose sign (O/X) for player\u0020"),
  coordsPositive("Both coordinates must be positive!\u0020"),
  coordsIntegers("Coordinates must be integers!\u0020"),
  cell("Cell is not empty!\u0020"),
  draw("raw!\u0020");


  final String code;

  DefaultLang(String code) {
    this.code = code;
  }

}
