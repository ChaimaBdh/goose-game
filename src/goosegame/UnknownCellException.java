package goosegame;

/** a class that represents an exception when a cell is unknown */
public class UnknownCellException extends Exception {

  /** */
  public UnknownCellException() {
    super();
  }

  /** returns a message when a cell is unknown
   * @param msg the message
   */
  public UnknownCellException(String msg) {
    super(msg);
  }
}
