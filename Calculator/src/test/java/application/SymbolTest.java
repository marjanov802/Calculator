package application;

/**
 * @author DMarjanov
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SymbolTest {

  @Test
  // Test 7.1: Ensure that toString returns the correct string representation for
  // PLUS.
  public void testToStringForPlus() {
    Symbol symbol = Symbol.PLUS;
    assertEquals("+", symbol.toString());
  }
}
