import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarMapTest {
    private CarMap<CarOwner, Car> ownersCars;

    @Before
    public void setUp()  {
        ownersCars = new CarHashMap<>();

    }

    @Test
    public void whenGetElementReturnValueCar() {
        whenPut100ElementCollectionThenSizeBecome100();
        CarOwner owner = new CarOwner(0, "Ivan0", "Ivanov0");
        Car car = ownersCars.get(owner);
        System.out.println(car);
    }


    @Test
    public void whenPut100ElementCollectionThenSizeBecome100() {
        CarOwner owner;
        Car car;
        for (int i = 0; i < 100; i++){
            owner = new CarOwner(i, "Ivan" + i, "Ivanov" + i);
            car = new Car();
            ownersCars.put(owner, car);
        }
        assertEquals(100, ownersCars.size());
    }

    @Test
    public void whenPut100ElementsWith10DifferentKeysThenSize10() {
        CarOwner owner;
        Car car;
        for (int i = 0; i < 100; i++){
            int idx = i % 10;
            owner = new CarOwner(idx, "Ivan" + idx, "Ivanov" + idx);
            car = new Car();
            ownersCars.put(owner, car);
        }
        assertEquals(10, ownersCars.size());
    }

    @Test
    public void whenPutElementHasKeyValueReplacedWithNewOne() {
        whenPut100ElementCollectionThenSizeBecome100();
        assertEquals(100, ownersCars.size());
        CarOwner owner = new CarOwner(99, "Ivan99", "Ivanov99");
        Car car = new Car();
        System.out.println(ownersCars.get(owner));

        ownersCars.put(owner, car);
        assertEquals(100, ownersCars.size());
        System.out.println(ownersCars.get(owner));
    }


    @Test
    public void countOfKeysMustBeEqualsToCountOfValues() {
        whenPut100ElementCollectionThenSizeBecome100();
        assertEquals(100, ownersCars.keySet().size());
        assertEquals(100, ownersCars.values().size());
    }

    @Test
    public void whenRemoveElementCollectionSizeWillDecreaseBy1() {
        CarOwner owner;
        Car car;
        for (int i = 0; i < 10; i++){
            owner = new CarOwner(i, "Ivan" + i, "Ivanov" + i);
            car = new Car();
            ownersCars.put(owner, car);
        }

        assertEquals(10, ownersCars.size());
        CarOwner owner5 = new CarOwner(5, "Ivan5", "Ivanov5");
        assertTrue(ownersCars.remove(owner5));
        assertEquals(9, ownersCars.size());
        assertFalse(ownersCars.remove(owner5));
        assertEquals(9, ownersCars.size());
    }

    @Test
    public void whenRemoveLastElementCollectionSizeWillDecreaseBy1() {
        CarOwner owner;
        Car car;
        for (int i = 0; i < 10; i++){
            owner = new CarOwner(i, "Ivan" + i, "Ivanov" + i);
            car = new Car();
            ownersCars.put(owner, car);
        }

        assertEquals(10, ownersCars.size());
        CarOwner owner9 = new CarOwner(9, "Ivan9", "Ivanov9");
        assertTrue(ownersCars.remove(owner9));
        assertEquals(9, ownersCars.size());
        assertFalse(ownersCars.remove(owner9));
        assertEquals(9, ownersCars.size());
    }

    @Test
    public void whenRemoveFirstElementCollectionSizeWillDecreaseBy1() {
        CarOwner owner;
        Car car;
        for (int i = 0; i < 10; i++){
            owner = new CarOwner(i, "Ivan" + i, "Ivanov" + i);
            car = new Car();
            ownersCars.put(owner, car);
        }

        assertEquals(10, ownersCars.size());
        CarOwner owner0 = new CarOwner(0, "Ivan0", "Ivanov0");
        assertTrue(ownersCars.remove(owner0));
        assertEquals(9, ownersCars.size());
        assertFalse(ownersCars.remove(owner0));
        assertEquals(9, ownersCars.size());
    }


    @Test
    public void clear() {
        ownersCars.clear();
        assertEquals(0, ownersCars.size());
    }
}