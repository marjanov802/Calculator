package application;

/**
 * The Entry class shows the entries which can be put into the calculator ranging from numbers ,
 * symbols or strings.
 * 
 * @author DMarjanov
 */
public class Entry {

  // attributes
  private float number;
  private Symbol other;
  private String str;
  private Type type;

  /**
   * Constructs an Entry object with a number value.
   * 
   * @param f initialises the the Entry.
   */
  public Entry(float f) {
    this.number = f;
    this.type = Type.NUMBER;
  }

  /**
   * Returns the type of Entry.
   * 
   * @return The type of Entry.
   */
  public Type getType() {
    return type;
  }

  /**
   * Returns the number value of Entry.
   * 
   * @return The number value of Entry.
   */
  public float getValue() {
    return number;
  }

  /**
   * Constructs an Entry object for Symbol.
   * 
   * @param which the Symbol value to initialise
   */
  public Entry(Symbol which) {
    this.other = which;
    this.type = Type.SYMBOL;
  }

  /**
   * Returns the Symbol value of Entry.
   * 
   * @return The Symbol value of Entry.
   * @throws BadType exception if the Entry does not have a type Symbol.
   */
  public Symbol getSymbol() throws BadType {
    if (type != Type.SYMBOL) {
      throw new BadType("Invalid type for getSymbol");
    }
    return other;
  }

  /**
   * Constructs an Entry object with a String value.
   * 
   * @param str The string value used to initialised Entry with
   */
  public Entry(String str) {
    this.str = str;
    this.type = Type.STRING;
  }

  /**
   * This calss do.
   * @return The string value of Entry.
   * @throws BadType If the Entry is not type String.
   */
  public String getString() throws BadType {
    if (type != Type.STRING) {
      throw new BadType("Invalid type for getString");
    }
    return str;
  }
}
