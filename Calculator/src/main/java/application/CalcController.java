package application;

public class CalcController {

  private CalcModel model;
  private ViewInterface view;
  private OpType currentOpType;

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
