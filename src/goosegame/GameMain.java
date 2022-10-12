package goosegame;

import java.util.*;

/** a class that will execute the program */
public class GameMain {

  /** the main method
   * @param args the argument
   */
  public static void main(String[] args) {

    if(Integer.parseInt(args[0]) != 3) {
      System.out.println("The game is programmed for 3 players only.");
      System.exit(0);
    }

    Player p1 = new Player("bilbo");
    Player p2 = new Player("frodo");
    Player p3 = new Player("sam");


    Board board = new ClassicalBoard();
    Game gooseGame = new Game(board);
    try {
      gooseGame.addPlayer(p1);
      gooseGame.addPlayer(p2);
      gooseGame.addPlayer(p3);

      gooseGame.play();
    }
    catch(UnknownCellException e) {
      System.out.println("ERROR : unknown cell, game is canceled.");
    }

  }

}
