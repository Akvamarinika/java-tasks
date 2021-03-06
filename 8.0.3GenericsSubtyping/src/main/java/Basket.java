import java.util.ArrayList;
import java.util.List;

public class Basket<T extends Fruit>{
    private List<T> basket = new ArrayList<>();

    public float getWeight(){
        float total = 0f;
        for (T fruit : basket){
            total += fruit.weight;
        }
        return total;
    }

    public void add(T fruit){
        basket.add(fruit);
    }

    public int compare(Basket<? extends Fruit> other){
        return Float.compare(getWeight(), other.getWeight());
    }

    public static <E extends Fruit> void transfer(Basket<? extends E> src, Basket<? super E> dct){
        dct.basket.addAll(src.basket);
        src.basket.clear();
    }
}
