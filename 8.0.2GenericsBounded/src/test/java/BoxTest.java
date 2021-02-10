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

    @Test
    public void testCopyObjectsInList() {
        List<Product> lst = new ArrayList<>();
        FlashDrive flashDrive  = new FlashDrive("flash2", 50, 1200, 64);
        lst.add(flashDrive);
        lst.add(new FlashDrive("flash", 10, 750, 32));
        lst.add(new Keyboard("Razer", 5, 6500, true, false, true));
        lst.add(new Mouse("Bloody", 15, 2500, true, 5500, 8));
        List<Product> dst = new ArrayList<>();
        Box.transfer(lst,dst);
        assertTrue(dst.containsAll(lst));

    }

    @Test
    public void testCopyFlashInList() {
        List<FlashDrive> lst = new ArrayList<>();
        lst.add(new FlashDrive("flash", 10, 750, 32));
        lst.add(new FlashDrive("flash2", 50, 1200, 64));
        lst.add(new FlashDrive("flash3", 100, 350, 8));
        lst.add(new FlashDrive("flash4", 30, 320, 4));
        lst.add(new FlashDrive("flash5", 20, 550, 16));
        List<Product> dst = new ArrayList<>();
        Box.copy(lst,dst);
        assertTrue(dst.containsAll(lst));

        List<Product> dst2 = new ArrayList<>();
        List<Product> src = new ArrayList<>();
        src.add(new FlashDrive("flash", 10, 750, 32));
        src.add(new Keyboard("Razer", 5, 6500, true, false, true));
        src.add(new Mouse("Bloody", 15, 2500, true, 5500, 8));
        Box.copy(src,dst2);
        assertTrue(dst.containsAll(lst));

    }
}