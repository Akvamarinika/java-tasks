import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarSetTest {
   private CarHashSet carSet;

    @Before
    public void setUp()  {
        carSet = new CarHashSet();
        assertTrue(carSet.add(new Car(Brands.BMW, Colors.BLACK,234567)));
        assertTrue(carSet.add(new Car(Brands.BMW, Colors.WHITE, 555555)));
        assertTrue(carSet.add(new Car(Brands.BMW, Colors.BLACK, 666666)));
        assertTrue(carSet.add(new Car(Brands.AUDI, Colors.ORANGE, 233232)));
        assertTrue(carSet.add(new Car(Brands.RENAULT, Colors.RED, 777777)));
        for (int i = 0; i < 95; i++){
            carSet.add(new Car());
        }
        System.out.println("Size: " + carSet.size());
        System.out.println(carSet);
    }

    @Test
    public void whenAddSameElementsSizeIncreaseByOne() {
        whenAddFiveDifferentElementsSizeEqualsFive();
        Car car = new Car(Brands.ALFA_ROMEO, Colors.ORANGE, 123456);
        int expected = carSet.size();
        assertTrue(carSet.add(car));
        assertFalse(carSet.add(car));
        assertFalse(carSet.add(car));
        assertEquals(expected + 1, carSet.size());
    }

    @Test
    public void whenRemoveNotExistentElementReturnFalse() {
        Car car = new Car(Brands.ALFA_ROMEO, Colors.ORANGE, 123456);
        assertFalse(carSet.remove(car));
        assertEquals(101, carSet.size());
    }

    @Test
    public void remove() {
        Car car = new Car(Brands.BMW, Colors.BLACK,234567);
        assertTrue(carSet.remove(car));
        assertEquals(99, carSet.size());
    }

    @Test
    public void whenAddFiveDifferentElementsSizeEqualsFive() {
        assertEquals(100, carSet.size());
    }

    @Test
    public void whenClearedSizeEqualsZero() {
        carSet.clear();
        assertEquals(0, carSet.size());
    }
}