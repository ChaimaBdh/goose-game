package goosegame;

import goosegame.cells.*;
import java.util.*;

/** a class to represent the goose game */
public class Game {

  // Attributes

  /** a list of current players that are playing */
  protected List<Player> thePlayers;

  /** the game board */
  protected Board board;

  /** index of first player */
  private static int indexOfFirstPlayer = 0;


  // Constructor

  /** the game is defined by its board on which the player are moving
   * @param board the board
   */
   public Game(Board board) {
     this.board = board;
     this.thePlayers = new ArrayList<>();
   }

   // Methods

   /** adds a new player to the first cell of the board
    * @param p the player to add
    * @throws UnknownCellException if the cell is unknown
    */
   public void addPlayer(Player p) throws UnknownCellException {
     this.thePlayers.add(p);
     this.board.getCell(0).setPlayer(p);
     p.setCell(this.board.getCell(0));
   }

   /** determines if a player can play or not
    * @param p the player
    * @return <code>true</code> iff a player can play, <code>false</code> if not
    * @throws UnknownCellException if the cell is unknown
    */
   public boolean canPlay(Player p) throws UnknownCellException {
     return p.getCell().canBeLeft();
   }

   /**
    * plays one round of the goose game : checks if the actual player can play, get the reached cell
    * @param player the player that plays the round
    * @throws UnknownCellException if the cell is unknown
    */
   public void playOneRound(Player player) throws UnknownCellException {
     if(this.canPlay(player)) {
       Cell dest = this.getReachedCell(player);
       this.handleOnComing(player, dest);
     }
     else {
       System.out.println(player.toString() + " is in cell " + player.getCell().getIndex() + ", " + player.toString() + " cannot play.");
     }
   }

   /**
    * starts the game
    * @throws UnknownCellException if the cell is unknown
    */
   public void play() throws UnknownCellException {
     Player actualPlayer = this.nextPlayer();
     while(!this.isFinished()) {
       this.playOneRound(actualPlayer);
       actualPlayer = this.nextPlayer();
     }
   }

   /** returns the next player for each turn
    * @return the next player for each turn
    */
   public Player nextPlayer() {
     return this.thePlayers.get((Game.indexOfFirstPlayer++) % this.thePlayers.size());
   }

   /** determines if the game is finished or not (when there is a winner : the player is on the last cell)
    * @return <code>true</code> iff the game is finished, <code>false</code> if not
    * @throws UnknownCellException if the cell is unknown
    */
   public boolean isFinished() throws UnknownCellException  {
     for(Player p : this.thePlayers) {
       if(p.getCell().getIndex() + 1 == this.board.getNbOfCells()) {
         System.out.println(p + " has won.");
         return true;
       }
     }
     return false;
   }


   /** displays the dice value after the throw and the reached cell
    * @param beforeBounce the cell before the bounce
    * @param afterBounce the cell after the bounce
    * @param player the player
    * @param actualIndex the current index where the player is
    * @param diceValue the value of the dice after throw
    * @param indexBeforeBounce the index before the bounce
    * @throws UnknownCellException if the cell is unknown
    */
   public void displaysReachedCellAndDiceValue(Cell beforeBounce, Cell afterBounce, Player player, int actualIndex, int diceValue, int indexBeforeBounce) throws UnknownCellException {
     if(beforeBounce.getClass() == GooseCell.class) {
       if(afterBounce.isBusy()) {
         System.out.println(player.toString() + " is in cell " + actualIndex + ", " + player.toString() + " throws " + diceValue + beforeBounce + afterBounce.getIndex() + " cell is busy, " + afterBounce.getPlayer() +
         " is sent to cell " + player.getCell().getIndex());
       }
       else {
         System.out.println(player.toString() + " is in cell " + actualIndex + ", " + player.toString() + " throws " + diceValue + beforeBounce + afterBounce.getIndex());
       }
     }
    else {
      if(afterBounce.isBusy()) {
        System.out.println(player.toString() + " is in cell " + actualIndex + ", " + player.toString() + " throws " + diceValue + beforeBounce + " cell is busy, " + afterBounce.getPlayer() + " is sent to cell " + player.getCell().getIndex());
      }
      else {
        System.out.println(player.toString() + " is in cell " + actualIndex + ", " + player.toString() + " throws " + diceValue + beforeBounce);
      }
    }
  }

  /** handles the players on the cells : if a player reaches an occupied cell, the other player reaches his previous cell
   * @param p the player who reaches the destination
   * @param destination the cell that the player will reach
   * @throws UnknownCellException if the cell is unknown
   */
  public void handleOnComing(Player p, Cell destination) throws UnknownCellException {
    if(destination.isBusy()) {
      p.getCell().setPlayer(destination.getPlayer());
      destination.getPlayer().setCell(p.getCell());
      p.setCell(destination);
      destination.setPlayer(p);
    }
    else {
      p.getCell().setPlayer(null);
      destination.setPlayer(p);
      p.setCell(destination);
    }
  }



   /** returns the reached cell by the player after dice throw
    * @param p the player
    * @return the reached cell by the player after dice throw
    * @throws UnknownCellException if the cell is unknown
    */
   public Cell getReachedCell(Player p) throws UnknownCellException  {
     int diceValue = p.twoDiceThrow();
     int actualIndex = p.getCell().getIndex();
     int indexBeforeBounce = actualIndex + diceValue;
     Cell afterBounce = null;

     if(indexBeforeBounce < this.board.getNbOfCells()) {
       afterBounce = this.board.getCell(this.board.getCell(indexBeforeBounce).bounce(diceValue));
     }
     else {
       indexBeforeBounce = this.board.getNbOfCells() - ((actualIndex + 2 + diceValue) - this.board.getNbOfCells());
       afterBounce = this.board.getCell(this.board.getCell(indexBeforeBounce).bounce(diceValue));
     }
     displaysReachedCellAndDiceValue(this.board.getCell(indexBeforeBounce), afterBounce, p, actualIndex, diceValue, indexBeforeBounce);
     return afterBounce;
   }

}
