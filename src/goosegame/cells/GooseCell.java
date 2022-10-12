package goosegame.cells;

import goosegame.*;

/** a class to represent a goose cell (specific cell) that extends a basic cell */
public class GooseCell extends BasicCell {

  /** a goose cell is defined by its index
   * @param index the index of the goose cell
   */
  public GooseCell(int index) {
    super(index);
  }

  /** returns the bounce of the goose cell
   * @param diceThrow the number obtained by the throw of the 2 dices
   * @return the bounce of the goose cell (the double)
   */
  public int bounce(int diceThrow) {
      return this.index + diceThrow;
  }


  /**
   * @return a string representation of the goose cell
   */
  public String toString() {
    return super.toString() + " (goose) and jumps to cell ";
  }
}
