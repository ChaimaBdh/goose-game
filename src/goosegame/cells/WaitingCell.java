package goosegame.cells;

import goosegame.*;

/** a class to represent a waiting cell (specific cell) that extends a basic cell */
public class WaitingCell extends BasicCell {

  /** the waiting time during which the player cannot play */
  protected int waitingDuration;

  /** a waiting cell is defined by its index its waiting time
   * @param index the waiting cell's index
   * @param waitingDuration the time of wait
   */
  public WaitingCell(int index, int waitingDuration) {
    super(index);
    this.waitingDuration = waitingDuration;
  }

  /** determines if the waiting cell can be left or not
   * @return <code>true</code> iff the cell can be left, <code>false</code> if not
   */
  public boolean canBeLeft() {
    if(this.waitingDuration != 0) {
      this.waitingDuration --;
      return false;
    }
    return true;
  }

  /** sets the player on the cell
   * @param player the player on the cell
   */
  public void setPlayer(Player player) {
    super.setPlayer(player);
    this.waitingDuration = this.waitingDuration;
  }

  /**
   * @return a string representation for a waiting cell
   */
  public String toString() {
    return super.toString() + " (waiting for " + this.waitingDuration + " turns)";
  }

}
