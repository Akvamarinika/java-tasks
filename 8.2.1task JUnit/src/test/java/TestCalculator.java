
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
    }


    @Test
    public void testMultiplication() {
    }



    @Test
    public void testDivision() {
    }

    @Test
    public void testPow() {
    }
}