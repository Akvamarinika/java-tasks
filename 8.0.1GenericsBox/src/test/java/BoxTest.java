import org.junit.Test;

import static org.junit.Assert.*;

public class BoxTest {
    @Test
    public void testBox(){
        Box<String, Integer, Float> box1 = new Box<>("box1", 120, 80.5f);
        Box<String, Float, Integer> box2 = new Box<>("box2", 200.8f, 110);
        float result = box1.getHeight() + box1.getWeight() + box2.getHeight() + box2.getWeight();
        assertEquals(511.3, result, 0.001);
    }



}