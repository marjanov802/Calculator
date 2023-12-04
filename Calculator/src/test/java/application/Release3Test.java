package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Release3Test {
  @Test
  void testInfixExpressionEvaluation() throws InvalidExpression {
      Calculator calculator = new StandardCalc();
      float result = calculator.evaluate("2 + 3 * 4", true);
      assertEquals(14.0, result);
  }
  
}
