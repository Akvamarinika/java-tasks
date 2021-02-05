import java.util.TreeSet;
import java.util.Set;
import java.util.Comparator;

public class Main {
    public static void main(String[] args){
        Set<Car> cars = new TreeSet<>(new Comparator<Car>(){
            @Override
            public int compare(Car car1, Car car2) {
                return -car1.getBrand().toString().compareTo(car2.getBrand().toString());

            }
        });

        for(int i = 0; i < 100; i++){
            cars.add(new Car());
        }

        for (Car car : cars){
            System.out.print(car);
        }
        System.out.println(cars.size());
    }
}
