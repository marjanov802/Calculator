package application;

import java.util.ArrayDeque;
import java.util.Deque;

public class StandardCalc implements Calculator {

  private OpStack opStack;
  private RevPolishCalc rpCalc;

  public StandardCalc() {
    this.opStack = new OpStack();
    this.rpCalc = new RevPolishCalc(new Stack());
  }

  @Override
  public float evaluate(String expression, Boolean infix) throws InvalidExpression {
    if (!infix) {
      // Implementation for reverse polish notation will be added later
      return 0; // Placeholder
    }

    // Split the expression into operands and operator
    String[] tokens = expression.split("\\s+");
    float operand1 = Float.parseFloat(tokens[0]);
    String operator = tokens[1];
    float operand2 = Float.parseFloat(tokens[2]);

    // Perform the arithmetic operation
    switch (operator) {
      case "+":
        return operand1 + operand2;
      case "-":
        return operand1 - operand2;
      case "*":
        return operand1 * operand2;
      case "/":
        if (operand2 == 0) {
          throw new InvalidExpression();
        }
        return operand1 / operand2;
      default:
        throw new InvalidExpression();
    }
  }

  String convertToPostfix(String infix) throws InvalidExpression {//Trail 1 Shunting yard Algorit
    StringBuilder postfix = new StringBuilder();
    Deque<Character> stack = new ArrayDeque<>();

    for (int i = 0; i < infix.length(); i++) {
      char c = infix.charAt(i);

      if (Character.isWhitespace(c)) {
        continue;
      }

      if (Character.isDigit(c)) {
        postfix.append(c).append(' ');
      } else {
        while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
          postfix.append(stack.pop()).append(' ');
        }
        stack.push(c);
      }
    }

    while (!stack.isEmpty()) {
      postfix.append(stack.pop()).append(' ');
    }

    return postfix.toString().trim();
  }

  private int precedence(char op) {// order in which operators are evaluated in an expression
    switch (op) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
      default:
        return 0;
    }
  }
}
