import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> rndNumbers = new ArrayList<>();
        rnd(rndNumbers);
        print(rndNumbers);

        List<String> lst = rndNumbers.stream()
                .filter(num -> num % 2 == 0 && num % 5 == 0)
                .map(Math::sqrt)
                .map(num -> "Root: " + num)
                .collect(Collectors.toList());
        System.out.println("\n");
        print(lst);

    }
    private static void rnd(List<Integer> lst){
        for (int i = 0; i<1000; i++) {
            lst.add((int) (Math.random() * 100 + 100));
        }
    }

    private static <T> void print(List<T> lst){
        for (T elem : lst){
            System.out.print(elem + " ");
        }
    }
}
