package application;

/**
 * A driver class that sets up the MVC framework and begins the application.
 */
public class Driver {

  /**
   * The entry point for the calculator.
   *
   * @param args ignored - could be used to choose which view to load in the future?
   */
  public static void main(String[] args) {
    ViewInterface view = new AsciiView();

    Stack stack = new Stack(); // Create a Stack instance
    RevPolishCalc revPolishCalc = new RevPolishCalc(stack); // Create a RevPolishCalc instance

    CalcModel model = new CalcModel(revPolishCalc); // Pass RevPolishCalc to CalcModel constructor
    System.out.println("hello");

    // Decide which view to build.
    if (System.console() == null) {
      System.out.println("hello");
      view = CalcView.getInstance();
    }
    new CalcController(model, view);
    // All ready so begin the interface.
    view.startView();
  }
}
