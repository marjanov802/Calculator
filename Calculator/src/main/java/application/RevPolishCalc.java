package application;

import java.util.Stack;

/**
 * A calculator that evaluates expressions in reverse Polish notation.
 */
public class RevPolishCalc implements Calculator {
  private Stack<Float> numStack;

  public RevPolishCalc() {
    this.numStack = new Stack<>();
  }

  @Override
  public float evaluate(String expr, Boolean infix) throws InvalidExpression {
    String[] tokens = expr.split("\\s+");

    for (String token : tokens) {
      if (isNumeric(token)) {
        numStack.push(Float.parseFloat(token));
      } else {
        performOperation(token);
      }
    }

    if (numStack.size() != 1) {
      throw new InvalidExpression();
    }

    return numStack.pop();
  }

  private void performOperation(String operator) throws InvalidExpression {
    if (numStack.size() < 2) {
      throw new InvalidExpression();
    }

    float operand2 = numStack.pop();
    float operand1 = numStack.pop();

    switch (operator) {
      case "+":
        numStack.push(operand1 + operand2);
        break;
      case "-":
        numStack.push(operand1 - operand2);
        break;
      case "*":
        numStack.push(operand1 * operand2);
        break;
      case "/":
        if (operand2 == 0) {
          throw new InvalidExpression();
        }
        numStack.push(operand1 / operand2);
        break;
      default:
        throw new InvalidExpression();
    }
  }

  private boolean isNumeric(String str) {
    try {
      Float.parseFloat(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
