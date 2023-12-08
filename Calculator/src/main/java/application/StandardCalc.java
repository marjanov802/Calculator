// https://www.geeksforgeeks.org/stack-peek-method-in-java/

package application;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The StandardCalc class takes a string and changes it from infix to postfix and then uses the
 * RevPolishCalc class to evaluate the expression.
 * 
 * @author DMarjanov
 */
public class StandardCalc implements Calculator {

  private OpStack opStack;
  private RevPolishCalc rpCalc;

  public StandardCalc() {
    this.opStack = new OpStack();
    this.rpCalc = new RevPolishCalc(new Stack());
  }

  @Override
  public float evaluate(String expression, Boolean infix) throws InvalidExpression {
    if (infix) {
      // Convert infix to postfix using opStack and then evaluate using rpCalc
      String postfixExpression = convertToPostfix(expression);
      float result = rpCalc.evaluate(postfixExpression);
      // Clear opStack after use
      opStack.clear();
      return result;
    } else {
      return 0;
    }
  }

  String convertToPostfix(String infix) throws InvalidExpression {
    StringBuilder postfix = new StringBuilder(); // StringBuilder to build the resulting postfix
    Deque<String> stack = new ArrayDeque<>(); // Stack to store operators during the conversion

    // Loop through each character in the infix expression
    for (int i = 0; i < infix.length(); i++) {
      char c = infix.charAt(i);

      // Ignore whitespaces
      if (Character.isWhitespace(c)) {
        continue;
      }

      // If the character is a digit or a dot, it's part of a numeric value
      if (Character.isDigit(c) || c == '.') {
        // Handle numeric values (including decimal points)
        StringBuilder numericValue = new StringBuilder();
        numericValue.append(c);

        // Continue to append digits and dots until a non-digit character is encountered
        while (i + 1 < infix.length()
            && (Character.isDigit(infix.charAt(i + 1)) || infix.charAt(i + 1) == '.')) {
          numericValue.append(infix.charAt(++i));
        }

        // Append the complete numeric value to the postfix expression
        postfix.append(numericValue.toString()).append(' ');
      } else if (c == '(') {
        // If the character is an opening bracket, push it onto the stack
        stack.push(String.valueOf(c));
      } else if (c == ')') {
        // If the character is a closing bracket, pop and append operators from the stack
        // until an opening bracket is encountered
        while (!stack.isEmpty() && !stack.peek().equals("(")) {
          postfix.append(stack.pop()).append(' ');
        }
        // Pop the opening bracket from the stack
        stack.pop();
      } else {
        // If the character is an operator
        while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(String.valueOf(c))) {
          // Pop and append operators from the stack to the postfix expression
          postfix.append(stack.pop()).append(' ');
        }
        // Push the current operator onto the stack
        stack.push(String.valueOf(c));
      }
    }

    // Pop and append any remaining operators from the stack to the postfix expression
    while (!stack.isEmpty()) {
      postfix.append(stack.pop()).append(' ');
    }

    // Trim and return the final postfix expression
    return postfix.toString().trim();
  }

  int precedence(String op) {
    switch (op) {
      case "+":
      case "-":
        return 1;
      case "*":
      case "/":
        return 2;
      default:
        return 0;
    }
  }
}
