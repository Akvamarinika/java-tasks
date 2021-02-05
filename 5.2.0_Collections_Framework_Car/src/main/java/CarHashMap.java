import java.util.List;
import java.util.Set;

public class CarHashMap implements CarMap {
    Set<CarOwner> keys;
    List<Car> values;
    int size = 0;

    @Override
    public void put(CarOwner key, Car value) {

    }

    @Override
    public Car get(CarOwner key) {
        return null;
    }

    @Override
    public Set<CarOwner> keySet() {
        return null;
    }

    @Override
    public List<Car> values() {
        return null;
    }

    @Override
    public boolean remove(CarOwner key) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }
}
