package goosegame.cells;

import goosegame.*;

/** a class to represent a trap cell (specific cell) that extends a basic cell */
public class TrapCell extends BasicCell {

  /** a trap cell is defined by its index, it blocks the player who reaches it
   * until another player reaches it and replace him
   * @param index the trap cell index
   */
  public TrapCell(int index) {
    super(index);
  }

  /** determines if the trap cell can be left or not
   * @return <code>true</code> iff the cell can be left, <code>false</code> if not
   */
  public boolean canBeLeft() {
    return false;
  }

  /**
   * @return a string representation for a trap cell
   */
  public String toString() {
    return super.toString() + " (trap)";
  }


}
