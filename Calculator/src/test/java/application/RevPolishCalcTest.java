package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class RevPolishCalcTest {

  @Test
  public void testEvaluateWithValidExpression() {
    Stack stack = new Stack();
    RevPolishCalc calculator = new RevPolishCalc(stack);

    try {
      float result = calculator.evaluate("3 5 +");
      assertEquals(8.0f, result, 0.001);
    } catch (InvalidExpression e) {
      fail("Unexpected InvalidExpression: " + e.getMessage());
    }
  }

  @Test
  public void testEvaluateWithInvalidExpression() {
    Stack stack = new Stack();
    RevPolishCalc calculator = new RevPolishCalc(stack);

    try {
      calculator.evaluate("invalid expression");
      fail("Expected InvalidExpression, but no exception was thrown");
    } catch (InvalidExpression e) {
      // Expected InvalidExpression
    }
  }

  @Test
  public void testEvaluateWithEmptyExpression() {
    Stack stack = new Stack();
    RevPolishCalc calculator = new RevPolishCalc(stack);

    try {
      calculator.evaluate("");
      fail("Expected InvalidExpression, but no exception was thrown");
    } catch (InvalidExpression e) {
      // Expected InvalidExpression
    }
  }



}

