package application;

import java.util.Stack;

/**
 * A calculator that evaluates standard (infix) expressions.
 */
public class StandardCalc implements Calculator {

  @Override
  public float evaluate(String expression, Boolean infix) throws InvalidExpression {
    String[] tokens = expression.split("\\s+");
    Stack<Float> numStack = new Stack<>();
    Stack<String> opStack = new Stack<>();

    for (String token : tokens) {
      if (isNumeric(token)) {
        numStack.push(Float.parseFloat(token));
      } else if (isOperator(token)) {
        handleOperator(opStack, numStack, token);
      } else {
        throw new InvalidExpression();
      }
    }

    while (!opStack.isEmpty()) {
      performOperation(opStack.pop(), numStack);
    }

    if (numStack.size() != 1 || !opStack.isEmpty()) {
      throw new InvalidExpression();
    }

    return numStack.pop();
  }

  private void handleOperator(Stack<String> opStack, Stack<Float> numStack, String operator)
      throws InvalidExpression {
    while (!opStack.isEmpty() && precedence(opStack.peek()) >= precedence(operator)) {
      performOperation(opStack.pop(), numStack);
    }
    opStack.push(operator);
  }

  private void performOperation(String operator, Stack<Float> numStack) throws InvalidExpression {
    if (numStack.size() < 2) {
      throw new InvalidExpression();
    }

    float operand2 = numStack.pop();
    float operand1 = numStack.pop();
    float result = performOperation(operator, operand1, operand2);
    numStack.push(result);
  }

  private float performOperation(String operator, float operand1, float operand2) {
    switch (operator) {
      case "+":
        return operand1 + operand2;
      case "-":
        return operand1 - operand2;
      case "*":
        return operand1 * operand2;
      case "/":
        if (operand2 == 0) {
          throw new ArithmeticException("Division by zero");
        }
        return operand1 / operand2;
      default:
        throw new IllegalArgumentException("Unsupported operator: " + operator);
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

  private boolean isOperator(String token) {
    return token.matches("[+\\-*/]");
  }

  private int precedence(String operator) {
    switch (operator) {
      case "+":
      case "-":
        return 1;
      case "*":
      case "/":
        return 2;
      default:
        throw new IllegalArgumentException("Invalid operator: " + operator);
    }
  }
}
