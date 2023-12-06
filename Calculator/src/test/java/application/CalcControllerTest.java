package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalcControllerTest {

  @Test
  void testCalcControllerConstruction() {
    CalcModel model = new CalcModel(new RevPolishCalc(new Stack()));
    ViewInterface view = new MockView(); // Using MockView for testing
    CalcController controller = new CalcController(model, view);
    assertNotNull(controller, "Controller should be constructed");
  }
  
  

}
