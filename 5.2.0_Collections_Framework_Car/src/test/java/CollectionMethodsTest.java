import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CollectionMethodsTest {
    private CollectionMethods<Car> carList;

    @Before
    public void setUp() {
        carList = new CarHashSet<>();
        for (int i = 0; i < 100; i++){
            carList.add(new Car());
        }
    }

    @Test
    public void testForeach(){
        int index = 0;
        for (Car car : carList){
            index++;
        }
        assertEquals(100, index);
    }
}