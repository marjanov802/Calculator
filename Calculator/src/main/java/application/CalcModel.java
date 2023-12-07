package application;

class CalcModel {

  private RevPolishCalc revPolishCalculator;
  private StandardCalc standardCalculator;

  /**
   * Constructs a CalcModel object with the given RevPolishCalc calculator.
   * 
   * @param revPolishCalculator The calculator used for evaluating expressions.
   */
  CalcModel(RevPolishCalc revPolishCalculator) {
    this.revPolishCalculator = revPolishCalculator;
    this.standardCalculator = new StandardCalc();
  }

  /**
   * Evaluates a mathematical expression using the underlying RevPolishCalc calculator.
   * 
   * @param expression The expression to be evaluated.
   * @return The result of the evaluation.
   * @throws InvalidExpression If the expression is invalid or cannot be evaluated.
   */
  float evaluateExpression(String expression, OpType type) throws InvalidExpression {
    switch (type) {
      case REV_POLISH:
        return revPolishCalculator.evaluate(expression);
      case STANDARD:
        return standardCalculator.evaluate(expression, true);
      default:
        throw new IllegalArgumentException("Unsupported calculator type: " + type);
    }
  }
}
