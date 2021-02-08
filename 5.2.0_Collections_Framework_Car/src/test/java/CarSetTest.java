import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarSetTest {
   private CarHashSet<Car> carSet;

    @Before
    public void setUp()  {
        carSet = new CarHashSet<>();
        assertTrue(carSet.add(new Car(Brands.BMW, Colors.BLACK,888888)));
        assertTrue(carSet.add(new Car(Brands.BMW, Colors.WHITE, 555555)));
        assertTrue(carSet.add(new Car(Brands.BMW, Colors.BLACK, 666666)));
        assertTrue(carSet.add(new Car(Brands.AUDI, Colors.ORANGE, 233232)));
        assertTrue(carSet.add(new Car(Brands.RENAULT, Colors.RED, 777777)));
        for (int i = 0; i < 95; i++){
            carSet.add(new Car());
        }
        System.out.println("Size: " + carSet.size());

    }

    @Test
    public void whenAddSameElementsSizeIncreaseByOne() {
        whenAddFiveDifferentElementsSizeEquals100();
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
        assertEquals(100, carSet.size());
    }

    @Test
    public void remove() {
        System.out.println(carSet);
        assertTrue(carSet.remove(new Car(Brands.BMW, Colors.BLACK,888888)));
        assertEquals(99, carSet.size());
        assertFalse(carSet.remove(new Car(Brands.BMW, Colors.BLACK,888888)));
        assertEquals(99, carSet.size());
        System.out.println(carSet);
    }

    @Test
    public void whenAddFiveDifferentElementsSizeEquals100() {
        assertEquals(100, carSet.size());
    }

    @Test
    public void whenClearedSizeEqualsZero() {
        carSet.clear();
        assertEquals(0, carSet.size());
    }

    @Test
    public void whenInCollectionHasElementReturnTrue(){
        Car car = new Car(Brands.BMW, Colors.BLACK, 666666);
        assertEquals(100, carSet.size());
        assertTrue(carSet.contains(car));
    }

    @Test
    public void whenInCollectionNoElementReturnFalse(){
        Car car = new Car(Brands.ALFA_ROMEO, Colors.ORANGE, 123456);
        assertFalse(carSet.contains(car));
    }

}