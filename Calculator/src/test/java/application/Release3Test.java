package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class Release3Test {
  @Test
  void testInfixExpressionEvaluation() throws InvalidExpression {
      Calculator calculator = new StandardCalc();
      float result = calculator.evaluate("2 + 3 * 4", true);
      assertEquals(14.0, result);
  }
  
  @Test
  void testPostfixExpressionEvaluation() throws InvalidExpression {
      Calculator calculator = new StandardCalc();
      float result = calculator.evaluate("2 3 4 * +", false);
      assertEquals(14.0, result);
  }
  
  @Test
  void testInvalidInfixExpression() {
      Calculator calculator = new StandardCalc();
      assertThrows(InvalidExpression.class, () -> calculator.evaluate("2 + * 3", true));
  }
  
  @Test
  void testInvalidPostfixExpression() {
      Calculator calculator = new StandardCalc();
      assertThrows(InvalidExpression.class, () -> calculator.evaluate("2 3 * *", false));
  }
  
  @Test
  void testCalcModelEvaluateExpression() throws InvalidExpression {
      RevPolishCalc rpCalc = new RevPolishCalc(new Stack());
      CalcModel calcModel = new CalcModel(rpCalc);
      float result = calcModel.evaluateExpression("2 3 4 * +");
      assertEquals(14.0, result);
  }
  
}
