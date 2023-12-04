package application;

/**
 * The controller that sits between the calculator model that does actual evaluation and the view
 * that is the part the user interfaces with.
 */
public class CalcController {
  private CalcModel myModel;
  private ViewInterface myView;
  private boolean isInFix;

  private void handleCalculation() {}

  private void handleTypeChange(OpType opType) {
    isInFix = (opType == OpType.STANDARD); 

  }

  CalcController(CalcModel model, ViewInterface view) {
    this.myModel = model;
    this.myView = view;
    this.isInFix = true;
    
 // Register the controller as an observer to the view
    myView.addCalculateObserver(this::handleCalculation);
    myView.addTypeObserver(this::handleTypeChange);
  }
}
