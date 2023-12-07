package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CalcControllerTest {

  @Test
  void testCalcControllerConstruction() {
    CalcModel model = new CalcModel(new RevPolishCalc(new Stack()));
    ViewInterface view = new MockView(); // Using MockView for testing
    CalcController controller = new CalcController(model, view);
    assertNotNull(controller, "Controller should be constructed");
  }
  
  @Test
  void testObserversRegistration() {
    CalcModel mockModel = new CalcModel(new RevPolishCalc(new Stack()));
    MockView mockView = new MockView();
    CalcController controller = new CalcController(mockModel, mockView);

    assertTrue(mockView.isCalculateObserverRegistered(), "Calculate observer should be registered");
    assertTrue(mockView.isTypeObserverRegistered(), "Type observer should be registered");
  }
  
  @Test
  void testCalculateWithValidExpression() throws InvalidExpression {
    CalcModel mockModel = new CalcModel(new RevPolishCalc(new Stack()));
    MockView mockView = new MockView();
    CalcController controller = new CalcController(mockModel, mockView);
    mockView.setExpression("3 5 +");
    mockView.calculate();
    assertEquals("8.0", mockView.getAnswer());
  }
  
  @Test
  void testCalculateWithInvalidExpression() {
      CalcModel mockModel = new CalcModel(new RevPolishCalc(new Stack()));
      MockView mockView = new MockView();
      CalcController controller = new CalcController(mockModel, mockView);
      mockView.setExpression("invalid expression");
      assertTrue(mockView.isCalculateObserverRegistered());
      assertThrows(InvalidExpression.class, mockView::calculate);
  }
}
