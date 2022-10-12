package goosegame;

import goosegame.cells.StartCell;

/** an abstract class to define a board */
public abstract class Board {

  // Attributes

  /** the number of cells in the board */
  protected final int nbOfCells;

  /** an array representing the cells placed on the board */
  protected Cell[] theCells;

  // Constructor

  /** the board is defined by its number of cells
   * @param nbOfCells the number of cells
   */
  public Board(int nbOfCells) {
    this.nbOfCells = nbOfCells;
    this.theCells = new Cell[nbOfCells+1];
    this.theCells[0] = new StartCell();
    this.initBoard();
  }

  // Methods

  /**
   * initializes the game board
   */
  protected void initBoard(){};

  /** returns the cell corresponding the index
   * @param index the index of the cell
   * @return the cell corresponding the index
   * @throws UnknownCellException if the cell is unknown
   */
   public Cell getCell(int index) throws UnknownCellException {
     try {
       return this.theCells[index];
     }
     catch(ArrayIndexOutOfBoundsException e) {
       throw new UnknownCellException();
     }
   }

   /** returns the number of cells on the board
    * @return the number of cells on the board
    */
    public int getNbOfCells() {
      return this.theCells.length;
    }


}
