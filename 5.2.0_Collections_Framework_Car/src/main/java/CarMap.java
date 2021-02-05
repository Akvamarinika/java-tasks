import java.util.Set;
import java.util.List;

public interface CarMap {
    void put(CarOwner key, Car value);
    Car get(CarOwner key);
    Set<CarOwner> keySet();
    List<Car> values();
    boolean remove(CarOwner key);
    int size();
    void clear();
}
