package application;

/**
 * Controller for Calculator that makes connection between controller and view.
 * @param model The calculator model for evaluating expressions.
 * @param view  The user interface view for user interactions and displaying results.
 */
public class CalcController {

  private CalcModel model;
  private ViewInterface view;
  private OpType currentOpType;

  /**
   * Constructs a new CalcController with the specified CalcModel and ViewInterface.
   *
   * @param model The CalcModel responsible for evaluating expressions.
   * @param view  The ViewInterface represents user interface for user interactions.
   */
  public CalcController(CalcModel model, ViewInterface view) {
    this.model = model;
    this.view = view;
    this.currentOpType = OpType.STANDARD;

    view.addCalculateObserver(this::calculate);
    view.addTypeObserver(this::expressionTypeChange);
    view.startView();
  }

  private void calculate() {
    String expression = view.getExpression();
    try {
      float result = model.evaluateExpression(expression, currentOpType);
      view.setAnswer(String.valueOf(result));
    } catch (InvalidExpression e) {
      view.setAnswer("Error: Invalid Expression");
    }
  }

  private void expressionTypeChange(OpType type) {
  }

  public OpType getCurrentOpType() {
    return currentOpType;
  }
}
