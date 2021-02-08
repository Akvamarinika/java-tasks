import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarQueueMethodsTest {

    CarLinkedList queue;

    @Before
    public void setUp() {
        queue = new CarLinkedList();
        for(int i = 0; i < 15; i++){
            queue.add(new Car(Brands.ACURA, Colors.RED, 100000 + i));
        }

    }

    @Test
    public void add() {
        assertEquals(15, queue.size());
    }

    @Test
    public void peekGetElement() {
        Car car = queue.peek();
        assertEquals(100000, car.getNumber());
        assertEquals(15, queue.size());
    }

    @Test
    public void pollTestRemoveElement() {
        Car car = queue.poll();
        assertEquals(100000, car.getNumber());
        assertEquals(14, queue.size());
    }
}