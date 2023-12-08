package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ReleaseTest4 {
  
  @Test
  void testStandardCalcWithAddition() throws InvalidExpression {
    Calculator standardCalc = new StandardCalc();
    float result = standardCalc.evaluate("3 + 5", true);
    assertEquals(8.0, result, 0.001, "Addition should return 8.0");
  }

  @Test
  void testStandardCalcWithSubtraction() throws InvalidExpression {
    Calculator standardCalc = new StandardCalc();
    float result = standardCalc.evaluate("8 - 5", true);
    assertEquals(3.0, result, 0.001, "Subtraction should return 3.0");
  }

  @Test
  void testStandardCalcWithMultiplication() throws InvalidExpression {
    Calculator standardCalc = new StandardCalc();
    float result = standardCalc.evaluate("4 * 6", true);
    assertEquals(24.0, result, 0.001, "Multiplication should return 24.0");
  }

  @Test
  void testStandardCalcWithDivision() throws InvalidExpression {
    Calculator standardCalc = new StandardCalc();
    float result = standardCalc.evaluate("9 / 3", true);
    assertEquals(3.0, result, 0.001, "Division should return 3.0");
  }

  @Test
  void testStandardCalcWithComplexExpression() throws InvalidExpression {
    Calculator standardCalc = new StandardCalc();
    float result = standardCalc.evaluate("( 2 + 3 ) * 4", true);
    assertEquals(20.0, result, 0.001, "Complex expression should return 20.0");
  }

  @Test
  void testRevPolishCalcWithValidExpression() throws InvalidExpression {
    RevPolishCalc revPolishCalc = new RevPolishCalc(new Stack());
    float result = revPolishCalc.evaluate("3 5 +");
    assertEquals(8.0, result, 0.001, "RevPolishCalc should return 8.0");
  }

  @Test
  void testRevPolishCalcWithInvalidExpression() {
    RevPolishCalc revPolishCalc = new RevPolishCalc(new Stack());
    assertThrows(InvalidExpression.class, () -> revPolishCalc.evaluate("3 5 + *"),
        "Invalid expression should throw InvalidExpression");
  }
  
  @Test
  void testEvaluateWithBrackets() throws InvalidExpression {
    // Given an infix expression with brackets
    String infixExpression = "(3 + 5) * 2";

    // When using StandardCalc to evaluate the expression
    StandardCalc standardCalc = new StandardCalc();
    float result = standardCalc.evaluate(infixExpression, true);

    // Then the result should be calculated correctly
    assertEquals(16.0, result, "The result should be 16.0");
  }
  
}
