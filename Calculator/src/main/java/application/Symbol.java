package application;

/**
 * The Symbol enum holds represents the symbols that could be used in the calculator.
 * 
 * @author DMarjanov
 */
public enum Symbol {
  LEFT_BRACKET("("), RIGHT_BRACKET(")"), TIME("*"), DIVIDE("/"), PLUS("+"), MINUS("-"), INVALID(
      " ");

  String symbol;

  /**
   * Constructs a Symbol enumeration with the given Symbol.
   * 
   * @param symbol The symbol represented by this enumeration value.
   */
  private Symbol(String symbol) {
    this.symbol = symbol;
  }

  /**
   * Returns the Symbol represented by the Enumeration value as a String.
   * 
   * @return The Symbol as a String.
   */
  public String toString() {
    return this.symbol;
  }
  
  
}
