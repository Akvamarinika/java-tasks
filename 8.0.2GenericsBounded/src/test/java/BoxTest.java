import org.junit.Test;

import static org.junit.Assert.*;

public class BoxTest {

    @Test
    public void testBox() {
        Box<Integer> box1 = new Box<>(1,2,3,4,5);
        assertEquals(3, box1.avg(), 0.001);

        Box<Float> box2 = new Box<>(10f,1f,4f,5f);
        assertEquals(5, box2.avg(), 0.001);
    }

    @Test
    public void compareBox() {
        Box<Integer> box1 = new Box<>(1,2,3,4,5);
        Box<Float> box2 = new Box<>(10f,1f,4f,5f);
        assertEquals(-2, box1.compare(box2));
    }
}