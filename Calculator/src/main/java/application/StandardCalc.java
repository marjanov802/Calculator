// StandardCalc.java
package application;

public class StandardCalc implements Calculator {

    @Override
    public float evaluate(String expression, Boolean infix) throws InvalidExpression {
        if (!infix) {
          return 0;
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
}
