package application;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalcModelTest {

  @Test
  public void testEvaluateWithRevPolishCalculator() throws InvalidExpression {
    CalcModel calcModel = new CalcModel();
    Calculator revPolishCalculator = new RevPolishCalc(); // Replace with your actual implementation
    calcModel.setRevPolishCalculator(revPolishCalculator);

    float result = calcModel.evaluate("3 4 +", false);

    assertEquals(7.0f, result, 0.001f);
  }


  @Test(expected = IllegalStateException.class)
  public void testEvaluateWithNullRevPolishCalculator() throws InvalidExpression {
    CalcModel calcModel = new CalcModel();
    calcModel.evaluate("3 4 +", false);
  }

  @Test(expected = IllegalStateException.class)
  public void testEvaluateWithNullStandardCalculator() throws InvalidExpression {
    CalcModel calcModel = new CalcModel();
    calcModel.evaluate("3 + 4", true);
  }
}
