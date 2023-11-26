package application;

import org.junit.Test;
import static org.junit.Assert.*;

public class RevPolishCalcTest {

  @Test
  public void testEvaluateAddition() throws InvalidExpression {
    RevPolishCalc revPolishCalc = new RevPolishCalc();
    float result = revPolishCalc.evaluate("3 4 +", false);
    assertEquals(7.0f, result, 0.001f);
  }

  @Test
  public void testEvaluateSubtraction() throws InvalidExpression {
    RevPolishCalc revPolishCalc = new RevPolishCalc();
    float result = revPolishCalc.evaluate("5 2 -", false);
    assertEquals(3.0f, result, 0.001f);
  }

  @Test
  public void testEvaluateMultiplication() throws InvalidExpression {
    RevPolishCalc revPolishCalc = new RevPolishCalc();
    float result = revPolishCalc.evaluate("4 3 *", false);
    assertEquals(12.0f, result, 0.001f);
  }

  @Test
  public void testEvaluateDivision() throws InvalidExpression {
    RevPolishCalc revPolishCalc = new RevPolishCalc();
    float result = revPolishCalc.evaluate("6 2 /", false);
    assertEquals(3.0f, result, 0.001f);
  }

  @Test(expected = InvalidExpression.class)
  public void testEvaluateInvalidExpression() throws InvalidExpression {
    RevPolishCalc revPolishCalc = new RevPolishCalc();
    revPolishCalc.evaluate("3 + 4", false);
  }

  @Test(expected = InvalidExpression.class)
  public void testEvaluateDivisionByZero() throws InvalidExpression {
    RevPolishCalc revPolishCalc = new RevPolishCalc();
    revPolishCalc.evaluate("5 0 /", false);
  }
}
