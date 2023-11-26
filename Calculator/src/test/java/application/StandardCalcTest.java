package application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class StandardCalcTest {

  @Test
  public void testEvaluateSimpleAddition() throws InvalidExpression {
    StandardCalc calculator = new StandardCalc();
    float result = calculator.evaluate("3 + 4", true);
    assertEquals(7.0f, result, 0.001f);
  }

  @Test
  public void testEvaluateMultiplicationAndSubtraction() throws InvalidExpression {
    StandardCalc calculator = new StandardCalc();
    float result = calculator.evaluate("5 * 2 - 3", true);
    assertEquals(7.0f, result, 0.001f);
  }

  @Test
  public void testEvaluateDivision() throws InvalidExpression {
    StandardCalc calculator = new StandardCalc();
    float result = calculator.evaluate("10 / 2", true);
    assertEquals(5.0f, result, 0.001f);
  }

  @Test
  public void testEvaluateComplexExpression() throws InvalidExpression {
    StandardCalc calculator = new StandardCalc();
    float result = calculator.evaluate("3 + 5 * 2 - 4 / 2", true);
    assertEquals(11.0f, result, 0.001f); 
  }

  @Test
  public void testEvaluateInvalidExpression() {
    StandardCalc calculator = new StandardCalc();
    assertThrows(InvalidExpression.class, () -> calculator.evaluate("2 + * 3", true));
  }

  @Test
  public void testEvaluateDivisionByZero() {
    StandardCalc calculator = new StandardCalc();
    assertThrows(ArithmeticException.class, () -> calculator.evaluate("5 / 0", true));
  }
}
