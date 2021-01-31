package by.it.doNotTouch.degtyaryov.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScalarTest {

    private static final double DELTA = 1e-5;
    private Parser parser = new Parser();

    @Test
    public void add() throws CalcException {
        String expression = "2 + 5.3";
        double expected = 7.3;
        Var actualResult = parser.calc(expression);
        double actual = Double.parseDouble(actualResult.toString());
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void sub() throws CalcException {
        String expression = "25.99 - 26";
        double expected = -0.01;
        Var actualResult = parser.calc(expression);
        double actual = Double.parseDouble(actualResult.toString());
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void mul() throws CalcException {
        String expression = "7.3 * -3.5";
        double expected = -25.55;
        Var actualResult = parser.calc(expression);
        double actual = Double.parseDouble(actualResult.toString());
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void div() throws CalcException {
        String expression = "1000 / 20";
        double expected = 50;
        Var actualResult = parser.calc(expression);
        double actual = Double.parseDouble(actualResult.toString());
        assertEquals(expected, actual, DELTA);
    }

    @Test(expected = CalcException.class)
    public void divByZero() throws CalcException {
        String expression = "1 / 0";
        parser.calc(expression);
    }

    @Test
    public void stringToScalar() {
        String expression = "1234.01";
        Var actualResult = new Scalar(expression);
        assertEquals(expression, actualResult.toString());
    }
}