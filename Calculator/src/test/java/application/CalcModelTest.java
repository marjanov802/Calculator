package application;

import org.junit.jupiter.api.Test;

public class CalcModelTest {

    @Test
    public void testEvaluateExpressionWithValidExpression() {
        RevPolishCalc simpleCalculator = new RevPolishCalc(new Stack());
        CalcModel calcModel = new CalcModel(simpleCalculator);

        try {
            float result = calcModel.evaluateExpression("3 5 +");
            assert result == 8.0f : "Expected result: 8.0, Actual result: " + result;
        } catch (InvalidExpression e) {
            assert false : "Unexpected InvalidExpression: " + e.getMessage();
        }
    }

    @Test
    public void testEvaluateExpressionWithInvalidExpression() {
        RevPolishCalc simpleCalculator = new RevPolishCalc(new Stack());
        CalcModel calcModel = new CalcModel(simpleCalculator);

        try {
            calcModel.evaluateExpression("invalid expression");
            assert false : "Expected InvalidExpression, but no exception was thrown";
        } catch (InvalidExpression e) {
            // Expected InvalidExpression
        }
    }

    @Test
    public void testEvaluateExpressionWithEmptyExpression() {
        RevPolishCalc simpleCalculator = new RevPolishCalc(new Stack());
        CalcModel calcModel = new CalcModel(simpleCalculator);

        try {
            calcModel.evaluateExpression("");
            assert false : "Expected InvalidExpression, but no exception was thrown";
        } catch (InvalidExpression e) {
            // Expected InvalidExpression
        }
    }

    // Add more tests as needed for different scenarios and edge cases

}
