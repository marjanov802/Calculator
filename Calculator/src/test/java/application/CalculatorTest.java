package application;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

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

  @Test(expected = InvalidExpression.class)
  public void testEvaluateInvalidExpression() throws InvalidExpression {
    Calculator calculator = (expr, infix) -> {
      throw new InvalidExpression();
    };

    calculator.evaluate("invalid expression", true);
  }
}
