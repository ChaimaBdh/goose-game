package goosegame;

import goosegame.cells.*;

/** a class representing the original board which extends an abstract class named Board */
public class ClassicalBoard extends Board {

  /** the original board has 63 cells */
  private static final int NUMBER_ORIGINAL_CELLS = 63;

  /**
   * the original game board is defined by its number of cells
   */
  public ClassicalBoard() {
    super(NUMBER_ORIGINAL_CELLS);
  }


  /** initializes the board according to the original version of the game.
   * goose cells correspond to cells 9, 18, 27, 36, 45, 54.
   * teleport cells correspond to cells 6, 42, 58.
   * trap cells correspond to cells 31, 52.
   * waiting cells correspond to cell 19.
   */
  public void initBoard() {
    for(int i = 1; i <= this.nbOfCells ; i++) {
      this.theCells[i] = new BasicCell(i);
    }

    int[] gooseCells = {9, 18, 27, 36, 45, 54};
    for(int i : gooseCells) {
      this.theCells[i] = new GooseCell(i);
    }

    this.theCells[6] = new TeleportCell(6, 12);
    this.theCells[42] = new TeleportCell(42, 30);
    this.theCells[58] = new TeleportCell(58, 1);

    this.theCells[31] = new TrapCell(31);
    this.theCells[52] = new TrapCell(52);
    this.theCells[19] = new WaitingCell(19, 2);
  }

}
