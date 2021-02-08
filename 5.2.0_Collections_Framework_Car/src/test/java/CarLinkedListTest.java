import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarLinkedListTest {
    private CarLinkedList<Car> carList;

    @Before
    public void setUp() {
        carList = new CarLinkedList<>();
        for (int i = 0; i < 100; i++){
            carList.add(new Car());
        }
        System.out.println("Size: " + carList.size());
        System.out.println(carList);

    }

    @Test
    public void whenGeExistentIndexItemReturnItem() {
        System.out.println(carList.get(99));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetNonExistentIndexItemThrowException() {
        carList.get(100);
    }

    @Test
    public void whenAdded100CarsInListMustSizeBe100() {
        assertEquals(100, carList.size());
        System.out.println("Size: " + carList.size());
    }

    @Test
    public void whenAddedByIndexOnFirstPlaceCarInListMustSizeBe101() {
        Car car = new Car(Brands.CADILLAC, Colors.CHERRY, 666666);
        carList.add(car, 0);
        assertEquals(101, carList.size());
    }
    @Test
    public void whenAddedByIndexOnLastPlaceCarInListMustSizeBe101() {
        Car car = new Car(Brands.CADILLAC, Colors.CHERRY, 666666);
        carList.add(car, carList.size()-1);
        assertEquals(101, carList.size());
    }

    @Test
    public void whenRemovedCarInListMustSizeBe100AndReturnTrue() {
        Car car = new Car(Brands.CADILLAC, Colors.CHERRY, 666666);
        carList.add(car);
        System.out.println(carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
        System.out.println(carList.size());
    }

    @Test
    public void whenRemovedNEWCarObjectInListMustSizeBe100AndReturnTrue() {
        carList.add(new Car(Brands.CADILLAC, Colors.CHERRY, 666666));
        System.out.println(carList.size());
        assertTrue(carList.remove(new Car(Brands.CADILLAC, Colors.CHERRY, 666666)));
        assertEquals(100, carList.size());
        System.out.println(carList.size());
    }

    @Test
    public void whenRemovedNonExistentItemInListReturnFalse() {
        Car car = new Car(Brands.CADILLAC, Colors.CHERRY, 666666);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenRemovedByIndexCarInListMustSizeBe99AndReturnTrue() {
        System.out.println(carList.get(10));
        assertTrue(carList.removeAt(10));
        assertEquals(99, carList.size());
        System.out.println(carList.get(10));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenRemovedByIndexNonExistentItemThrowException() {
        carList.removeAt(100);
    }

    @Test
    public void whenClearListMustBeSize0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test
    public void whenInCollectionHasElementReturnTrue(){
        Car car = new Car(Brands.CADILLAC, Colors.CHERRY, 666666);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.contains(car));
    }

    @Test
    public void whenInCollectionNoElementReturnFalse(){
        Car car = new Car(Brands.CADILLAC, Colors.CHERRY, 666666);
        assertFalse(carList.contains(car));
    }


}