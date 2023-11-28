package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

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
  
}
