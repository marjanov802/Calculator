package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

  @Test
  public void testEvaluateSimpleAddition() throws InvalidExpression {
    Calculator calculator = (expr, infix) -> {
      String[] operands = expr.split("\\+");
      float num1 = Float.parseFloat(operands[0].trim());
      float num2 = Float.parseFloat(operands[1].trim());
      return num1 + num2;
    };
    float result = calculator.evaluate("3 + 4", true);
    assertEquals(7.0f, result, 0.001f);
  }

  @Test
  public void testEvaluateInvalidExpression() {
    Calculator calculator = (expr, infix) -> {
      throw new InvalidExpression();
    };
    assertThrows(InvalidExpression.class, () -> {
      calculator.evaluate("invalid expression", true);
    });
  }

}
