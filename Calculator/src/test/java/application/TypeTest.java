package application;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
/**
 * @author DMarjanov
 */


public class TypeTest {

  @Test
  // Test 6.1: Ensure that toString returns the correct string representation for
  // NUMBER.
  public void testToStringForNumber() {
    Type type = Type.NUMBER;
    assertEquals("number", type.toString());
  }
}
