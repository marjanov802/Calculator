package application;

/**
 * Evaluates an expression - the evaluation can be Standard (infix) or reverse polish.
 */
public class CalcModel implements Calculator {
  private Calculator revPolish;
  private Calculator standard;

  public CalcModel() {
    // Default constructor without calculators
  }

  public void setRevPolishCalculator(Calculator revPolish) {
    this.revPolish = revPolish;
  }

  public void setStandardCalculator(Calculator standard) {
    this.standard = standard;
  }

  @Override
  public float evaluate(String expression, Boolean infix) throws InvalidExpression {
    if (infix) {
      if (standard == null) {
        throw new IllegalStateException("Standard calculator not set");
      }
      return standard.evaluate(expression, infix);
    } else {
      if (revPolish == null) {
        throw new IllegalStateException("Reverse Polish calculator not set");
      }
      return revPolish.evaluate(expression, infix);
    }
  }
}

