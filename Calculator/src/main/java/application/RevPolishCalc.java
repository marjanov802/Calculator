package application;

import java.util.EmptyStackException;

class RevPolishCalc {

  private Stack numStack;

  /**
   * Constructs a RevPolishCalc object with the given Stack.
   * 
   * @param numStack The Stack used for operand storage.
   */
  RevPolishCalc(Stack numStack) {
    this.numStack = numStack;
  }

  /**
   * Evaluates a mathematical expression in Reverse Polish Notation.
   * 
   * @param expr The expression in Reverse Polish Notation.
   * @return The result of the evaluation.
   * @throws InvalidExpression If the expression is invalid or cannot be evaluated.
   */
  float evaluate(String expr) throws InvalidExpression {
    String[] expression = expr.split("\\s+");

    for (String element : expression) {
      evaluateElement(element);
    }

    try {
      return numStack.pop().getValue();
    } catch (EmptyStackException e) {
      throw new InvalidExpression();
    }
  }

  private void evaluateElement(String element) throws InvalidExpression {
    try {
      float operand = Float.parseFloat(element);
      numStack.push(new Entry(operand));
    } catch (NumberFormatException e) {
      performOperation(element);
    }
  }

  private void performOperation(String operator) throws InvalidExpression {
    try {
      float operand2 = numStack.pop().getValue();
      float operand1 = numStack.pop().getValue();

      float result;
      switch (operator) {
        case "+":
          result = operand1 + operand2;
          break;
        case "-":
          result = operand1 - operand2;
          break;
        case "*":
          result = operand1 * operand2;
          break;
        case "/":
          if (operand2 == 0) {
            throw new InvalidExpression();
          }
          result = operand1 / operand2;
          break;
        default:
          throw new InvalidExpression();
      }

      numStack.push(new Entry(result));
    } catch (EmptyStackException e) {
      throw new InvalidExpression();
    }
  }
}
