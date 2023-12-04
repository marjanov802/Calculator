package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalcControllerTest {

  @Test
  void testCalcControllerConstruction() {
      CalcModel model = new CalcModel(new RevPolishCalc(new Stack()));
      ViewInterface view = new CalcView(); // Using a real CalcView instance for the sake of example
      CalcController controller = new CalcController(model, view);
      assertNotNull(controller, "Controller should be constructed");
  }
}
