import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testCopyList() {
        List<Integer> lst = new ArrayList<>();
        lst.add(15);
        lst.add(10);
        lst.add(12);
        lst.add(8);
        lst.add(35);
        List<Integer> dst = new ArrayList<>();
        Box.transfer(lst,dst);
        assertTrue(dst.containsAll(lst));

    }
}