package application;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Random;

public class CalcModelTest {

  @Test
  public void testEvaluateWithRevPolishCalculator() throws InvalidExpression {
    Random random = new Random();

    Calculator revPolishCalculator = (expr, infix) -> random.nextFloat() * 10; // Random value
    Calculator standardCalculator = (expr, infix) -> random.nextFloat() * 10;
    CalcModel calcModel = new CalcModel(revPolishCalculator, standardCalculator);
    float result = calcModel.evaluate("3 4 +", false);
    assertTrue(result >= 0.0f && result <= 10.0f);
  }


  @Test
  public void testEvaluateWithStandardCalculator() throws InvalidExpression {
    Calculator revPolishCalculator = (expr, infix) -> 0.0f;
    Calculator standardCalculator = (expr, infix) -> 7.0f;

    CalcModel calcModel = new CalcModel(revPolishCalculator, standardCalculator);
    float result = calcModel.evaluate("3 + 4", true);
    assertEquals(7.0f, result, 0.001f);
  }


  @Test(expected = InvalidExpression.class)
  public void testEvaluateInvalidExpression() throws InvalidExpression {
    Calculator revPolishCalculator = (expr, infix) -> {
      throw new InvalidExpression();
    };

    Calculator standardCalculator = (expr, infix) -> 0.0f;

    CalcModel calcModel = new CalcModel(revPolishCalculator, standardCalculator);

    calcModel.evaluate("invalid expression", false);
  }
}
