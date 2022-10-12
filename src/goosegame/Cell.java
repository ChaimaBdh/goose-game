package goosegame;

/** an interface representing a cell, where each specific cell will be implemented */
public interface Cell {

  /** returns the cell's index
   * @return the cell's index
   */
  public int getIndex();

  /** returns the player(s) on the cell
   * @return the player(s) on the cell
   */
  public Player getPlayer();

  /** returns the bounce of the specific cell
   * @param diceThrow the number of the dice throw
   * @return the bounce of the specific cell
   */
  public int bounce(int diceThrow);

  /** determines if the cell is occupied by another player or not
   * @return <code>true</code> iff the cell is occupied, <code>false</code> if not
   */
  public boolean isBusy();

  /**
   * determines if the cell can be left or
   * @return <code>true</code> iff the cell can be left, <code>false</code> if not
   */
  public boolean canBeLeft();

  /** sets the player on the cell
   * @param p the player to be set
   */
   public void setPlayer(Player p);

}
