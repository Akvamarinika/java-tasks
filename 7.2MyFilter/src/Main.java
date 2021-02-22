import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            numbers.add((int) (Math.random() * 1000));
        }

        List<Integer> result = filter(numbers, (n) -> n % 2 == 0);
        print(result);

        Predicate predicate = new Predicate(){
            @Override
            public boolean test(int a) {
                return a % 5 == 0;
            }
        };

        System.out.println("\n");
        result = filter(numbers, predicate);
        print(result);
    }

    private static List<Integer> filter(List<Integer> lst, Predicate predicate){
        List<Integer> filtered = new ArrayList<>();

        for (int number : lst){
            if (predicate.test(number)){
                filtered.add(number);
            }
        }
        return filtered;
    }

    private static <T> void print(List<T> lst){
        for (T elem : lst){
            System.out.print(elem + " ");
        }
    }
}
