package application;

/**
 * Evaluates an expression - the evaluation can be Standard (infix) or reverse polish.
 */
public class CalcModel implements Calculator {
  private Calculator revPolish;
  private Calculator standard;

  public CalcModel(Calculator revPolish, Calculator standard) {
    this.revPolish = revPolish;
    this.standard = standard;
  }

  @Override
  public float evaluate(String expression, Boolean infix) throws InvalidExpression {
    if (infix) {
      return standard.evaluate(expression, infix);
    } else {
      return revPolish.evaluate(expression, infix);
    }
  }
}
