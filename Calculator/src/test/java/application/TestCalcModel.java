package application;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestCalcModel {

  @Test
  public void testEvaluateWithRevPolishCalculator() throws InvalidExpression {
    CalcModel calcModel = new CalcModel();
    Calculator revPolishCalculator = new RevPolishCalc();
    calcModel.setRevPolishCalculator(revPolishCalculator);

    float result = calcModel.evaluate("3 4 +", false);

    assertEquals(7.0f, result, 0.001f);
  }

  @Test
  public void testEvaluateWithStandardCalculator() throws InvalidExpression {
    CalcModel calcModel = new CalcModel();
    Calculator standardCalculator = new StandardCalc(); 
    calcModel.setStandardCalculator(standardCalculator);

    float result = calcModel.evaluate("3 + 4", true);

    assertEquals(7.0f, result, 0.001f);
  }
}
