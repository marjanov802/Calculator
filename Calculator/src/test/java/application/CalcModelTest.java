package application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalcModelTest {

    @Test
    public void testEvaluateExpressionWithValidExpression() {
        RevPolishCalc simpleCalculator = new RevPolishCalc(new Stack());
        CalcModel calcModel = new CalcModel(simpleCalculator);

        try {
            float result = calcModel.evaluateExpression("3 5 +", OpType.REV_POLISH);
            assertEquals(8.0f, result, 0.0001f, "Unexpected result for valid expression");
        } catch (InvalidExpression e) {
            fail("Unexpected InvalidExpression: " + e.getMessage());
        }
    }

    @Test
    public void testEvaluateExpressionWithInvalidExpression() {
        RevPolishCalc simpleCalculator = new RevPolishCalc(new Stack());
        CalcModel calcModel = new CalcModel(simpleCalculator);

        assertThrows(InvalidExpression.class, () -> calcModel.evaluateExpression("invalid expression", OpType.REV_POLISH),
                "Expected InvalidExpression, but no exception was thrown");
    }

    @Test
    public void testEvaluateExpressionWithEmptyExpression() {
        RevPolishCalc simpleCalculator = new RevPolishCalc(new Stack());
        CalcModel calcModel = new CalcModel(simpleCalculator);

        assertThrows(InvalidExpression.class, () -> calcModel.evaluateExpression("", OpType.REV_POLISH),
                "Expected InvalidExpression, but no exception was thrown");
    }

    // Add more tests as needed for different scenarios and edge cases 
    //Add more tests for higher test coverage

}
