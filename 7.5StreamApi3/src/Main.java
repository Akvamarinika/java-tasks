import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Mike", 27));
        users.add(new User("Alex", 16));
        users.add(new User("Aleksandr", 45));
        users.add(new User("Victor", 41));
        users.add(new User("Helen", 18));
        users.add(new User("Artem", 33));
        users.add(new User("Helga", 40));
        users.add(new User("Kate", 25));

        long count = users.stream().count();
        System.out.println("Count users: " + count);

        boolean isGoToCinema = users.stream().allMatch(user -> user.getAge() > 18);
        System.out.println("Go to cinema on film 18+? " + isGoToCinema);

        boolean hasAdultInCompany = users.stream().anyMatch(user -> user.getAge() > 18);
        System.out.println("Does company have adult user? " + hasAdultInCompany);

        isGoToCinema = users.stream().noneMatch(user -> user.getAge() <= 18);
        System.out.println("Go to cinema on film 18+? " + isGoToCinema);

        users.stream()
                .sorted((user1, user2) -> user2.getAge() - user1.getAge())
                .limit(3)
                .forEach(System.out::println);

        users.stream()
                .sorted(Comparator.comparing(User::getName))
                .filter(user -> user.getAge() < 40)
                .limit(3)
                .map(User::getName)
                .forEach(System.out::println);

        Optional<User> userL = users.stream()
                .filter(user -> user.getName().startsWith("L"))
                .findFirst();
        userL.ifPresentOrElse(System.out::println, () -> System.out.println("User not found"));


    }
}
