package application;

import java.util.Stack;

public class RevPolishCalc implements Calculator {

    private Stack<Float> numStack;

    public RevPolishCalc() {
        numStack = new Stack<>();
    }

    @Override
    public float evaluate(String expression, Boolean infix) throws InvalidExpression {
        if (infix) {
            throw new InvalidExpression();
        }

        String[] elements = expression.split("\\s+");
        numStack.clear();

        try {
            for (int i = 0; i < elements.length; i++) {
                if (isNumber(elements[i])) {
                    numStack.push(Float.parseFloat(elements[i]));
                } else {
                    performOperation(elements[i]);
                }
            }

            if (numStack.size() != 1) {
                throw new InvalidExpression();
            }

            return numStack.pop();
        } catch (NumberFormatException e) {
            throw new InvalidExpression();
        }
    }

    private boolean isNumber(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void performOperation(String operator) throws InvalidExpression {
        try {
            float operand2 = numStack.pop();
            float operand1 = numStack.pop();

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

            numStack.push(result);
        } catch (java.util.EmptyStackException e) {
            throw new InvalidExpression();
        }
    }
}
