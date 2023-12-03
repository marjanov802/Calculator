package application;

class CalcModel {

  private RevPolishCalc calculator;

  /**
   * Constructs a CalcModel object with the given RevPolishCalc calculator.
   * 
   * @param calculator The calculator used for evaluating expressions.
   */
  CalcModel(RevPolishCalc calculator) {
    this.calculator = calculator;
  }

  /**
   * Evaluates a mathematical expression using the underlying RevPolishCalc calculator.
   * 
   * @param expression The expression to be evaluated.
   * @return The result of the evaluation.
   * @throws InvalidExpression If the expression is invalid or cannot be evaluated.
   */
  float evaluateExpression(String expression) throws InvalidExpression {
    return calculator.evaluate(expression);
  }
}
