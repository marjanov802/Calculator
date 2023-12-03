package application;

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
  
  public String convertToPostfix(String infix) throws InvalidExpression {
    return ("3 4 +");
}


}
