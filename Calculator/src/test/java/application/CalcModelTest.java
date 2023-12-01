package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class CalcModelTest {

  @Test
  public void testEvaluateWithRevPolishCalculator() throws InvalidExpression {
    CalcModel calcModel = new CalcModel();
    Calculator revPolishCalculator = new RevPolishCalc();
    calcModel.setRevPolishCalculator(revPolishCalculator);

    float result = calcModel.evaluate("3 4 +", false);

    assertEquals(7.0f, result, 0.001f);
  }

  @Test
  public void testEvaluateWithNullRevPolishCalculator() {
    CalcModel calcModel = new CalcModel();

    assertThrows(IllegalStateException.class, () -> {
      calcModel.evaluate("3 4 +", false);
    });
  }

  @Test
  public void testEvaluateWithNullStandardCalculator() {
    CalcModel calcModel = new CalcModel();

    assertThrows(IllegalStateException.class, () -> {
      calcModel.evaluate("3 + 4", true);
    });
  }

}
