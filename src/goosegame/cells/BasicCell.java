package goosegame.cells;

import goosegame.*;

/** a class to represent a basic cell which composes the entire board */
public class BasicCell implements Cell {

  // Attributes

  /** the player on the cell */
  protected Player player;

  /** the cell's index */
  protected final int index;

  // Constructor

  /** a basic cell is defined by its index
   * @param index the cell's index
   */
  public BasicCell(int index) {
    this.player = null;
    this.index = index;
  }

  // Methods

  /**
   * @see goosegame.Cell#getIndex
   */
  public int getIndex() {
    return this.index;
  }

  /**
   * @see goosegame.Cell#getPlayer
   */
  public Player getPlayer() {
    return this.player;
  }

  /**
   * @see goosegame.Cell#bounce
   */
  public int bounce(int diceThrow) {
    this.setPlayer(this.player);
    return this.getIndex();
  }

  /**
   * @see goosegame.Cell#isBusy
   */
  public boolean isBusy() {
    return this.getPlayer() != null;
  }

  /**
   * @see goosegame.Cell#canBeLeft
   */
  public boolean canBeLeft() {
    return true;
  }

  /**
   * @see goosegame.Cell#setPlayer
   */
  public void setPlayer(Player p) {
    this.player = p;
  }


  /**
   * @return a string representation for a basic cell
   */
  public String toString() {
    return " and reaches " + this.index;
  }
}
