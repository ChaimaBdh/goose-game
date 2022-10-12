package goosegame.cells;

import goosegame.*;

/** a class to represent a teleport cell (specific cell) that extends a basic cell */
public class TeleportCell extends BasicCell {

  /** the index of the cell where the player will be teleported */
  protected int teleportIndex;

  /** a teleport cell is defined by its index and the index where it teleports the player
   * @param index the index of the teleport cell
   * @param teleportIndex the index where the player is teleported
   */
  public TeleportCell(int index, int teleportIndex) {
    super(index);
    this.teleportIndex = teleportIndex;
  }

  /** returns the teleport index
   * @return the teleport index
   */
  public int getTeleportIndex() {
    return this.teleportIndex;
  }

  /** returns the destination's index
   * @param diceThrow the number obtained by the throw of the 2 dices
   * @return the destination's index
   */
  public int bounce(int diceThrow) {
    return this.teleportIndex;
  }

  /**
   * @return a string representation for the teleport cell
   */
  public String toString() {
    return super.toString() + " (teleport to " + this.teleportIndex + ") and jumps to cell " + this.teleportIndex;
  }
}
