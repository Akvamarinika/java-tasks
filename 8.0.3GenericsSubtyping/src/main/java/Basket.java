import java.util.ArrayList;
import java.util.List;

public class Basket<T extends Fruit>{
    private List<T> basket = new ArrayList<>();

    public double getWeight(){
        double total = 0;
        for (T fruit : basket){
            total += fruit.weight;
        }
        return total;
    }

    public void add(T fruit){
        basket.add(fruit);
    }

    public int compare(Basket<? extends Fruit> other){
        if (getWeight() > other.getWeight()){
            return 1;
        } else if (getWeight() < other.getWeight()){
            return -1;
        }else {
            return 0;
        }
    }

    public static <E extends Fruit> void transfer(Basket<? extends E> src, Basket<E> dct){
        dct.basket.addAll(src.basket);
        src.basket.clear();
    }
}
