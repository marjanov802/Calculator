
package application;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandardCalcTest {

    @Test
    void testSimpleAddition() throws InvalidExpression {
        Calculator calculator = new StandardCalc();
        float result = calculator.evaluate("2 + 3", true);
        assertEquals(5, result);
    }

    @Test
    void testSimpleMultiplication() throws InvalidExpression {
        Calculator calculator = new StandardCalc();
        float result = calculator.evaluate("2 * 3", true);
        assertEquals(6, result);
    }
    
    @Test
    public void testConvertToPostfix() throws InvalidExpression {
        StandardCalc calculator = new StandardCalc();
        assertEquals("3 4 +", calculator.convertToPostfix("3 + 4"));
    }
    
    
    
   
}
