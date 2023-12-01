package application;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class StandardCalcTest {

  @Test
  void createStandardCalcShouldNotBeNull() {
    StandardCalc calculator = new StandardCalc();
    assertNotNull(calculator);
  }
}
