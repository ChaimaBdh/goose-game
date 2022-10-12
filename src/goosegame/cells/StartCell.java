package goosegame.cells;

import goosegame.*;
import java.util.*;

/** a class to represent the first cell of the board where all the player will initially be */
public class StartCell implements Cell {

  /** the first cell's index */
  protected final int index;

  /** the players of the game */
  protected List<Player> players;

  /** the start cell is defined by its index which is 0 (first cell), and
   * the players that are initially on it
   */
  public StartCell() {
    this.index = 0;
    this.players = new ArrayList<>();
  }

  /** returns the start cell's index
   * @return the start cell's index
   */
  public int getIndex() {
    return this.index;
  }

  /** sets the player on the start cell
   * @param p the player to set
   */
  public void setPlayer(Player p) {
    this.players.add(p);
  }

  /** returns the first player on the cell
   * @return the first player on the cell
   */
  public Player getPlayer() {
    return this.players.get(0);
  }

  /** determines if the cell is occupied by a player or not
   * @return <code>true</code> iff the cell is occupied, <code>false</code> if not
   */
  public boolean isBusy() {
    return false;
  }

  /** determines if the cell can be left or not
   * @return <code>true</code> iff the cell can be left, <code>false</code> if not
   */
  public boolean canBeLeft() {
    return true;
  }

  /** returns the index
   * @param diceThrow the value of the dice throw
   */
  public int bounce(int diceThrow) {
    return this.index;
  }

}
