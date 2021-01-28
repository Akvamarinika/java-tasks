
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCalculator {


    @Test
    public void testAdd() {
       int expected = 15;
       int result = Calculator.add(5, 10);
       assertEquals(expected, result);

       double expected2 = 6.0;
       double result2 = Calculator.add(3.2, 2.8);
       assertEquals(expected2, result2, 0.001);
    }


    @Test
    public void testSubtraction() {
        double result = Calculator.subtraction(4.2,1.2);
        assertEquals(3.0, result, 0.001);

        int result2 = Calculator.subtraction(8, 15);
        assertEquals(-7, result2);

    }


    @Test
    public void testMultiplication() {
        double result = Calculator.multiplication(2.3,1.2);
        assertEquals(2.76, result, 0.001);

        int result2 = Calculator.multiplication(5, 8);
        assertEquals(40, result2);
    }



    @Test
    public void testDivision() {
        double result = Calculator.division(4.2,2);
        assertEquals(2.1, result, 0.001);

        int result2 = Calculator.division(15, 3);
        assertEquals(5, result2);
    }

    @Test
    public void testPow() {
        int result = Calculator.pow(2, 5);
        assertEquals(32, result);

        int result2 = Calculator.pow(3, 2);
        assertEquals(9, result2);
    }
}