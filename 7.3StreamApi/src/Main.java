import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            numbers.add((int) (Math.random() * 1000));
        }

        List<String> filtered = numbers.stream()
                .filter(num -> num % 2 == 0)
                .map(num -> "Number: " + num)
                .filter(str -> str.endsWith("0"))
                .map(str -> str + "?")
                .collect(Collectors.toList());
        print(filtered);
    }

    private static <T> void print(List<T> lst){
        for (T elem : lst){
            System.out.print(elem + " ");
        }
    }
}
