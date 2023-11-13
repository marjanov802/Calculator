package application;

/**
 * Signals the type asked for is not held by the entry.
 * @author DMarjanov
 */
public class BadType extends Exception {
  public BadType(String message) {
    super(message);
  }
}
