
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
    @Test
    void testConvertToPostfixBasic() throws InvalidExpression {
        StandardCalc calculator = new StandardCalc();

        // Test a basic infix expression
        assertEquals("3 4 +", calculator.convertToPostfix("3 + 4"));
        assertEquals("5 2 -", calculator.convertToPostfix("5 - 2"));
        assertEquals("2 3 *", calculator.convertToPostfix("2 * 3"));
        assertEquals("8 4 /", calculator.convertToPostfix("8 / 4"));
    }
    
    @Test
    void testConvertToPostfixDifferentValues() throws InvalidExpression {
        StandardCalc calculator = new StandardCalc();

        // Test infix expressions with different numeric values
        assertEquals("3.5 4.2 +", calculator.convertToPostfix("3.5 + 4.2"));
        assertEquals("1.2 2.5 -", calculator.convertToPostfix("1.2 - 2.5"));
        assertEquals("2.5 3.1 *", calculator.convertToPostfix("2.5 * 3.1"));
        assertEquals("7.0 2.0 /", calculator.convertToPostfix("7.0 / 2.0"));
    }
    
   
}
