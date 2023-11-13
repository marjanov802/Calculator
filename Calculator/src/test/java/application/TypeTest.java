package application;

/**
 * @author DMarjanov
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TypeTest {

  @Test
  // Test 6.1: Ensure that toString returns the correct string representation for
  // NUMBER.
  public void testToStringForNumber() {
    Type type = Type.NUMBER;
    assertEquals("number", type.toString());
  }
}
