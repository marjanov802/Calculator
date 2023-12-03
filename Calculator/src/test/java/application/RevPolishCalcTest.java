package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class RevPolishCalcTest {

  @Test
<<<<<<< HEAD
  public void testAddition() {
    RevPolishCalc calculator = new RevPolishCalc();

    try {
      float result = calculator.evaluate("3 5 +", false);
      assertEquals(8.0f, result, 0.001);
    } catch (InvalidExpression e) {
      fail("Unexpected InvalidExpression");
=======
  public void testEvaluateWithValidExpression() {
    Stack stack = new Stack();
    RevPolishCalc calculator = new RevPolishCalc(stack);

    try {
      float result = calculator.evaluate("3 5 +");
      assertEquals(8.0f, result, 0.001);
    } catch (InvalidExpression e) {
      fail("Unexpected InvalidExpression: " + e.getMessage());
>>>>>>> feature-StandardCalc
    }
  }

  @Test
<<<<<<< HEAD
  public void testSubtraction() {
    RevPolishCalc calculator = new RevPolishCalc();

    try {
      float result = calculator.evaluate("8 3 -", false);
      assertEquals(5.0f, result, 0.001);
    } catch (InvalidExpression e) {
      fail("Unexpected InvalidExpression");
=======
  public void testEvaluateWithInvalidExpression() {
    Stack stack = new Stack();
    RevPolishCalc calculator = new RevPolishCalc(stack);

    try {
      calculator.evaluate("invalid expression");
      fail("Expected InvalidExpression, but no exception was thrown");
    } catch (InvalidExpression e) {
      // Expected InvalidExpression
>>>>>>> feature-StandardCalc
    }
  }

  @Test
<<<<<<< HEAD
  public void testComplexExpression() {
    RevPolishCalc calculator = new RevPolishCalc();

    try {
      float result = calculator.evaluate("2 3 + 4 * 5 /", false);
      assertEquals(4.0f, result, 0.001);
    } catch (InvalidExpression e) {
      fail("Unexpected InvalidExpression");
    }
  }

  @Test
  public void testInvalidExpression() {
    RevPolishCalc calculator = new RevPolishCalc();

    try {
      calculator.evaluate("invalid expression", false);
      fail("Expected InvalidExpression, but no exception was thrown");
    } catch (InvalidExpression e) {
      // Expected InvalidExpression
    }
  }

  @Test
  public void testDivisionByZero() {
    RevPolishCalc calculator = new RevPolishCalc();

    try {
      calculator.evaluate("5 0 /", false);
      fail("Expected InvalidExpression, but no exception was thrown");
    } catch (InvalidExpression e) {
      // Expected InvalidExpression
    }
  }

  @Test
  public void testMultiplication() {
    RevPolishCalc calculator = new RevPolishCalc();

    try {
      float result = calculator.evaluate("4 2 *", false);
      assertEquals(8.0f, result, 0.001);
    } catch (InvalidExpression e) {
      //invalid expression expected
    }
  }

  @Test
  public void testInfixNotation() {
    RevPolishCalc calculator = new RevPolishCalc();

    try {
      calculator.evaluate("3 + 5", true);
      fail("Expected InvalidExpression, but no exception was thrown");
    } catch (InvalidExpression e) {
      // Expected InvalidExpression
    }
  }
=======
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



>>>>>>> feature-StandardCalc
}

